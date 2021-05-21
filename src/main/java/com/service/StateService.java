package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.StateMapper;
import com.modle.Score;
import com.modle.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StateService {

    @Autowired
    StateMapper stateMapper;


    public Map<String, Object> heart(State state) {
        state.setEndtime(String.valueOf(new Date().getTime()));
        Map<String, Object> data = new HashMap<>();
        try {
//            stateMapper.update(state,new QueryWrapper<State>().eq("id",String.valueOf(state.getUid())));
            stateMapper.updateById(state);
            data.put("code", 1);
            return data;
        } catch (NullPointerException e) {
            e.printStackTrace();
            data.put("code", 101);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            data.put("code", -1);
            return data;
        }

    }


}
