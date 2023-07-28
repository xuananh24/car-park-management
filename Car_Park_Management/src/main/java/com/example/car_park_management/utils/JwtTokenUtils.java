package com.example.car_park_management.utils;

import com.example.car_park_management.security.EmployeeDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenUtils {
    private String secretKey = "anhnx";

    private Long expiration = 604800000L;

    public String createToken(EmployeeDetails employeeDetails) {
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(System.currentTimeMillis() + expiration);
        String result =  Jwts.builder()
                .setSubject(employeeDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return result;
    }


    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(this.secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return Objects.equals(username, userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Optional.ofNullable(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration())
                .map(expiration -> expiration.before(new Date()))
                .orElse(true);
    }
}
