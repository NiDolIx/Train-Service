package com.example.trainservice.repository;

import com.example.trainservice.config.DataBaseConnection;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class PointRepository {
    public LocalDateTime getTimeDepartureFromPoint(Long idTicket) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT 
                    point.point_time_departure
                FROM point
                INNER JOIN include ON point.point_id = include.point_id
                INNER JOIN route ON include.route_id = route.route_id
                INNER JOIN ticket ON route.route_id = ticket.route_id
                WHERE 
                    ticket.ticket_id = ?
                    AND
                    ticket.ticket_point_departure = point.point_name
                    AND
                    ticket.ticket_status = 'Оформлено'
                    AND
                    point.point_time_departure > NOW();
            """);

            preparedStatement.setLong(1, idTicket);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getTimestamp("point_time_departure").toLocalDateTime();
            }

            return null;
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
