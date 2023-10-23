package com.example.trainservice.models;

import java.util.List;

public class Shedule {
    private Route route;
    private Train train;
    private TypeTrain typeTrain;
    private List<Point> points;

    public Shedule() { }

    public Shedule(Route route, Train train, TypeTrain typeTrain, List<Point> points) {
        this.route = route;
        this.train = train;
        this.typeTrain = typeTrain;
        this.points = points;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TypeTrain getTypeTrain() {
        return typeTrain;
    }

    public void setTypeTrain(TypeTrain typeTrain) {
        this.typeTrain = typeTrain;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
