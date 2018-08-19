package com.hazloakki.analitica.api;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OfertasAnaliticaApiExceptionHandler {

  @ExceptionHandler(OfertasAnaliticaException.class)
  public HttpEntity cuentaNotFound(OfertasAnaliticaException exception) {
    HashMap<String, Object> body = new HashMap<>();
    body.put("id", exception.getId());
    body.put("message", exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }

}
