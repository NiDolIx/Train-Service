package com.example.trainservice.controllers;

import com.example.trainservice.exceptions.BookingTicketException;
import com.example.trainservice.exceptions.UnbookingTicketException;
import com.example.trainservice.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/unbooking/{idTicket}")
    public ResponseEntity<String> unbooking(@PathVariable Long idTicket) {
        try {
            ticketService.unbooking(idTicket);
            return ResponseEntity.ok("Билет на поезд успешно отменен!");
        } catch (UnbookingTicketException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }

    @PostMapping("/booking")
    public ResponseEntity<String> booking(
            // Имя пассажира
            @RequestParam String namePassenger,
            // Фамилия пассажира
            @RequestParam String surnamePassenger,
            // Отчество пассажира
            @RequestParam String patronimycPassenger,
            // Дата рождения пассажира
            @RequestParam LocalDate birthdayPassenger,
            // Точка отправления
            @RequestParam String pointNameDeparture,
            // Точка прибытия
            @RequestParam String pointNameArrival,
            // ID маршрута
            @RequestParam Long idRoute,
            // Кол-во бронируемых мест
            @RequestParam Integer countTicket,
            // ID вагона
            @RequestParam Long idWagon
    ) {
        try {
            ticketService.booking(
                    namePassenger,
                    surnamePassenger,
                    patronimycPassenger,
                    birthdayPassenger,
                    pointNameDeparture,
                    pointNameArrival,
                    idRoute,
                    countTicket,
                    idWagon
            );

            return ResponseEntity.ok("Оформление билетов прошло успешно!");
        } catch (BookingTicketException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }
}
