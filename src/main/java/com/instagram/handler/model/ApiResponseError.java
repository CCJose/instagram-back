package com.instagram.handler.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ApiResponseError {

  private final String timestamp = LocalDateTime.now().toString();
  private final HttpStatus httpStatus;
  private final int errorCode;
  private final String message;
}
