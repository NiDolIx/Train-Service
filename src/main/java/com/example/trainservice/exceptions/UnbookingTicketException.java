package com.example.trainservice.exceptions;

public class UnbookingTicketException extends Exception {
    public UnbookingTicketException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
