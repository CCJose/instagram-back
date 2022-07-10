package com.instagram.handler;

import com.instagram.handler.exception.InstagramException;
import com.instagram.handler.model.ApiResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class InstagramExceptionHandler {

    @ExceptionHandler({InstagramException.class})
    public ResponseEntity<ApiResponseError> handleInstagramException(InstagramException instagramException) {
        log.error(instagramException.getErrorCode().getMessage());
        return buildResponse(instagramException);
    }

    private ResponseEntity<ApiResponseError> buildResponse(InstagramException exception) {
        return new ResponseEntity(new ApiResponseError(
                exception.getErrorCode().getHttpCode(),
                exception.getErrorCode().getErrorCode(),
                exception.getErrorCode().getMessage()),
                exception.getErrorCode().getHttpCode());
    }
}
