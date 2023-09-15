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
public class JsTafProviderService extends TafProviderService {

  public JsTafProviderService(WebClientConfig webClientConfig, ProviderConfig providerConfig) {
    super(webClientConfig, providerConfig);
  }

  @Override
  public Mono<TafModulesResponse> getTafModules() {
    return Mono.empty();
  }

  @Override
  public Mono<byte[]> retrieveZipProject(GenerateProjectRequest generateProjectRequest) {
    return Mono.empty();
  }
}
