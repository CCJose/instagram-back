package com.instagram.controller;

import com.instagram.model.dto.TokenDTO;
import com.instagram.model.dto.UserDTO;
import com.instagram.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("login")
    public ResponseEntity<TokenDTO> createToken(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(loginService.getToken(userDTO));
    }

}
