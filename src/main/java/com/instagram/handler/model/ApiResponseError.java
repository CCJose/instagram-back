package com.instagram.handler.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ApiResponseError {

    private final String timestamp = LocalDateTime.now().toString();
    private final HttpStatus httpStatus;
    private final int errorCode;
    private final String message;
}
