/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model.response;

import com.klindziuk.taf.orchestrator.model.project.ProjectConfiguration;
import com.klindziuk.taf.orchestrator.model.project.TafModuleGroup;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TafModulesResponse {

  private String platform;
  private List<ProjectConfiguration> projectConfigurations;
  private List<TafModuleGroup> tafModuleGroups;
}
