package com.vehicle;

import com.model.Vehicle;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.service.VehicleService;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteVehicleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vehicle_number = request.getParameter("vehicle_number");

        // delete customer
        int rowCount = VehicleService.deleteVehicle(vehicle_number);

        if(rowCount > 0) {
            VehicleService.vehicle = null;

            // Redirect back to the login page
            response.sendRedirect("dashboard.jsp");
        }
        else {
            System.out.println("Customer deletion failed");
        }
    }
}
