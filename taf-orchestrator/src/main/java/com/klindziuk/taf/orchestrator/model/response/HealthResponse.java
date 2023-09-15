/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HealthResponse {

  private String message;
}
