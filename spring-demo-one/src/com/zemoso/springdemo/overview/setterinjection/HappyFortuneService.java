package com.zemoso.springdemo.overview.setterinjection;

public class HappyFortuneService implements FortuneService {



    @Override
    public String getFortune() {
        return "You have a good fortune today";
    }
}
