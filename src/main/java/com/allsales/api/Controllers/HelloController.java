package com.allsales.api.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Welcome to AllSales api";
    }

    @RequestMapping(value = "/testToken", method = RequestMethod.GET)
    public String testToken(){
        return "OK";
    }
}
