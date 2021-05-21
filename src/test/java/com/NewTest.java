package com;

import com.auth0.jwt.JWT;
import com.mapper.UsersMapper;
import com.modle.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewTest {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    UserService userService;

    @Test
    public void uitl(){
        Date data = new Date();
        System.out.println(data.getTime());
    }

    @Test
    public  void tokenTest(){
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTk2ODU4MDl9.Pf1leMY8-1Mn2hVvtLOT3K92OnMQ5c_eam3P6TvhM3Q";
//        Jwts.parser().setSigningKey().parseClaimsJws(token).getBody();
//        System.out.println("试试解析有没有数据 "+ JWT.decode(token).getClaim("uid").asString());
    }


    @Test
    public void go(){

}
}
