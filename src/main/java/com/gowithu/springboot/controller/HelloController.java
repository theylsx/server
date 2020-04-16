package com.gowithu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dav1d
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String hello(){
        return "hello";
    }
}
