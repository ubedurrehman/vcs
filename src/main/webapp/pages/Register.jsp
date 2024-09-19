<%@ page import="db.ConnectionProvider" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OwnerDao" %>
<%@ page import="bean.Owner" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.VehicleDao" %>
<%@ page import="bean.Vehicle" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/14/2024
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owner</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%

    Connection connection = ConnectionProvider.getConnection();
    VehicleDao vehicleDao=new VehicleDao(connection);
    List<Vehicle> vehicleList = null;

    try {
        vehicleList = vehicleDao.getAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<div id="container">
    <h1 class="">

        <%
            String message = (String) session.getAttribute("msg");
            if (message != null) {
        %>
        <h1><%= message %></h1>
        <% session.removeAttribute("msg"); %>
        <%
            }
        %>
    </h1>


    <div class="row">

        <div class="col-md-8">
            <br>
            <a href="RegisterVehicle.jsp" class="btn btn-primary mt-3">Add Vehicle</a>

        </div>
    </div>

    <table  class="table table-responsive">
        <thead>
        <tr>
            <th>Id</th>
            <th>R.No</th>
            <th>Make</th>
            <th>EngineType</th>
            <th>Fuel Type</th>
            <th>Color</th>
            <th>Action</th>
            <th>Update </th>
        </tr>
        </thead>
        <tbody>
        <%

            if (vehicleList != null) {
                for (Vehicle vehicle : vehicleList) {
        %>
        <tr>
            <td><%= vehicle.getVId()%></td>
            <td><%= vehicle.getVRegister()%></td>
            <td><%= vehicle.getVMake()%></td>
            <td><%= vehicle.getvEngineType()%></td>
            <td><%= vehicle.getvFuelType()%></td>
            <td><%= vehicle.getvColor()%></td>
            <td>
                <a class="btn btn-danger" href='/vcs_war_exploded/DeleteVehicle?id=<%=vehicle.getVId()%>'>Delete</a>
            </td>
            <td>
                <a class="btn btn-warning" href='/vcs_war_exploded/pages/UpdateVehicle.jsp?id=<%=vehicle.getVId()%>'>Update</a>
            </td>

        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td >No owners found</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>


</body>
</html>
