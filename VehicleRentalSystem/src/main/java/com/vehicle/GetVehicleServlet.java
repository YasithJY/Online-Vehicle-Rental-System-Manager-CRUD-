package com.vehicle;

import com.util.DBConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DBConnectionUtil.getDBConnection();

            // SQL query to fetch data
            String query = "SELECT * FROM vehicles";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Print table rows
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("Vehicle Number") + "</td>");
                out.println("<td>" + rs.getString("Model") + "</td>");
                out.println("<td>" + rs.getString("Color") + "</td>");
                out.println("<td>" + rs.getString("R_Price") + "</td>");
                out.println("</tr>");
            }

            // Close connections
            rs.close();
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
