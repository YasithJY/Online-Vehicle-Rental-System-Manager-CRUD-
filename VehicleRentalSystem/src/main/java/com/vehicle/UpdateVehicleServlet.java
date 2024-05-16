package com.vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.model.Vehicle;
import com.service.VehicleService;

import java.io.IOException;

@WebServlet("/update")
public class UpdateVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vehicle_number = request.getParameter("vehicle_number");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        String r_price = request.getParameter("r_price");


        // save data to model class
        Vehicle vehicle = new Vehicle(vehicle_number,model,color,r_price);

        // add data to database
        int rowCount = VehicleService.updateVehicle(vehicle);

        if(rowCount > 0) {
            // new customer added successfully
            response.sendRedirect("dashboard.jsp");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        }
        else {
            // handle errors
            System.out.println("something wrong with data inserting to the database");
        }
    }
}
