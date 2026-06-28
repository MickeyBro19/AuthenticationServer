package com.mickey.authenticationserver.security;

import com.mickey.authenticationserver.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.antlr.v4.runtime.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET="MynameismickeyandIambuildinganewprojectauthenticationserver";

    private Key getSignInKey(){
        return Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(User user){
      return Jwts.builder()
              .subject(user.getEmail())
              .claim("role",user.getRole().name())
              .issuedAt(new Date())
              .expiration(
                      new Date(
                              System.currentTimeMillis()+1000*60*60
                      )
              )
              .signWith(
                      getSignInKey()
              )
              .compact();

    }

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith((SecretKey)getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(
            String token,
            UserDetails user
    ){
        String username=extractUsername(token);
        return username.equals(user.getUsername());
    }
}
