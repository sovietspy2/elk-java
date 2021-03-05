package com.example.demo.controller;

import com.example.demo.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;



    @GetMapping("/")
    public String test() throws Exception {
        mainService.process();
        return "ok";
    }



}
