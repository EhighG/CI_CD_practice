package com.example.cicdpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Value("${test-arg}")
    private String testArg;

    @GetMapping("/cicd")
    public String test(@RequestParam(name = "arg", required = false) String requestParam) {
        if (requestParam == null) {
            System.out.println("no param");
            return "no param";
        }
        System.out.println("requestParam = " + requestParam);
        return requestParam;
    }

    @GetMapping("/env")
    public String checkEnv() {
        System.out.println("\n\n\ntestArg = " + testArg + "\n\n\n");
        return testArg;
    }
}
