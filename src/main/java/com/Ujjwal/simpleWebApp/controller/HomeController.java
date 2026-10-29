package com.Ujjwal.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // to transfer the data, not the layout
//@Controller // use to transfer the layout of page as component
public class HomeController {

    @RequestMapping("/home")
//    @ResponseBody // with @Controller use this to return the data not page
    public String greet(){
        return "Welcome to Weather Application !!";
    }

    @RequestMapping("/about")
    public String about(){
        return "About page of Weather Application!!";
    }

}
