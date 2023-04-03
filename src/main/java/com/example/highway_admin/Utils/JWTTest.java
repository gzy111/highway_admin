package com.example.smart_admin.Utils;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JWTTest {

    //公钥
    private static final String pubKeyPath = "/Users/guanziyuan/Documents/实训三笔记/工作/jwt/rsa.pub";

    //私钥
    private static final String priKeyPath = "/Users/guanziyuan/Documents/实训三笔记/工作/jwt/rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    public static void main(String[] args) throws Exception {
        JWTTest jwtTest = new JWTTest();

//        jwtTest.testRsa();
        jwtTest.testJWT();
    }

    public void testRsa() throws Exception {
        RSAUtil.generateKey(pubKeyPath, priKeyPath, "abc");
    }


    public  void testJWT() throws Exception {
        this.publicKey = RSAUtil.getPublicKey(pubKeyPath);
        this.privateKey = RSAUtil.getPrivateKey(priKeyPath);

        //生成Token
        String token = JWTUtil.generateToken("ZHANGSAN",privateKey,20);

        System.out.println(token);

        Thread.sleep(3000);
        //解析
        String oriInfo = JWTUtil.getInfoFromToken(token,publicKey);
        System.out.println(oriInfo);

    }
}
