package com.violet.runnerleaderboard.model;


public class Pace {


    private Integer userId;
    private Integer totalTime;
    private Long distance;



    public Pace(Integer userId, Integer totalTime, Long distance) {
        this.userId = userId;
        this.totalTime = totalTime;
        this.distance = distance;
    }

    public Pace() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

}
