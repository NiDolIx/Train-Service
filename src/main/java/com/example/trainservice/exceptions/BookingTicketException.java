package com.example.trainservice.exceptions;

public class BookingTicketException extends Exception {
    private int colTickets;

    public BookingTicketException(int colTickets, String message) {
        super(message);
        this.colTickets = colTickets;
    }

    @Override
    public String toString() {
        return "Кол-во свободных мест в выбранном вагоне: " + colTickets
                + ", " + getMessage();
    }
}
