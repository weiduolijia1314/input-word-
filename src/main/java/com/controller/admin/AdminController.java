package com.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.admin.AdminMapper;
import com.mapper.admin.UserInfoMapper;
import com.mapper.admin.UserStateMapper;
import com.modle.State;
import com.modle.User;
import com.modle.admin.Admin;
import com.modle.admin.UserInfo;
import com.modle.admin.UserState;
import com.service.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class AdminController {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserStateMapper userStateMapper;

    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/data")
    public List<UserInfo> queryAll() {
        return userInfoMapper.getAllInfo();
    }


    @RequestMapping("/state")
    public List<UserState> state() {
        return userStateMapper.state();
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody Admin admin) {
//        user.setPwd(DigestUtils.md5DigestAsHex(user.getPwd().getBytes()));
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println(admin.toString());
            Admin admins = adminMapper.selectOne(new QueryWrapper<Admin>().eq("stuno", admin.getStuno()).eq("name", admin.getName()));
            if (admins.getName() != null) {
                TokenUtil tokenUtil = new TokenUtil();
                String token = tokenUtil.getToken(admin);
                Map<String, Object> data = new HashMap<>();
                data.put("token", token);
                map.put("data", data);
                map.put("code", 1);
                map.put("msg", "ok");
                return map;
            } else {
                map.put("code", -1);
                map.put("msg", "数据库没有该信息,请检查输入是否正确");
                return map;
            }

        } catch (NullPointerException e) {
            map.put("code", -1);
            map.put("msg", "数据库没有该信息,请检查输入是否正确");
            return map;
        }

    }


}
