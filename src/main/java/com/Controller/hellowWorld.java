package com.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController //标注此类为Controller
@EnableAutoConfiguration //启动自动注入
@RequestMapping("/app")
public class hellowWorld {
    @RequestMapping("/demo")
    @ResponseBody
    public Map<String, String> version(){
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("show", "Hello world");
        return result;
    }
}

