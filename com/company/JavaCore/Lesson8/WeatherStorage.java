package com.company.JavaCore.Lesson8;

import com.company.JavaCore.Lesson7.WeatherResponse;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WeatherStorage {
    private Connection connection;
    private Statement statement;

    public WeatherStorage() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/gb_test", "root", "root");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS weather" +
                    "(" +
                    "city TEXT NOT NULL," +
                    "localDate TEXT NOT NULL," +
                    "weatherText TEXT NOT NULL," +
                    "temperature DOUBLE NOT NULL" +
                    ");");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void insert(WeatherResponse weatherResponse, String city) {
        try (PreparedStatement prepInsert =
                     connection.prepareStatement("INSERT INTO weather (city,localDate, weatherText, temperature) VALUES(?, ?, ?, ?)")) {

            prepInsert.setString(1, city);
            prepInsert.setString(2, weatherResponse.getDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            prepInsert.setString(3, weatherResponse.getDay().getIconPhrase());
            prepInsert.setDouble(4, weatherResponse.getTemperature().getMinimum().getValue());
            prepInsert.addBatch();
            prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(List<WeatherResponse> weatherResponseList, String city) {
        weatherResponseList.forEach(weatherResponse -> insert(weatherResponse, city));
    }

    public String getValue(WeatherStorageField column, WeatherStorageField field, double equals) {

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select " + column.getName() + " from weather where " + field.getName() + " = " + equals);

            if (resultSet.next()) {
                return resultSet.getString(column.getName());
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        throw new NullPointerException();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
