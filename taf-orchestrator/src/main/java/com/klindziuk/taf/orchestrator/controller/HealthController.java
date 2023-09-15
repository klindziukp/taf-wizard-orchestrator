/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.controller;

import com.klindziuk.taf.orchestrator.controller.anno.HealthApiInfo;
import com.klindziuk.taf.orchestrator.model.response.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthController {

  @GetMapping("health")
  @HealthApiInfo
  public Mono<HealthResponse> health() {
    return Mono.just(new HealthResponse().setMessage("Healthy!"));
  }
}
