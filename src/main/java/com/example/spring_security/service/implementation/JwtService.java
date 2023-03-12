package com.example.spring_security.service.implementation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private  static final  String SECRET_KEY=
            "D*G-KaPdSgVkXp2s5v8y/B?E(H+MbQeThWmZq3t6w9z$C&F)J@NcRfUjXn2r5u7x";


    public String extractUserName(String token) {

        return  extractClaim(token,Claims::getSubject);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token).getBody();


    }

    public  <T> T extractClaim(String token , Function<Claims,T> claimsTFunction){
        final Claims  claims=extractAllClaims(token);
        return claimsTFunction.apply(claims);

    }

    private Key getSignKey() {
        byte [] bytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken( UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);


    }

    public String generateToken(Map<String ,Object> extralClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extralClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();


    }
}
