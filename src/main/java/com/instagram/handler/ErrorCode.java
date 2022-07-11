package com.instagram.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  UNAUTHORIZED(1_000, HttpStatus.UNAUTHORIZED, "unauthorized");

  private final int errorCode;
  private final HttpStatus httpCode;
  private final String message;
}
