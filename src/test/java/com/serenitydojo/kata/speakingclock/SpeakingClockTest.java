package com.serenitydojo.kata.speakingclock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpeakingClockTest {

    @DisplayName("The speaking clock converts localtime values to a human readable version")

    @Test
     void midnight(){
        SpeakingClock  speakingClock = new SpeakingClock();
        String renderedTime =  speakingClock.tellTheTime(LocalTime.of(0,0));
        assertThat(renderedTime).isEqualTo("It's midnight");
    }

    @Test
    void midday(){
        SpeakingClock  speakingClock = new SpeakingClock();
        String renderedTime =  speakingClock.tellTheTime(LocalTime.of(12,0));
        assertThat(renderedTime).isEqualTo("It's midday");
    }

    @Test
    void aTimeInTheMorning(){
        SpeakingClock  speakingClock = new SpeakingClock();
        String renderedTime = speakingClock.tellTheTime(LocalTime.of(1, 0));
        assertThat(renderedTime).isEqualTo("It's one in the morning");
    }

    @ParameterizedTest(name = "For time {0}, the output should be \"{1}\"")
        @CsvSource({
                "00:00, It's midnight",
                "12:00, It's midday",
                "01:00, It's one in the morning",
                "05:00, It's five in the morning",
                "13:00, It's one in the afternoon",
                "18:00, It's six in the evening",
                "21:00, It's nine in the evening",
        })

        @DisplayName("Times on the Hour")
        void timesOnTheHour(LocalTime inputTime, String expectedOutput){
        SpeakingClock  speakingClock = new SpeakingClock();
        String renderedTime = speakingClock.tellTheTime(inputTime);
        assertThat(renderedTime).isEqualTo(expectedOutput);
        }



    @ParameterizedTest(name = "For time {0}, the output should be \"{1}\"")
    @CsvSource({
            "01:10, It's ten past one in the morning",
             "03:20, It's twenty past three in the morning",
             "15:05, It's five past three in the afternoon",
             "15:25, It's twenty-five past three in the afternoon",
             "15:30, It's half past three in the afternoon",
             "15:35, It's twenty-five to four in the afternoon",
             "16:55, It's five to five in the afternoon",
    })

    @DisplayName("Times with minutes")
    void timesOnTheMinutes(LocalTime inputTime, String expectedOutput){
        SpeakingClock  speakingClock = new SpeakingClock();
        String renderedTime = speakingClock.tellTheTime(inputTime);
        assertThat(renderedTime).isEqualTo(expectedOutput);
    }
}

