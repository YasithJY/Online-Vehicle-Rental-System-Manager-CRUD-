package com.vehicle;

import com.model.Vehicle;
import com.service.VehicleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/search")
public class SearchVehicleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
        String vehicle_number = request.getParameter("vehicle_number");

        // save logged user data to model class
        Vehicle vehicle = VehicleService.getVehicle(vehicle_number);

        if(vehicle != null) {
            // create new session


            // set user object as an attribute in the request scope
            request.setAttribute("vehicle", vehicle);

            // forward to index.jsp page
            response.sendRedirect("updateVehicle.jsp");
        }
        else {
            System.out.println("Vehicle is null");
        }
    }
}
