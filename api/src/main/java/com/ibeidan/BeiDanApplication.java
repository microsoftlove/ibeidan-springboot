package com.ibeidan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lee
 * DATE 2020/7/6 17:22
 */
@SpringBootApplication//same as @Configuration @EnableAutoConfiguration @ComponentScan
public class BeiDanApplication {


    public static void main(String[] args) {
        SpringApplication.run(BeiDanApplication.class,args);
    }


}
