/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.controller;

import com.klindziuk.taf.orchestrator.model.ProjectPlatform;
import com.klindziuk.taf.orchestrator.model.response.TafModulesResponse;
import com.klindziuk.taf.orchestrator.service.ProjectGenerationService;
import com.klindziuk.taf.orchestrator.service.ProviderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class TafOrchestratorModuleController {

  private final ProjectGenerationService projectService;

  @Autowired
  public TafOrchestratorModuleController(ProjectGenerationService projectService) {
    this.projectService = projectService;
  }

  @GetMapping("api/v1/modules/{projectPlatform}")
  public Mono<TafModulesResponse> getTafModules(
      @PathVariable("projectPlatform") ProjectPlatform projectPlatform) {
    verifyPlatform(projectPlatform);
    final ProviderService providerService = projectService.providerService(projectPlatform);
    return providerService.getTafModules();
  }

  private void verifyPlatform(ProjectPlatform projectPlatform) {
    log.info("Verifying platform: {}", projectPlatform);
    if (!ProjectPlatform.JAVA.equals(projectPlatform)
        && !ProjectPlatform.MOCK.equals(projectPlatform)) {
      throw new RuntimeException("Unsupported platform - " + projectPlatform.name());
    }
  }
}
