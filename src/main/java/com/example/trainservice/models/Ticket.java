package com.example.trainservice.models;

import java.time.LocalDateTime;

public class Ticket {
    private Long idTicket;
    private Long idPassenger;
    private Long idPoint;
    private Long idPlace;
    private String pointDepartureTicket; // Дата отправления
    private String pointArrivalTicket; // Дата прибытия

    public Ticket() { }

    public Ticket(
            Long idTicket,
            Long idPassenger,
            Long idPoint,
            Long idPlace,
            String pointDepartureTicket,
            String pointArrivalTicket
    ) {
        this.idTicket = idTicket;
        this.idPassenger = idPassenger;
        this.idPoint = idPoint;
        this.idPlace = idPlace;
        this.pointDepartureTicket = pointDepartureTicket;
        this.pointArrivalTicket = pointArrivalTicket;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Long idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Long getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(Long idPoint) {
        this.idPoint = idPoint;
    }

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getPointDepartureTicket() {
        return pointDepartureTicket;
    }

    public void setPointDepartureTicket(String pointDepartureTicket) {
        this.pointDepartureTicket = pointDepartureTicket;
    }

    public String getPointArrivalTicket() {
        return pointArrivalTicket;
    }

    public void setPointArrivalTicket(String pointArrivalTicket) {
        this.pointArrivalTicket = pointArrivalTicket;
    }
}
