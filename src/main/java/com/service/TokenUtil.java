package com.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.modle.User;
import com.modle.admin.Admin;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenUtil {

    private static final String sgin = "%#pwd%";

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().
                withClaim("uid", user.getUid()).
                withExpiresAt(end).
                sign(Algorithm.HMAC256(sgin));
        System.out.println(token);
        return token;
    }

    public String getToken(Admin admin) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().
                withClaim("name", admin.getName()).
                withExpiresAt(end).
                sign(Algorithm.HMAC256(sgin));
        System.out.println(token);
        return token;
    }

    //验证token
    public static DecodedJWT sgins(String token) {
//        Jwts.parser().setSigningKey(sgin)
//                .parseClaimsJws(token).getBody();
        return JWT.require(Algorithm.HMAC256(sgin)).build().verify(token); //验证token
    }

}
