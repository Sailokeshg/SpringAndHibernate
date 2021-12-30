package com.zemoso.springdemo.overview.beanscope;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    public TrackCoach(){

    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Make 20 squats";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    //init method
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    //destroy method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }



}
