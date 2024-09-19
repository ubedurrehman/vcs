<%@ page import="dao.VehicleDao" %>
<%@ page import="db.ConnectionProvider" %>
<%@ page import="bean.Vehicle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Vehicle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Update Vehicle</h2>
    <%
        String vId = request.getParameter("id");
        Vehicle vehicle = null;

        int vid = Integer.parseInt(vId);
        VehicleDao vehicleDao = new VehicleDao(ConnectionProvider.getConnection());
        vehicle = vehicleDao.search(vid);
    %>
    <form action="/vcs_war_exploded/UpdateVehicle" method="Post">
        <div class="card">
            <div class="card-body">

                <input type="hidden" name="id" value="123">


                <div class="form-group">
                    <label for="vRegister">Vehicle Register</label>
                    <input type="text" class="form-control" id="vRegister" name="vRegister" value="<%= vehicle.getVRegister() %>" required>
                </div>

                <div class="form-group">
                    <label for="vEngineType">Engine Type</label>
                    <input type="text" class="form-control" id="vEngineType" name="vEngineType" value="<%= vehicle.getvEngineType() %>" required>
                </div>

                <div class="form-group">
                    <label for="vFuelType">Fuel Type</label>
                    <input type="text" class="form-control" id="vFuelType" name="vFuelType" value="<%= vehicle.getvFuelType() %>" required>
                </div>

                <div class="form-group">
                    <label for="vColor">Color</label>
                    <input type="text" class="form-control" id="vColor" name="vColor" value="<%= vehicle.getvColor() %>" required>
                </div>

                <div class="form-group">
                    <label for="vMake">Make</label>
                    <input type="text" class="form-control" id="vMake" name="vMake" value="<%= vehicle.getVMake() %>" required>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Update Vehicle</button>
            </div>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
