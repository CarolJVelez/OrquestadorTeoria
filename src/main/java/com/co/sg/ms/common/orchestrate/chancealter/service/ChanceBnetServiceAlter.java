package com.co.sg.ms.common.orchestrate.chancealter.service;

import com.co.sg.ms.common.orchestrate.chancealter.client.ChanceBnetClient;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ParametrosBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ValidaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.VentaChanceBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ValidaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.VentaChanceBnetResponse;
import com.co.sg.ms.common.orchestrate.providers.codesa.services.AuthCodesaService;
import com.co.sg.ms.common.orchestrate.providers.codesa.services.ChanceBnetService;
import com.co.sg.ms.common.orchestrate.providers.codesa.services.IChanceBnetService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChanceBnetServiceAlter  implements IChanceBnetService {

    private final ChanceBnetClient chanceClient;
    private final AuthCodesaService authCodesaService;

    public ChanceBnetServiceAlter(ChanceBnetClient chanceClient, AuthCodesaService authCodesaService) {
        this.chanceClient = chanceClient;
        this.authCodesaService = authCodesaService;
    }

    @Override
    public Mono<ParametrosBnetResponse> consultarParametrosBnet(ParametrosBnetRequest data) {
        return chanceClient.consultarParametrosBnet(data);
    }

    @Override
    public Mono<ValidaChanceBnetResponse> validarChanceBnet(ValidaChanceBnetRequest data) {
        return null;
    }

    @Override
    public Mono<VentaChanceBnetResponse> realizarVentaChanceBnet(VentaChanceBnetRequest data) {
        return null;
    }
}
