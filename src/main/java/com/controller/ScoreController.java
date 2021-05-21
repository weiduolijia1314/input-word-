package com.controller;

import com.modle.Score;
import com.service.ScoreService;
import com.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("mod")
@RestController
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("/score")
    public Map<String, Object> score(@RequestBody Score score, HttpServletRequest request) {
        return scoreService.score(score, request);
    }

}
