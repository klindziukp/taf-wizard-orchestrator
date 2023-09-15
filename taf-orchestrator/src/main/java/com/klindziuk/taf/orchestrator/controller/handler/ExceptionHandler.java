/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.controller.handler;

import com.klindziuk.taf.orchestrator.constant.PropertyKey;
import com.klindziuk.taf.orchestrator.exception.TafProviderException;
import java.util.Map;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@Order(-2)
public class ExceptionHandler extends AbstractErrorWebExceptionHandler {

  public ExceptionHandler(
      ErrorAttributes errorAttributes,
      WebProperties webproperties,
      ApplicationContext applicationContext,
      ServerCodecConfigurer configurer) {
    super(errorAttributes, webproperties.getResources(), applicationContext);
    this.setMessageWriters(configurer.getWriters());
  }

  @Override
  public RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
    return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
  }

  private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
    final Map<String, Object> errorPropertiesMap =
        getErrorAttributes(request, ErrorAttributeOptions.of(Include.MESSAGE));
    final Throwable error = getError(request);
    if (TafProviderException.class.isAssignableFrom(error.getClass())) {
      return handleTafProviderException(errorPropertiesMap);
    }

    errorPropertiesMap.put(PropertyKey.MESSAGE, errorPropertiesMap.get(PropertyKey.MESSAGE));

    return handleInternalServerErrorException(errorPropertiesMap);
  }

  private Mono<ServerResponse> handleTafProviderException(Map<String, Object> errorProperties) {
    updateDefaultProperties(errorProperties, HttpStatus.BAD_REQUEST);
    return serverResponseMono(errorProperties);
  }

  private Mono<ServerResponse> handleInternalServerErrorException(
      Map<String, Object> errorProperties) {
    updateDefaultProperties(errorProperties, HttpStatus.INTERNAL_SERVER_ERROR);
    return serverResponseMono(errorProperties);
  }

  private Mono<ServerResponse> serverResponseMono(Map<String, Object> errorProperties) {
    return ServerResponse.status(HttpStatus.BAD_REQUEST)
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(errorProperties));
  }

  private void updateDefaultProperties(Map<String, Object> errorProperties, HttpStatus httpStatus) {
    errorProperties.put(PropertyKey.STATUS, httpStatus.value());
    errorProperties.put(PropertyKey.ERROR, httpStatus);
  }
}
