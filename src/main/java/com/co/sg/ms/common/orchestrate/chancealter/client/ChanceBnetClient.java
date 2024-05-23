package com.co.sg.ms.common.orchestrate.chancealter.client;

import com.co.sg.ms.common.orchestrate.providers.codesa.dto.request.ParametrosBnetRequest;
import com.co.sg.ms.common.orchestrate.providers.codesa.dto.response.ParametrosBnetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@FeignClient(name = "chanceBnetClient", url = "https://dev-superflex-me.codesa.com.co/mt-api/api-ms-apuestas/chance")
public interface ChanceBnetClient {

    @PostMapping("/parametros-bnet")
    Mono<ParametrosBnetResponse> consultarParametrosBnet(@RequestBody ParametrosBnetRequest request);
}
