/*
 * Archivo que contiene el código de
 * la clase ChanceService
 *
 * NO MODIFICAR O ELIMINAR AVISOS COPYRIGHT O ESTE ENCABEZADO DEL ARCHIVO.
 *
 * Este código es software propietario, no puede redistribuirlo y / o modificarlo
 * sin previo permiso.
 *
 * @date 17/05/2024
 */

package com.co.sg.ms.common.orchestrate.chance.services;

import com.co.sg.ms.common.orchestrate.chance.dto.request.ConfirVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ParametrosRequest;
import com.co.sg.ms.common.orchestrate.chance.dto.request.ValidVentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.comun.dto.ContextServer;
import com.co.sg.ms.common.orchestrate.comun.services.ITransaccionService;
import com.co.sg.ms.common.orchestrate.comun.utils.Constantes.SubProductos;
import com.co.sg.ms.common.orchestrate.comun.utils.excepciones.ServiceException;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ValidaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ValidaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.VentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.VentaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ParametrosBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import com.co.sg.ms.common.orchestrate.chance.entities.ChanceVenta;
import com.co.sg.ms.common.orchestrate.chance.repository.ChanceVentaRepository;
import com.co.sg.ms.common.orchestrate.chance.entities.ChanceDetVenta;
import com.co.sg.ms.common.orchestrate.chance.repository.ChanceDetVentaRepository;
import com.co.sg.ms.common.orchestrate.comun.utils.Constantes.ConstanteStatus;
import com.co.sg.ms.common.orchestrate.comun.utils.FechaUtils;
import com.co.sg.ms.common.orchestrate.comun.utils.MetodosGenerales;
import com.co.sg.ms.common.orchestrate.providers.codesa.services.IChanceBnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @class ChanceService
 * @description Clase encargada de contener todos los servicios de Chance.
 * @author David Forero
 * @version 1.0 17/05/2024 Documentación y creación de la clase.
 */
@Service
public class ChanceService implements IChanceService {

    @Autowired
    private IChanceBnetService chanceBnetService; //Referencia a ChanceBnetService.

    @Autowired
    private ChanceVentaRepository chanceVentaRepository; //Referencia a ChanceVentaRepository.

    @Autowired
    private ChanceDetVentaRepository chanceDetVentaRepository; //Referencia a ChanceDetVentaRepository.

    @Autowired
    private ITransaccionService transaccionService; //Refirencia a TransaccionService.

    /*
     * @function consultarParametrosBnet
     * @description Servicio encargado de guardar la respuesta de parametros Bnet.
     * @param {ParametrosRequest} data
     * @return {Mono<ParametrosBnetResponse>} response
     */
    @Override
    public Mono<ParametrosBnetResponse> consultarParametrosBnet(ParametrosRequest data) {

        //parametros para la logica de georeferenciacion;
        ContextServer context = ContextServer.getContextServer();
        context.setNumeroDocumento(data.getNumeroDocumento());
        context.setLatitud(data.getLatitud());
        context.setLongitud(data.getLongitud());

        ParametrosBnetRequest request = new ParametrosBnetRequest();
        request.setSemanario("N");
        request.setFechaSorteo(FechaUtils.consularFechaActual());

        Mono<ParametrosBnetResponse> response = chanceBnetService.consultarParametrosBnet(request);
        return response;
    }

    /*
     * @function validarChanceBnet
     * @description Servicio encargado de guardar la respuesta de pre-venta para Chance.
     * @param {ValidListChanceBnetRequest} data
     * @return {Mono<ValidaChanceBnetResponse>} response
     */
    @Override
    public Mono<ValidaChanceBnetResponse> validarChanceBnet(ValidVentaChanceBnetRequest data) {

        ValidaChanceBnetRequest validaChance = new ValidaChanceBnetRequest();
        validaChance.setNumeros(new ArrayList<String>());
        validaChance.setCodigosModalidades(new ArrayList<Long>());
        validaChance.setLoterias(new ArrayList<ValidaChanceBnetRequest.Loteria>());

        int num = 0;
        for (ValidVentaChanceBnetRequest.ListApuesta valLoteria : data.getListApuestas()) {
            validaChance.getLoterias().add(num, new ValidaChanceBnetRequest.Loteria());
            validaChance.getNumeros().add(valLoteria.getNumero());
            validaChance.getLoterias().get(num).setCodigo(valLoteria.getCodigoLoteria());
            validaChance.getLoterias().get(num).setFechaSorteo(FechaUtils.consularFechaActual());
            validaChance.getCodigosModalidades().add(valLoteria.getModalidadJuego());
            num++;
        }

        validaChance.setValor(data.getValor());
        validaChance.setSemanario(false);
        validaChance.setDistribucion(false);
        validaChance.setFechaSorteo(FechaUtils.consularFechaActual());
        validaChance.setSubProductoId(data.getSubProductoId());
        Mono<ValidaChanceBnetResponse> response = chanceBnetService.validarChanceBnet(validaChance);
        return response;
    }

    /*
     * @function realizarVentaChanceBnet
     * @description Servicio encargado de guardar la respuesta de venta para Chance.
     * @param {ListApuestasBnetRequest} request
     * @return {ListApuestasBnetResponse} ventaChanceResponse
     */
    @Override
    public Mono<List<VentaChanceBnetResponse>> realizarVentaChanceBnet(ConfirVentaChanceBnetRequest request){
        long transaccionSG = transaccionService.generarTransaccionSg();

        // Crear una lista para almacenar los Monos de cada venta
        List<Mono<VentaChanceBnetResponse>> monos = new ArrayList<>();

        request.getVentaChance().forEach(venta -> {
            try {
                long transaccion = Long.parseLong(transaccionService.generarTransaccion());
                venta.setAsumeIva(false);
                venta.setFechaSorteo(FechaUtils.consularFechaActual());
                venta.setSemanario(false);
                venta.setDistribucion(false);
                venta.getApuestas().getLista().forEach(listaAPuestas -> {
                    listaAPuestas.setFechaSorteo(FechaUtils.consularFechaActual());
                });
                venta.setEsRecomendado(false);
                venta.setVentaDirecta(false);
                venta.setNumeroTransaccionCliente(transaccion);
                venta.setCanalDigital(true);
                registrarVentaChanceBnet(venta, transaccionSG);

                // Crear y agregar el Mono a la lista
                Mono<VentaChanceBnetResponse> response = chanceBnetService.realizarVentaChanceBnet(venta)
                        .doOnNext(ventaChanceResponse -> {
                            actualizarVentaChanceBnet(ventaChanceResponse, transaccion);
                        })
                        .doOnError(error -> {

                            System.err.println("Error realizando la venta: " + error.getMessage());
                            throw new ServiceException(error.getMessage());
                        });

                monos.add(response);
            } catch (NumberFormatException e) {
                System.err.println("Error en el formato del número de transacción: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error general durante la venta: " + e.getMessage());
            }
        });

        // Combinar todos los Monos en un solo Mono que emite una lista de resultados
        return Mono.zip(monos, resultados -> {
            return Arrays.stream(resultados)
                    .map(result -> (VentaChanceBnetResponse) result)
                    .collect(Collectors.toList());
        });
    }

    /*
     * @function registrarVentaChanceBnet
     * @description Servicio encargado de registrar la venta de Chance en base de datos.
     * @param {VentaChanceBnetRequest} request
     * @param {long} transaccionSG
     */
    public void registrarVentaChanceBnet(VentaChanceBnetRequest request, long transaccionSG) {

        ContextServer context = ContextServer.getContextServer();

        ChanceVenta chanceVenta = new ChanceVenta();
        chanceVenta.setTransaccionCanalDig(transaccionSG);
        chanceVenta.setTransaccionId(request.getNumeroTransaccionCliente());
        chanceVenta.setFecha(LocalDate.now());
        chanceVenta.setHora(FechaUtils.consultarHoraActual());
        chanceVenta.setValorTotal(request.getValorTotal());
        chanceVenta.setEstado(ConstanteStatus.PENDIENTE);
        chanceVenta.setNit("123445666-1");
        chanceVenta.setSubproductoId(SubProductos.SUBPRODUCTO_CHANCE);
        chanceVenta.setCiudad("CALI");
        chanceVenta.setDepartamento("VALLE DEL CAUCA");
        chanceVenta.setColaboradorId(1l);
        chanceVenta.setTipoDocumento("CC");
        chanceVenta.setIdentificacion(context.getNumeroDocumento());
        chanceVenta.setCuentaCelular("3113067035");
        chanceVenta.setUsuario("David Forero");
        chanceVenta.setVendedor("CA1112222");
        chanceVenta.setLatitud(context.getLatitud());
        chanceVenta.setLongitud(context.getLongitud());
        chanceVentaRepository.save(chanceVenta);

    }

    /*
     * @function actualizarVentaChanceBnet
     * @description Servicio encargado de registrar el detalle de la venta de Chance en base de datos.
     * @param {VentaChanceBnetResponse} response
     * @param {long} transaccion
     */
    public void actualizarVentaChanceBnet(VentaChanceBnetResponse response, long transaccion){

        ChanceVenta chance = chanceVentaRepository.getVentaChance(transaccion);
        int total = MetodosGenerales.eliminarPunto(response.getVentaCanalDigital().getTotal());
        int iva = MetodosGenerales.eliminarPunto(response.getVentaCanalDigital().getIva());
        int valorNeto = MetodosGenerales.eliminarPunto(response.getVentaCanalDigital().getSubTotal());

        chance.setValorTotal(total);
        chance.setValorIva(iva);
        chance.setValorNeto(valorNeto);
        chance.setEstado(ConstanteStatus.APROBADA);
        chance.setConsecutivo(String.valueOf(response.getVentaCanalDigital().getIdTransaccion()));
        chance.setFrm(response.getVentaCanalDigital().getFrm());
        chance.setCodSeguridad(response.getVentaCanalDigital().getCodigoSeguridad());
        chance.setLoterias(response.getVentaCanalDigital().getLoterias().toString());
        chanceVentaRepository.save(chance);

        response.getVentaCanalDigital().getApuestas().forEach(detApuesta -> {
            ChanceDetVenta chanceDetVenta = new ChanceDetVenta();
            chanceDetVenta.setChanceId(chance.getChanceId());
            chanceDetVenta.setNumeroApostado(Integer.parseInt(detApuesta.getNumero()));
            chanceDetVenta.setValorApostado(Integer.parseInt(detApuesta.getValor()));
            chanceDetVenta.setModoJuego(detApuesta.getJuego());
            chanceDetVentaRepository.save(chanceDetVenta);
        });
    }
}
