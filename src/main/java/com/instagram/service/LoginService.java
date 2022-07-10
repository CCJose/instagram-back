package com.instagram.service;

import com.instagram.handler.ErrorCode;
import com.instagram.handler.exception.InstagramException;
import com.instagram.security.TokenManager;
import com.instagram.security.model.UserSecurity;
import com.instagram.security.service.UserSecurityService;
import com.instagram.model.dto.TokenDTO;
import com.instagram.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LoginService {

    private final UserSecurityService userSecurityService;

    private final TokenManager tokenManager;

    private final PasswordEncoder passwordEncoder;

    public TokenDTO getToken(UserDTO userDTO) {

        final UserSecurity userDetails = userSecurityService.loadUserByUsername(userDTO.getUsername());

        if (!passwordEncoder.matches(userDTO.getPassword(), userDetails.getPassword())) {
            log.error("Invalid password");
            throw new BadCredentialsException("Invalid password");
        }

        return new TokenDTO(tokenManager.generateJwtToken(userDetails));
    }
}
