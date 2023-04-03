package com.example.smart_admin.Utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * JwtUtil
 */
public class JWTUtil {

    /**
     * 私钥生成Token
     * @param oriInfo
     * @param privateKey
     * @param expire      过期时间,单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(String oriInfo, PrivateKey privateKey, int expire)  {
        return Jwts.builder()
                .claim("info",oriInfo)
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256,privateKey)
                .compact();
    }

    /**
     * 从token中获取原始信息
     * @param token
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String getInfoFromToken(String token, PublicKey publicKey)  {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return body.get("info")+"";
    }
}