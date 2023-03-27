package com.itempander.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TokenTests {

    private static final String SECRET_KEY = "your_secret_key";
    private static final long EXPIRATION_TIME = 86400000;

    @Test
    public void generateToken(){

        //날짜
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);


        System.out.println("test : " +  Jwts.builder()
                .setSubject("Test")
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact());

    }

    @Test
    public void getUsernameFromToken(){

    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZXN0IiwiaWF0IjoxNjc5OTI0ODc5LCJleHAiOjE2ODAwMTEyNzl9.OJqXwh6Ao5dBHT8QVIvtmj9Gafztf5hsnFZAO1uhDNhUDaM0XXqeo_vXgIscJwILmjTga4J2Aq4QCUjr-EZJzQ";

    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        System.out.println("claims :  " + claims);

    }
}
