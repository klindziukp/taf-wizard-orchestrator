/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.mock.provider.controller;

import com.klindziuk.taf.mock.provider.model.project.ProjectConfiguration;
import com.klindziuk.taf.mock.provider.model.project.TafModule;
import com.klindziuk.taf.mock.provider.model.project.TafModuleGroup;
import com.klindziuk.taf.mock.provider.model.response.TafModulesResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Available platform modules controller")
public class TafMockModuleController {

  @GetMapping("api/v1/provider/modules")
  public Mono<TafModulesResponse> getTafModules() {
    return Mono.just(generateGetModuleResponse(3, 4));
  }

  private TafModulesResponse generateGetModuleResponse(
      int groupConfigSize, int modulePerGroupSize) {
    final List<TafModuleGroup> tafModuleGroups = new ArrayList<>();
    final List<ProjectConfiguration> projectConfigurations = new ArrayList<>();

    for (int i = 0; i < groupConfigSize; i++) {
      projectConfigurations.add(
          new ProjectConfiguration()
              .setValue("project-configuration-mock-value-" + i)
              .setRequired(System.currentTimeMillis() % 2 == 0));
      final TafModuleGroup tafModuleGroup =
          new TafModuleGroup()
              .setId("taf-module-group-mock-group-id-" + i)
              .setName("taf-module-group-mock-name-" + i)
              .setDescription("module-group-mock-description-" + i);
      final List<TafModule> tafModules = new ArrayList<>();
      for (int j = 0; j < modulePerGroupSize; j++) {
        tafModules.add(
            new TafModule()
                .setId("taf-module-mock-id-" + j)
                .setDisplayName("taf-module-mock-name-" + j));
      }
      tafModuleGroup.setTafModules(tafModules);
      tafModuleGroups.add(tafModuleGroup);
    }
    return new TafModulesResponse()
        .setPlatform("MOCK")
        .setProjectConfigurations(projectConfigurations)
        .setTafModuleGroups(tafModuleGroups);
  }
}
