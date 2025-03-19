package com.example.scooter_hiring.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_STRING = "your_secret_key_should_be_long_and_secure"; // 密钥字符串
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8)); // 生成 SecretKey
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    public static String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // 设置主题（新 API）
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间（新 API）
                .signWith(SECRET_KEY) // 签名
                .compact();
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY) // 验证密钥（新 API）
                .build()
                .parseSignedClaims(token) // 解析令牌（新 API）
                .getPayload();
    }

    public static boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }

    public static String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }
}