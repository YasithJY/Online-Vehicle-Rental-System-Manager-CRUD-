<%@ page import="com.model.Vehicle" %>
<%@ page import="static com.service.VehicleService.vehicle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="updateVehicle.css">
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
    
    <form action="update" method="post">
        <input type="text" name="vehicle_number" id="newVehicleNumberInput" placeholder="New Vehicle Number" readonly value="<%=vehicle.getVehicle_number()%>">
        <input type="text" name="model" id="newModelInput" placeholder="New Model" value="<%=vehicle.getModel()%>">
        <input type="text" name="color" id="colorInput" placeholder="Vehicle color" value="<%=vehicle.getColor()%>">
        <input type="text" name="r_price" id="mileageInput" placeholder="R_Price" value="<%=vehicle.getR_Price()%>">
        <button type="submit">Update Vehicle</button>
    </form>
</body>
</html>
