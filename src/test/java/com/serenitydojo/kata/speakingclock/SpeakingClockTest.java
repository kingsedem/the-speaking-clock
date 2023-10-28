package com.serenitydojo.kata.speakingclock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("The speaking clock converts local time values to a human readable version")
public class SpeakingClockTest {

    SpeakingClock  speakingClock = new SpeakingClock();
    @ParameterizedTest(name = "For time {0}, the output should be \"{1}\"")
        @CsvSource({
                "00:00, It's midnight",
                "12:00, It's midday",
                "01:00, It's one in the morning",
                "05:00, It's five in the morning",
                "09:00, It's nine in the morning",
                "13:00, It's one in the afternoon",
                "16:00, It's four in the afternoon",
                "18:00, It's six in the evening",
                "21:00, It's nine in the evening",
                "23:00, It's eleven in the evening",

        })

        @DisplayName("Times on the Hour")
        void timesOnTheHour(LocalTime inputTime, String expectedOutput){
        String renderedTime = speakingClock.tellTheTime(inputTime);
        assertThat(renderedTime).isEqualTo(expectedOutput);
        }



    @ParameterizedTest(name = "For time {0}, the output should be \"{1}\"")
    @CsvSource({
             "01:10, It's ten past one in the morning",
             "03:20, It's twenty past three in the morning",
             "08:07, It's seven past eight in the morning",
             "15:05, It's five past three in the afternoon",
             "15:25, It's twenty-five past three in the afternoon",
             "15:30, It's half past three in the afternoon",
             "15:35, It's twenty-five to four in the afternoon",
             "16:55, It's five to five in the afternoon",
             "18:09, It's nine past six in the evening",
             "18:30, It's half past six in the evening",
    })

    @DisplayName("Times with minutes")
    void timesOnTheMinutes(LocalTime inputTime, String expectedOutput){
        String renderedTime = speakingClock.tellTheTime(inputTime);
        assertThat(renderedTime).isEqualTo(expectedOutput);
    }
}

