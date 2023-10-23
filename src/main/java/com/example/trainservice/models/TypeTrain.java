package com.example.trainservice.models;

public class TypeTrain {
    private Long idTypeTrain;
    private String TypeTrain;

    public TypeTrain() { }

    public TypeTrain(Long idTypeTrain, String typeTrain) {
        this.idTypeTrain = idTypeTrain;
        TypeTrain = typeTrain;
    }

    public Long getIdTypeTrain() {
        return idTypeTrain;
    }

    public void setIdTypeTrain(Long idTypeTrain) {
        this.idTypeTrain = idTypeTrain;
    }

    public String getTypeTrain() {
        return TypeTrain;
    }

    public void setTypeTrain(String typeTrain) {
        TypeTrain = typeTrain;
    }
}
