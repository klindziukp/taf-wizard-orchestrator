/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.service;

import com.klindziuk.taf.orchestrator.config.ProviderConfig;
import com.klindziuk.taf.orchestrator.config.WebClientConfig;
import com.klindziuk.taf.orchestrator.model.request.GenerateProjectRequest;
import com.klindziuk.taf.orchestrator.model.response.TafModulesResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MockTafProviderService extends TafProviderService {

  public MockTafProviderService(WebClientConfig webClientConfig, ProviderConfig providerConfig) {
    super(webClientConfig, providerConfig);
  }

  @Override
  public Mono<TafModulesResponse> getTafModules() {
    return webClientConfig
        .mockWebClient()
        .get()
        .uri(providerConfig.getMockModulesPath())
        .retrieve()
        .bodyToMono(TafModulesResponse.class);
  }

  @Override
  public Mono<byte[]> retrieveZipProject(GenerateProjectRequest generateProjectRequest) {
    return webClientConfig
        .mockWebClient()
        .post()
        .uri(providerConfig.getMockProjectPath())
        .retrieve()
        .bodyToMono(byte[].class);
  }
}
