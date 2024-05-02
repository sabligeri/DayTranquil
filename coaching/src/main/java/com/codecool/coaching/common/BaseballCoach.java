package com.codecool.coaching.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice baseball!";
    }

    @Component
    public static class CricketCoach implements Coach {
        @Override
        public String getDailyWorkout() {
            return "Practice cricket for 15 minutes";
        }
    }
}
