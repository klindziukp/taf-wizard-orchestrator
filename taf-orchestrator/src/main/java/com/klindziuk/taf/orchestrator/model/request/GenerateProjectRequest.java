/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model.request;

import com.klindziuk.taf.orchestrator.model.ProjectPlatform;
import com.klindziuk.taf.orchestrator.model.project.TafModuleGroup;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenerateProjectRequest {

  private ProjectPlatform projectPlatform;
  private Map<String, String> projectConfigurations;
  private List<TafModuleGroup> tafModuleGroups;
}
