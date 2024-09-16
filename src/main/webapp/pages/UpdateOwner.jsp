<%@ page import="dao.OwnerDao" %>
<%@ page import="db.ConnectionProvider" %>
<%@ page import="bean.Owner" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Owner</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%

    String ownerId = request.getParameter("id");
    int id = Integer.parseInt(ownerId);


    OwnerDao ownerDao = new OwnerDao(ConnectionProvider.getConnection());
    Owner owner = ownerDao.search(id);
%>

<div class="container">
    <div class="row">
        <form action="/vcs_war_exploded/UpdateOwner" method="POST">
            <div class="card">
                <h1 class="card-title">Update Owner</h1>
                <div class="card-body">


                    <input type="text" class="form-control" name="id" value="<%=owner.getoId() %>" required>


                    <div class="form-group">
                        <label>Owner Name</label>
                        <input type="text" class="form-control" name="ownerName" value="<%= owner.getoName() %>" required>
                    </div>

                    <div class="form-group">
                        <label>Owner Father's Name</label>
                        <input type="text" class="form-control" name="ownerFname" value="<%= owner.getoFatherName() %>" required>
                    </div>

                    <div class="form-group">
                        <label>Owner CNIC</label>
                        <input type="text" class="form-control" name="ownerCnic" value="<%= owner.getoCnic() %>" required>
                    </div>

                    <div class="form-group">
                        <label>Owner Remarks</label>
                        <input type="text" class="form-control" name="ownerRemarks" value="<%= owner.getoRemarks() %>">
                    </div>

                    <button type="submit" class="btn btn-primary">Update Owner</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
