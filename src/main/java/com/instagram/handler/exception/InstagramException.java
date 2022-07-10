package com.instagram.handler.exception;

import com.instagram.handler.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class InstagramException extends RuntimeException {

    private ErrorCode errorCode;

}
