package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryder on 2017/5/24.
 */
@Controller
public class ForTestController {
    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }
}
