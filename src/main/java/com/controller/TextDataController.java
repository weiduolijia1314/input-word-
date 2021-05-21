package com.controller;

import com.service.TextDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("mod")
public class TextDataController {

    @Autowired
    TextDataService textDataService;

    @RequestMapping("/text")
    public Map<String,Object> getText(){
        return textDataService.getText();
    }
}
