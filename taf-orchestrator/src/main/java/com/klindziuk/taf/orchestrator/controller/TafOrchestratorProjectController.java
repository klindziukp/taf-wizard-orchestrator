/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.controller;

import com.klindziuk.taf.orchestrator.model.request.GenerateProjectRequest;
import com.klindziuk.taf.orchestrator.service.ProjectGenerationService;
import com.klindziuk.taf.orchestrator.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TafOrchestratorProjectController {

  private final ProjectGenerationService projectService;

  @Autowired
  public TafOrchestratorProjectController(ProjectGenerationService projectGenerationService) {
    this.projectService = projectGenerationService;
  }

  @PostMapping("api/v1/zip")
  private Mono<ResponseEntity<byte[]>> generateProject(
      @RequestBody GenerateProjectRequest generateProjectRequest) {
    ProviderService providerService =
        projectService.providerService(generateProjectRequest.getProjectPlatform());
    // TODO(pklindziuk): update project generation name(make it required)
    final String disposition =
        "attachment; filename=%s.zip".formatted("orchestrated-" + System.currentTimeMillis());
    return providerService
        .retrieveZipProject(generateProjectRequest)
        .onErrorResume(e -> Mono.defer(() -> Mono.error(e)))
        .map(
            proj ->
                ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, disposition)
                    .body(proj));
  }
}
