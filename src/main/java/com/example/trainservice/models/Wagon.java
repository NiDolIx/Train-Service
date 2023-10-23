package com.example.trainservice.models;

public class Wagon {
    private Long idWagon;
    private Long idTrain;
    private Long idTypeTrain;
    private short placeWagon;
    private String numberWagon;

    public Wagon() { }

    public Wagon(Long idWagon, Long idTrain, Long idTypeTrain, short placeWagon, String numberWagon) {
        this.idWagon = idWagon;
        this.idTrain = idTrain;
        this.idTypeTrain = idTypeTrain;
        this.placeWagon = placeWagon;
        this.numberWagon = numberWagon;
    }

    public Long getIdWagon() {
        return idWagon;
    }

    public void setIdWagon(Long idWagon) {
        this.idWagon = idWagon;
    }

    public Long getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(Long idTrain) {
        this.idTrain = idTrain;
    }

    public Long getIdTypeTrain() {
        return idTypeTrain;
    }

    public void setIdTypeTrain(Long idTypeTrain) {
        this.idTypeTrain = idTypeTrain;
    }

    public short getPlaceWagon() {
        return placeWagon;
    }

    public void setPlaceWagon(short placeWagon) {
        this.placeWagon = placeWagon;
    }

    public String getNumberWagon() {
        return numberWagon;
    }

    public void setNumberWagon(String numberWagon) {
        this.numberWagon = numberWagon;
    }
}
