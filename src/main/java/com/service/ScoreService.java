package com.service;

import com.mapper.ScoreMapper;
import com.modle.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    public Map<String, Object> score(Score score, HttpServletRequest request) {
        score.setIp(request.getRemoteAddr());
        score.setTime(String.valueOf(new Date().getTime()));
        Map<String, Object> data = new HashMap<>();
        try {
            scoreMapper.insert(score);
            data.put("code", 1);
            return data;
        } catch (NullPointerException e) {
            e.printStackTrace();
            data.put("code", 101);
        } catch (Exception e) {
            e.printStackTrace();
            data.put("code", -1);
        }
        return data;
    }

}
