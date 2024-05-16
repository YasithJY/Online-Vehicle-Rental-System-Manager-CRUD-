<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>
    <nav>
    <ul class="nav-links">
        <li><a href="#" class="an">HOME</a></li>
        <li><a href="#" class="an">Rental Guide</a></li>
        <li><a href="#" class="an">Services</a></li>
        <li><a href="#" class="an">Feedback</a></li>
        <li><a href="#" class="an">Contact Us</a></li>
        <li><a href="Admin_Login.php" class="an"><button>Login</button></a></li>
    </ul>
    <ul class="nav-details">
    	<li><a href="#" class="an">Find US</a></li>
        <li>LuxeWheels Rental</li>
        <li>0112336547</li>
        <li>Email: info.lxwheels@gmail.com</li>        
        <li>&copy; LuxeWheels Rental. All rights reserved.</li>
    </ul>
    
</nav>
<div class="container">
    <!-- Vehicle Details Table -->
    <div class="table-container">
        <h2>Vehicle Details</h2>
        <table id="vehicleTable">
            <thead>
            <tr>
                <th>Vehicle Number</th>
                <th>Model</th>
                <th>Color</th>
                <th>R_Price</th>
            </tr>
            </thead>
            <tbody id="vehicleTableBody">
            
            <%
            	try {
            		Class.forName("com.mysql.cj.jdbc.Driver");
            		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vrs?useSSL=false","root","105680");
            		String sql = "SELECT * FROM vehicles";
            		Statement statement = connection.createStatement();
            		ResultSet result = statement.executeQuery(sql);
            		while(result.next()) {
            	
            %>
            <tr>
            	<td><%=result.getString("vehicle_number")%></td>
            	<td><%=result.getString("model")%></td>
            	<td><%=result.getString("color")%></td>
            	<td><%=result.getString("r_price")%></td>
            	
            	<%
            		}
            		result.close();
            		statement.close();
            		connection.close();
            	}
            catch (Exception e) {
            	System.out.println(e.getMessage());
            }
            	%>
            </tr>

            </tbody>
        </table>
    </div>
    <!-- Add New Vehicle Form -->
    <div class="form-container">
        <h2>Add New Vehicle</h2>
        <form id="addVehicleForm" method="post" action="register">
            <input type="text" name="vehicle_number" id="vehicle_number" placeholder="Enter Vehicle Number" required>
            <input type="text" name="model" id="model" placeholder="Enter Model">
            <input type="text" name="color" id="color" placeholder="Enter Color">
            <input type="text" name="r_price" id="mileage" placeholder="Enter R_Price">
            <button type="submit">Add Vehicle</button>
        </form>
    </div>

    <!-- Update Vehicle Form -->
    <div class="form-container">
        <h2>Update Vehicle</h2>
        <form id="updateVehicleForm" method="post" action="search">
            <input type="text" name="vehicle_number" id="searchVehicleNumberInput" placeholder="Search Vehicle Number">
            <button type="submit">Search</button>

        </form>
    </div>

    <!-- Delete Vehicle Form -->
    <div class="form-container">
        <h2>Delete Vehicle</h2>
        <form id="deleteVehicleForm" method="get" action="delete">
            <input type="text" name="vehicle_number" id="deleteVehicleNumberInput" placeholder="Enter Vehicle Number to Delete" required>
            <button type="submit">Delete Vehicle</button>
        </form>
    </div>
</div>


</body>
</html>
