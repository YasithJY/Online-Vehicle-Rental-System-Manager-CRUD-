package com.vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username contains an '@' symbol and if it matches the hardcoded credentials
        if (username.contains("@") && username.equals("manager@gmail.com") && password.equals("m123")) {
            // If login is successful, redirect to profile.jsp
            response.sendRedirect("profile.jsp");
        } else {
            // If login is unsuccessful, display an alert
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid username or password!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
    }
}
