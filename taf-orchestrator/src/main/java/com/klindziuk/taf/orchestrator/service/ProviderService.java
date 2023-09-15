/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.service;

import com.klindziuk.taf.orchestrator.model.request.GenerateProjectRequest;
import com.klindziuk.taf.orchestrator.model.response.TafModulesResponse;
import reactor.core.publisher.Mono;

public interface ProviderService {

  Mono<TafModulesResponse> getTafModules();

  Mono<byte[]> retrieveZipProject(GenerateProjectRequest generateProjectRequest);
}
