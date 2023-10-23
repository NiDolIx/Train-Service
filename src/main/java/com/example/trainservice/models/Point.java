package com.example.trainservice.models;

import java.time.LocalDateTime;

public class Point {
    private Long idPoint;
    private String namePoint;
    private LocalDateTime timeArrivalPoint;
    private LocalDateTime timeDeparturePoint;

    public Point() { }

    public Point(Long idPoint, String namePoint, LocalDateTime timeArrivalPoint, LocalDateTime timeDeparturePoint) {
        this.idPoint = idPoint;
        this.namePoint = namePoint;
        this.timeArrivalPoint = timeArrivalPoint;
        this.timeDeparturePoint = timeDeparturePoint;
    }

    public Long getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Long idPoint) {
        this.idPoint = idPoint;
    }

    public String getNamePoint() {
        return namePoint;
    }

    public void setNamePoint(String namePoint) {
        this.namePoint = namePoint;
    }

    public LocalDateTime getTimeArrivalPoint() {
        return timeArrivalPoint;
    }

    public void setTimeArrivalPoint(LocalDateTime timeArrivalPoint) {
        this.timeArrivalPoint = timeArrivalPoint;
    }

    public LocalDateTime getTimeDeparturePoint() {
        return timeDeparturePoint;
    }

    public void setTimeDeparturePoint(LocalDateTime timeDeparturePoint) {
        this.timeDeparturePoint = timeDeparturePoint;
    }
}
