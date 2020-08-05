package com.ibeidan.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping("upload")
    public String upload(@RequestBody MultipartFile multipartFile){

        return "ok";
    }
}
