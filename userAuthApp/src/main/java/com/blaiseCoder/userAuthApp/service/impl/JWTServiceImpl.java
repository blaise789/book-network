package com.blaiseCoder.userAuthApp.service.impl;

//import io.jsonwebtoken.Jwt;

import com.blaiseCoder.userAuthApp.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl  implements JWTService {
    public String generateJwtToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*24)).signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    public Key getSignKey(){
        byte[] key= Decoders.BASE64.decode("blaise");
        return Keys.hmacShaKeyFor(key);
    }
    private Claims extractAllClaims(String token){

   return Jwts
           .parserBuilder()
           .setSigningKey(getSignKey())
           .build()
           .parseClaimsJws(token)
           .getBody();
    }
    private <T> T extractClaim(String token, Function<Claims,T> claimResolvers){
        final Claims claims=extractAllClaims(token);
        return claimResolvers.apply(claims);


    }
    public String extractUsername(String token){

        return extractClaim(token,Claims::getSubject);

    }
    public  boolean isTokenValid(String token,UserDetails userDetails){
        String username=extractUsername(token);
    return username.equals(userDetails.getUsername())&&!isTokenExpired(token);

    }
    public boolean isTokenExpired(String token){
       return extractClaim(token,Claims::getExpiration).before(new Date());


    }
}
