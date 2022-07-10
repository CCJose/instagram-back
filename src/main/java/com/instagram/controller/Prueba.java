package com.instagram.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Prueba {
    private String hola;

    @GetMapping("/")
    public ResponseEntity<String> prueba() {
        return ResponseEntity.ok("'Prueba': 'BBBB'");
    }
}
