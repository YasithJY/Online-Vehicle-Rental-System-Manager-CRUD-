<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM vehicles");
        
        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getString("vehicle_number") %></td>
            <td><%= rs.getString("model") %></td>
            <td><%= rs.getString("color") %></td>
            <td><%= rs.getString("mileage") %></td>
        </tr>
<%
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignored */ }
        try { if (conn != null) conn.close(); } catch (SQLException e) { /* ignored */ }
    }
%>
