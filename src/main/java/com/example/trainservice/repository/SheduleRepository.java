package com.example.trainservice.repository;

import com.example.trainservice.config.DataBaseConnection;
import com.example.trainservice.models.*;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SheduleRepository {
    public List<Shedule> getAllShedule(Long idRoute, String trainName) {
        try(Connection connection = DataBaseConnection.getPostgresConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                 SELECT
                     route.route_id,
                     route.route_name,
                     route.route_point_arrival,
                     route.route_point_departure,
                     train.train_id,
                     train.train_name,
                     train_type.train_type_id,
                     train_type.train_type
                 FROM route
                 INNER JOIN train ON route.route_id = train.route_id
                 INNER JOIN train_type ON train.train_type_id = train_type.train_type_id
                 WHERE 
                    train.train_name LIKE ?
                    AND
                    route.route_id = ?;
            """);

            preparedStatement.setString(1, trainName);
            preparedStatement.setLong(2, idRoute);

            ResultSet result = preparedStatement.executeQuery();

            List<Shedule> shedules = new ArrayList<>();

            while (result.next()) {
                List<Point> points = new ArrayList<>();
                preparedStatement = connection.prepareStatement("""
                    SELECT
                        point.point_id,
                        point.point_name,
                        point.point_time_arrival,
                        point.point_time_departure
                    FROM point
                    INNER JOIN include ON point.point_id = include.point_id
                    INNER JOIN route ON include.route_id = route.route_id
                    WHERE 
                        include.route_id = ? 
                        AND 
                        point.point_time_arrival > NOW() 
                        AND 
                        point.point_time_departure > NOW();
                """);

                preparedStatement.setLong(1, result.getLong("route_id"));

                ResultSet resultPoints = preparedStatement.executeQuery();

                while (resultPoints.next()) {
                    Point point = new Point();
                    point.setIdPoint(resultPoints.getLong("point_id"));
                    point.setNamePoint(resultPoints.getString("point_name"));
                    point.setTimeArrivalPoint(
                            resultPoints.getTimestamp("point_time_arrival").toLocalDateTime()
                    );
                    point.setTimeDeparturePoint(
                            resultPoints.getTimestamp("point_time_departure").toLocalDateTime()
                    );

                    points.add(point);
                }

                Route route = new Route();
                route.setIdRoute(result.getLong("route_id"));
                route.setNameRoute(result.getString("route_name"));
                route.setPointArrivalRoute(result.getString("route_point_arrival"));
                route.setPointDepartureRoute(result.getString("route_point_departure"));

                Train train = new Train();
                train.setIdTrain(result.getLong("train_id"));
                train.setIdTypeTrain(result.getLong("train_type_id"));
                train.setNameTrain(result.getString("train_name"));
                train.setIdRoute(result.getLong("route_id"));

                TypeTrain typeTrain = new TypeTrain();
                typeTrain.setIdTypeTrain(result.getLong("train_type_id"));
                typeTrain.setTypeTrain(result.getString("train_type"));

                Shedule shedule = new Shedule();
                shedule.setPoints(points);
                shedule.setRoute(route);
                shedule.setTrain(train);
                shedule.setTypeTrain(typeTrain);

                shedules.add(shedule);
            }

            return shedules;
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
