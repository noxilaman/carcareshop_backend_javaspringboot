package com.noxilaman.carcareshop.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.noxilaman.carcareshop.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {
    @Value("${app.token.issuser}")
    private String issuser;

    @Value("${app.token.secret}")
    private String secret;

    public String tokenize(User user){

        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.MINUTE,60);
        Date expireAt = calendar.getTime();


        String token = JWT.create()
                .withIssuer(issuser)
                .withClaim("principal",user.getId())
                .withClaim("role","USER")
                .withExpiresAt(expireAt)
                .sign(algorithm());
        return token;
    }

    public DecodedJWT verifyToken(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm())
                    .withIssuer(issuser)
                    .build();
            return verifier.verify(token);
        }catch (Exception e){
            return null;
        }


    }

    private Algorithm algorithm(){
        return Algorithm.HMAC256(secret);
    }
}
