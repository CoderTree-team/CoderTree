package com.code.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DemoController {

    @GetMapping(value = "/test1")
    public String test1(){

        return "这是返回的数据";
    }
}
