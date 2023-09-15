/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.service;

import com.klindziuk.taf.orchestrator.config.ProviderConfig;
import com.klindziuk.taf.orchestrator.config.WebClientConfig;
import com.klindziuk.taf.orchestrator.exception.TafProviderException;
import com.klindziuk.taf.orchestrator.model.request.GenerateProjectRequest;
import com.klindziuk.taf.orchestrator.model.response.TafModulesResponse;
import com.klindziuk.taf.orchestrator.model.response.error.WizardErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JavaTafProviderService extends TafProviderService {

  @Autowired
  public JavaTafProviderService(WebClientConfig webClientConfig, ProviderConfig providerConfig) {
    super(webClientConfig, providerConfig);
  }

  // TODO(pklindziuk): Add error handling for 4xx and 5xx
  @Override
  public Mono<TafModulesResponse> getTafModules() {
    return webClientConfig
        .javaWebClient()
        .get()
        .uri(providerConfig.getJavaModulesPath())
        .retrieve()
        .bodyToMono(TafModulesResponse.class);
  }

  // TODO(pklindziuk): Add error handling for 4xx and 5xx
  @Override
  public Mono<byte[]> retrieveZipProject(GenerateProjectRequest generateProjectRequest) {
    return webClientConfig
        .javaWebClient()
        .post()
        .uri(providerConfig.getJavaProjectPath())
        .body(Mono.just(generateProjectRequest), GenerateProjectRequest.class)
        .retrieve()
        .onStatus(
            HttpStatus.BAD_REQUEST::equals,
            response ->
                response
                    .bodyToMono(WizardErrorResponse.class)
                    .flatMap(
                        error ->
                            Mono.error(
                                new TafProviderException(error.getErrorMessages().toString()))))
        .bodyToMono(byte[].class);
  }
}
