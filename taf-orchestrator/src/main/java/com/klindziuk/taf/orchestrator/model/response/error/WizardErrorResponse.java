/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model.response.error;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
public class WizardErrorResponse {

  private Instant time;
  private HttpStatus httpStatus;
  private String error;
  private List<String> errorMessages;
  private String requestPath;

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
        .append("message", errorMessages)
        .toString();
  }
}
