package com.example.trainservice.models;

public class TypeWagon {
    private Long idTypeWagon;
    private String TypeWagon;

    public TypeWagon() { }

    public TypeWagon(Long idTypeWagon, String typeWagon) {
        this.idTypeWagon = idTypeWagon;
        TypeWagon = typeWagon;
    }

    public Long getIdTypeWagon() {
        return idTypeWagon;
    }

    public void setIdTypeWagon(Long idTypeWagon) {
        this.idTypeWagon = idTypeWagon;
    }

    public String getTypeWagon() {
        return TypeWagon;
    }

    public void setTypeWagon(String typeWagon) {
        TypeWagon = typeWagon;
    }
}
