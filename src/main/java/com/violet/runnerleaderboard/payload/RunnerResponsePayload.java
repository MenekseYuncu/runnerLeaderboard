package com.violet.runnerleaderboard.payload;

import com.violet.runnerleaderboard.model.Pace;
import com.violet.runnerleaderboard.model.User;

public class RunnerResponsePayload {
    private Integer userId;
    private String username;
    private Integer age;
    private Long distance;
    private Double avgPace;
    private Integer totalTime;

    public RunnerResponsePayload(
            User user,
            Pace pace,
            Double avgPace
            ) {
        this.userId = user.getUserId();
        this.username = user.getUserName();
        this.age = user.getAge();
        this.distance = pace.getDistance();
        this.totalTime = pace.getTotalTime();
        this.avgPace = avgPace;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public Long getDistance() {
        return distance;
    }

    public Double getAvgPace() {
        return avgPace;
    }

    public Integer getTotalTime() {
        return totalTime;
    }
}
