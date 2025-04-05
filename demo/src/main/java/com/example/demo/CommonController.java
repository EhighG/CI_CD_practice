package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/cicd")
    public String test(@RequestParam(name = "arg", required = false) String requestParam) {
        if (requestParam == null) {
            System.out.println("no param");
            return "no param";
        }
        System.out.println("requestParam = " + requestParam);
        return requestParam;
    }
}
