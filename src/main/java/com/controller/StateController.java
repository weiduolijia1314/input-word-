package com.controller;

import com.modle.State;
import com.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("mod")
public class StateController {

    @Autowired
    StateService stateService;

    @PostMapping("/heart")
    public Map<String,Object> heart(@RequestBody State state){
        return  stateService.heart(state);
    }
}
