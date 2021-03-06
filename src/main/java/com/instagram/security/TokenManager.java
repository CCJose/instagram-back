package com.instagram.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {

  public static final long TOKEN_VALIDITY = 3600;

  @Value("${secret}")
  private String jwtSecret;

  public String generateJwtToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public Boolean validateJwtToken(String token, UserDetails userDetails) {
    String username = getConectedUser(token);
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    Boolean isTokenExpired = claims.getExpiration().before(new Date());
    return (username.equals(userDetails.getUsername()) && !isTokenExpired);
  }

  public String getConectedUser(String token) {
    final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
