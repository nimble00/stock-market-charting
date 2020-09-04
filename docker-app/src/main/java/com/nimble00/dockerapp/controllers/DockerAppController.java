package com.nimble00.dockerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DockerAppController {
    @RequestMapping("/")
    public String goToHome()
    {
        return "index";
    }
    @RequestMapping("/hello-world")
    public String sayHello()
    {
        return "helloworld";
    }
}
