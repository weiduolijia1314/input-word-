package com.service;

import com.Main;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.StateMapper;
import com.mapper.UsersMapper;
import com.modle.State;
import com.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    StateMapper stateMapper;


    public Map<String, Object> login(User user) {

        user.setPwd(DigestUtils.md5DigestAsHex(user.getPwd().getBytes()));
        Map<String, Object> map = new HashMap<>();

        try {
            System.out.println(user.toString());
            User userdata = usersMapper.selectOne(new QueryWrapper<User>().eq("pwd", user.getPwd()).eq("name", user.getName()));
            if (userdata.getState().equals("0")) {
                userdata.setState("1");
                usersMapper.updateById(userdata);
                TokenUtil tokenUtil = new TokenUtil();
                String token = tokenUtil.getToken(user);

                State state = new State();
                state.setUid(userdata.getUid());
                state.setLogintime(String.valueOf(new Date().getTime()));
                state.setSpeed("0");
                state.setEndtime("0");
                stateMapper.insert(state);

                Map<String, Object> data = new HashMap<>();
                data.put("token", token);
                data.put("sid", state.getId());
                data.put("uid", userdata.getUid());
                data.put("face", userdata.getFace());
                data.put("name", userdata.getName());
                map.put("data", data);
                map.put("code", 1);
                map.put("msg", "ok");

                return map;
            } else {
                map.put("code", -2);
                map.put("msg", "该账户已经参与过本次比赛，每个人仅有一次机会，欢迎下次再来参加~");
            }
        } catch (NullPointerException e) {
            map.put("code", -1);
            map.put("msg", "数据库没有该信息,请检查输入是否正确");
            return map;
        }

        return map;

    }

    public Map<String, Object> add(User user) {
        user.setPwd(DigestUtils.md5DigestAsHex(user.getPwd().getBytes()));
        Map<String, Object> map = new HashMap<>();
        try {
            usersMapper.insert(user);
            map.put("code", 1);
            map.put("msg", "添加成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "添加失败");
        }
        return map;
    }


}
