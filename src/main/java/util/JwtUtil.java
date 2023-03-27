package util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "your_secret_key";
    private static final long EXPIRATION_TIME = 86400000;


    //JWT 토큰 생성
    public static String generateToken(String username) {
        //날짜
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);


        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
    
    // JWT 유효성 검증
    public static String getUsernameFromToken(String token) throws SignatureException {
        //JWT Base64로 인코딩된 Json 형식
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        //해당 Json에 Subject 값 추출
        return claims.getSubject();
    }
}
