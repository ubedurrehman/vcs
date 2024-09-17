<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Vehicle Challan System</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Welcome to the Vehicle Challan System</h1>

    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Owner</div>
                <div class="panel-body">
                    <a href="pages/Owner.jsp" class="btn btn-primary btn-lg btn-block">Go to Owner</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Vehicle</div>
                <div class="panel-body">
                    <a href="pages/Register.jsp" class="btn btn-primary btn-lg btn-block">Go to Vehicle</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Challan</div>
                <div class="panel-body">
                    <a href="pages/Challan.jsp" class="btn btn-primary btn-lg btn-block">Go to Challan</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
