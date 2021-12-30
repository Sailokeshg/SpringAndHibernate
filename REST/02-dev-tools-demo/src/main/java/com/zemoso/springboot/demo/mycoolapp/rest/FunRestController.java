package com.zemoso.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    @GetMapping("/")
        public String sayHello(){
        return "Time server is: "+ LocalDateTime.now();
        }
        @GetMapping("/workout")
        public String getDailyWorkout(){
        return "Run  hard !";
        }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is lucky day!";
    }




}


