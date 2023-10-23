package com.example.trainservice.models;

public class Train {
    private Long idTrain;
    private Long idRoute;
    private Long idTypeTrain;
    private String nameTrain;

    public Train() { }

    public Train(Long idTrain, Long idRoute, Long idTypeTrain, String nameTrain) {
        this.idTrain = idTrain;
        this.idRoute = idRoute;
        this.idTypeTrain = idTypeTrain;
        this.nameTrain = nameTrain;
    }

    public Long getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(Long idTrain) {
        this.idTrain = idTrain;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Long idRoute) {
        this.idRoute = idRoute;
    }

    public Long getIdTypeTrain() {
        return idTypeTrain;
    }

    public void setIdTypeTrain(Long idTypeTrain) {
        this.idTypeTrain = idTypeTrain;
    }

    public String getNameTrain() {
        return nameTrain;
    }

    public void setNameTrain(String nameTrain) {
        this.nameTrain = nameTrain;
    }
}
