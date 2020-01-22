package com.gowithu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dav1d
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
}
