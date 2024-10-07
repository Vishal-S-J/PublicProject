package com.example.springgradle.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "86d9c27721d1c79614b111db0ac692515cb8fbe207a37befa21bc751b1ec7920";
    private SecretKey secretKey;

    private SecretKey getSignInKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET_KEY);
        secretKey = Keys.hmacShaKeyFor(keyByte);
        return secretKey;
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUserName(String jwtToken) {
        return extractClaims(jwtToken, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts
                .builder()
                .claims()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .and()
                .signWith(getSignInKey(), Jwts.SIG.HS256)
                .compact();
    }
}
