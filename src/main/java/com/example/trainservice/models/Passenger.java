package com.example.trainservice.models;

import java.time.LocalDate;

public class Passenger {
    private Long idPassenger;
    private String namePassenger;
    private String surnamePassenger;
    private String patronymicPassenger;
    private LocalDate birthdayPassenger;

    public Passenger() { }

    public Passenger(
            Long idPassenger,
            String namePassenger,
            String surnamePassenger,
            String patronymicPassenger,
            LocalDate birthdayPassenger
    ) {
        this.idPassenger = idPassenger;
        this.namePassenger = namePassenger;
        this.surnamePassenger = surnamePassenger;
        this.patronymicPassenger = patronymicPassenger;
        this.birthdayPassenger = birthdayPassenger;
    }

    public Long getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Long idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        this.namePassenger = namePassenger;
    }

    public String getSurnamePassenger() {
        return surnamePassenger;
    }

    public void setSurnamePassenger(String surnamePassenger) {
        this.surnamePassenger = surnamePassenger;
    }

    public String getPatronymicPassenger() {
        return patronymicPassenger;
    }

    public void setPatronymicPassenger(String patronymicPassenger) {
        this.patronymicPassenger = patronymicPassenger;
    }

    public LocalDate getBirthdayPassenger() {
        return birthdayPassenger;
    }

    public void setBirthdayPassenger(LocalDate birthdayPassenger) {
        this.birthdayPassenger = birthdayPassenger;
    }
}
