package com.service;

import com.model.Vehicle;
import com.util.DBConnectionUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleService {

    // By using a logger, developers can output informative messages, warnings, and error details during the execution of the application
    public static final Logger log = Logger.getLogger(VehicleService.class.getName());
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;
    public static Vehicle vehicle;
    private static int rowCount;

    public static int addVehicle(Vehicle vehicle) {
        try {
            connection = DBConnectionUtil.getDBConnection();

            String sql = "INSERT INTO vehicles (vehicle_number, model, color, r_price) VALUES ('"+vehicle.getVehicle_number()+"','"+vehicle.getModel()+"','"+vehicle.getColor()+"','"+vehicle.getR_Price()+"' )";

            statement = connection.createStatement();

            rowCount = statement.executeUpdate(sql);

        }
        catch (SQLException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        finally {
            /*
             * Close prepared statement and database connectivity at the end of
             * transaction
             */
            try {
                if(statement != null) {
                    statement.close();
                }
            }
            catch(SQLException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }
        return rowCount;
    }

    public static Vehicle getVehicle(String vehicle_number) {

        try {
            connection = DBConnectionUtil.getDBConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE vehicle_number = ?");

            // set values
            preparedStatement.setString(1, vehicle_number);

            //execute query
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                // save data on model class
                vehicle = new Vehicle(
                        resultSet.getString("vehicle_number"),
                        resultSet.getString("model"),
                        resultSet.getString("color"),
                        resultSet.getString("r_price")
                );
                vehicle.setId(resultSet.getInt("id"));
            }

        }
        catch (SQLException | ClassNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        finally {
            /*
             * Close prepared statement and database connectivity at the end of
             * transaction
             */
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }
            catch(SQLException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }

        // return result set to servlet page
        return vehicle;
    }

    public static int updateVehicle(Vehicle vehicle) {
        try {
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection.prepareStatement("UPDATE vehicles SET vehicle_number = ?, model = ?, color = ?, r_price = ? WHERE vehicle_number = ?");

            preparedStatement.setString(1, vehicle.getVehicle_number());
            preparedStatement.setString(2, vehicle.getModel());
            preparedStatement.setString(3, vehicle.getColor());
            preparedStatement.setString(4, vehicle.getR_Price());
            preparedStatement.setString(5, vehicle.getVehicle_number());


            rowCount = preparedStatement.executeUpdate();

            if(rowCount > 0) {
                System.out.println("Vehicle Updated Successfully");
            }
            else {
                System.out.println("No Vehicle found with ID " + vehicle.getId());
            }

        }
        catch (Exception e) {
            System.err.println("Error updating vehicle : " + e.getMessage());
        }

        return rowCount;
    }

    public static int deleteVehicle(String vehicle_number) {
        try {
            connection = DBConnectionUtil.getDBConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vehicle_number = ?");

            preparedStatement.setString(1, vehicle_number);

            rowCount = preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error deleting delete : " + e.getMessage());
        }

        return rowCount;
    }
}
