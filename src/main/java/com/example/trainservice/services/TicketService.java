package com.example.trainservice.services;

import com.example.trainservice.exceptions.UnbookingTicketException;
import com.example.trainservice.repository.PassengerRepository;
import com.example.trainservice.repository.PointRepository;
import com.example.trainservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final PointRepository pointRepository;

    @Autowired
    public TicketService(
            TicketRepository ticketRepository,
            PassengerRepository passengerRepository,
            PointRepository pointRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.pointRepository = pointRepository;
    }

    public void unbooking(Long idTicket) throws UnbookingTicketException {
        if ((Duration.
                between(LocalDateTime.now(), pointRepository.getTimeDepartureFromPoint(idTicket)).toHours()) < 2) {
            throw new UnbookingTicketException("Отправление поезда менее, чем через 2 часа, отмена билета невозможна!");
        }

        ticketRepository.unbooking(idTicket);
    }

    public boolean booking(
            String namePassenger,
            String surnamePassenger,
            String patronimycPassenger,
            LocalDate birthdayPassenger,
            String pointNameDeparture,
            String pointNameArrival,
            Long idRoute,
            Integer countTicket,
            Long idWagon
    ) {
        List<Long> idTickets = ticketRepository.getFreeTickets(
                idWagon,
                idRoute,
                countTicket,
                pointNameDeparture,
                pointNameArrival
        );

        if (idTickets.size() == countTicket) {
            ticketRepository.booking(passengerRepository.addNewPassenger(
                    namePassenger,
                    surnamePassenger,
                    patronimycPassenger,
                    birthdayPassenger
            ), idTickets);

            return true;
        } else {
            return false;
        }
    }
}
