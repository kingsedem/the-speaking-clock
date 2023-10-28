package com.serenitydojo.kata.speakingclock;

import java.time.LocalTime;

public class SpeakingClock {

    private static final LocalTime MIDNIGHT = LocalTime.of(0,0);
    private  static final  LocalTime MIDDAY = LocalTime.of(12,0);
    private  static final  LocalTime FIVE_PM = LocalTime.of(17,0);

    private static final String[] HOURS = {
            //Hours of the day starting with twelve
            "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven"
    };

    private static final String[] MINUTES = {
            //Minutes of the day starting with 0
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
            "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine",
            "thirty",
    };

    public String tellTheTime(LocalTime time) {
        if(time.equals(MIDNIGHT)) {
            return "It's midnight";
        }
        else if(time.equals(MIDDAY)){
            return "It's midday";
        }

        int hour = time.getHour() % 12;
        int minute = time.getMinute();

        String spokenHour = HOURS[hour];
        String spokenMinutes = "";
        if(minute > 0 && minute < 30){
            //twenty past twelve
             spokenMinutes = MINUTES[minute] + " past ";
        } else if(minute == 30){
            //half past twelve
            spokenMinutes = "half past ";

        } else if (minute > 30) {
            //twenty to twelve
            spokenMinutes = MINUTES[60 - minute] + " to ";
            spokenHour = HOURS[hour + 1];
        }
        if(time.isBefore(MIDDAY)){
            return "It's " + spokenMinutes + spokenHour + " in the morning";
        } else if(time.isBefore(FIVE_PM)){
            return "It's " + spokenMinutes + spokenHour + " in the afternoon";
        }else {
            return "It's " + spokenMinutes + spokenHour + " in the evening";
        }
    }
}
