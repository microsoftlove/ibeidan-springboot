package com.ibeidan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @DATE 2020/7/6 17:29
 */
@RestController
public class ActualConntroller {

    @RequestMapping("/home")
    String home(){
        return "hello world !";
    }
}
