package com.example.trainservice.repository;

import com.example.trainservice.config.DataBaseConnection;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

@Repository
public class PassengerRepository {
    public Long addNewPassenger(String name, String surname, String patronimyc, LocalDate birthday) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                INSERT INTO passenger (passenger_surname, passenger_name, passenger_patronymic, passenger_byrthday) 
                VALUES (?, ?, ?, ?) RETURNING passenger_id;
            """);

            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, patronimyc);
            preparedStatement.setDate(4, Date.valueOf(birthday));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("passenger_id");
            }

            return null;
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
