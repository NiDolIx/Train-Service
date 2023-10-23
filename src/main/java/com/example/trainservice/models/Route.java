package com.example.trainservice.models;

public class Route {
    private Long idRoute;
    private String nameRoute;
    private String pointArrivalRoute;
    private String pointDepartureRoute;

    public Route() { }

    public Route(Long idRoute, String nameRoute, String pointArrivalRoute, String pointDepartureRoute) {
        this.idRoute = idRoute;
        this.nameRoute = nameRoute;
        this.pointArrivalRoute = pointArrivalRoute;
        this.pointDepartureRoute = pointDepartureRoute;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Long idRoute) {
        this.idRoute = idRoute;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public String getPointArrivalRoute() {
        return pointArrivalRoute;
    }

    public void setPointArrivalRoute(String pointArrivalRoute) {
        this.pointArrivalRoute = pointArrivalRoute;
    }

    public String getPointDepartureRoute() {
        return pointDepartureRoute;
    }

    public void setPointDepartureRoute(String pointDepartureRoute) {
        this.pointDepartureRoute = pointDepartureRoute;
    }
}
