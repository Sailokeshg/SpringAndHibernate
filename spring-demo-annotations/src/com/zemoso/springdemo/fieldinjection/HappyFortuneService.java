package com.zemoso.springdemo.fieldinjection;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Its your lucky day";
    }
}
