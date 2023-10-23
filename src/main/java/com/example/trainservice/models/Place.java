package com.example.trainservice.models;

public class Place {
    private Long idPlace;
    private Long idWagon;
    private Short numberPlace;

    public Place() { }

    public Place(Long idPlace, Long idWagon, Short numberPlace) {
        this.idPlace = idPlace;
        this.idWagon = idWagon;
        this.numberPlace = numberPlace;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public Long getIdWagon() {
        return idWagon;
    }

    public void setIdWagon(Long idWagon) {
        this.idWagon = idWagon;
    }

    public Short getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(Short numberPlace) {
        this.numberPlace = numberPlace;
    }
}
