/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.mock.provider.controller;

import com.klindziuk.taf.mock.provider.model.request.GenerateProjectRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@Tag(name = "Mocked Project generation")
public class TafMockProviderController {

  @PostMapping("api/v1/provider/zip")
  private Mono<ResponseEntity<byte[]>> generateProject(
      GenerateProjectRequest generateProjectRequest) {
    final String disposition =
        "attachment; filename=%s.zip".formatted("java-taf" + System.currentTimeMillis());
    return Mono.just(
        ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, disposition)
            .body(getZipBytes()));
  }

  private byte[] getZipBytes() {
    try {
      return Files.readAllBytes(Paths.get("taf-mock-provider/src/main/resources/mock-example.zip"));
    } catch (IOException ex) {
      log.error(
          "Unable to read bytes from path: '{}'",
          "taf-mock-provider/src/main/resources/mock-example.zip");
      throw new RuntimeException(ex);
    }
  }
}
