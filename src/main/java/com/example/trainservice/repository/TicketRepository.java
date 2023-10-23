package com.example.trainservice.repository;

import com.example.trainservice.config.DataBaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    public void unbooking(Long idTicket) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                UPDATE ticket
                SET 
                    passenger_id = null,
                    ticket_status = 'Отменено'
                WHERE
                    ticket_id = ? 
            """);

            preparedStatement.setLong(1, idTicket);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void booking(Long idPassenger, List<Long> idTickets) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement ticketing = connection.prepareStatement("""
                        UPDATE ticket
                        SET
                            passenger_id = ?,
                            ticket_status = ?
                        WHERE 
                            ticket.ticket_id = ?;
            """);

            for (Long idTicket : idTickets) {
                ticketing.setLong(1, idPassenger);
                ticketing.setString(2, "Оформлено");
                ticketing.setLong(3, idTicket);
                ticketing.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Long> getFreeTickets(
            Long idWagon,
            Long idRoute,
            Integer countTicket,
            String pointNameDeparture,
            String pointNameArrival
    ) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
            SELECT 
                ticket.ticket_id
            FROM ticket
            INNER JOIN place ON ticket.place_id = place.place_id
            INNER JOIN wagon ON place.wagon_id = wagon.wagon_id
            INNER JOIN train ON wagon.train_id = train.train_id
            INNER JOIN route ON train.route_id = route.route_id
            WHERE
                wagon.wagon_id = ?
                AND
                ticket.route_id = ?
                AND
                ticket.ticket_point_departure = ?
                AND
                ticket.ticket_point_arrival = ?
                AND
                ticket.ticket_status LIKE 'Не оформлено'
                LIMIT ?;
            """);

            preparedStatement.setLong(1, idWagon);
            preparedStatement.setLong(2, idRoute);
            preparedStatement.setString(3, pointNameDeparture);
            preparedStatement.setString(4, pointNameArrival);
            preparedStatement.setInt(5, countTicket);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Long> idTickets = new ArrayList<>();

            while (resultSet.next()) {
                idTickets.add(resultSet.getLong("ticket_id"));
            }

            return idTickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
