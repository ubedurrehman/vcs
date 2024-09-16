<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/14/2024
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Owner</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
<form action="/vcs_war_exploded/AddOwner">
        <div class="card">

            <h1 class="card-title"> Add Owner </h1>
            <div class="card-body">


                <div class="form-group">
                    <label>Owner Name </label>
                    <input type="text" class="form-control" name="ownerName" placeholder="Enter Owner Name">
                </div>
                <div class="form-group">
                    <label>Owner Fname </label>
                    <input type="text" class="form-control" name="ownerFname" placeholder="Enter Owner Fname">
                </div>
                <div class="form-group">
                    <label>Owner Cnic </label>
                    <input type="text" class="form-control" name="ownerCnic" placeholder="Enter Owner Cnic">
                </div>
                <div class="form-group">
                    <label>Owner Remarks </label>
                    <input type="text" class="form-control" name="ownerRemarks" placeholder="Enter Owner Remarks">
                </div>


            </div>
        </div>

    <button>Add Owner</button>
</form>

    </div>


</div>

</body>
</html>
