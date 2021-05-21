package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.TextMapper;
import com.modle.TextData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextDataService {

    @Autowired
    TextMapper textMapper;

    public Map<String, Object> getText() {
        Map<String, Object> map = new HashMap<>();
        try {
            TextData state = textMapper.selectOne(new QueryWrapper<TextData>().eq("state", 1));
            map.put("code", 1);
            map.put("msg", "ok");
            map.put("data", state.getText());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("code", -1);
        map.put("msg", "请求失败");
        return map;
    }
}
