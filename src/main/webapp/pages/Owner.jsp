<%@ page import="db.ConnectionProvider" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OwnerDao" %>
<%@ page import="bean.Owner" %>
<%@ page import="java.util.List" %><%--
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
    OwnerDao ownerDao = new OwnerDao(connection);
    List<Owner> ownersList = null;

    try {
        ownersList = ownerDao.getAll();
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

    <table  class="table table-responsive">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Father Name</th>
            <th>Remarks</th>
            <th>CNIC</th>
        </tr>
        </thead>

        <div class="row">

            <div class="col-md-8">
                <br>
                <a href="AddOwner.jsp" class="btn btn-primary mt-3">Add Owner</a>

            </div>
        </div>

        <table  class="table table-responsive">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Father Name</th>
                <th>Remarks</th>
                <th>CNIC</th>
                <th>Action</th>
            </tr>
            </thead>
                <tbody>
                    <%

                        if (ownersList != null) {
                            for (Owner owner : ownersList) {
                    %>
                    <tr>
                        <td><%= owner.getoId() %></td>
                        <td><%= owner.getoName()%></td>
                        <td><%= owner.getoFatherName() %></td>
                        <td><%= owner.getoRemarks() %></td>
                        <td><%= owner.getoCnic() %></td>
                        <td>
                        <a class="btn btn-danger" href='/vcs_war_exploded/DeleteOwner?id=<%=owner.getoId()%>'>Delete</a>
                        </td>
                        <td>
                            <a class="btn btn-warning" href='/vcs_war_exploded/pages/UpdateOwner.jsp?id=<%=owner.getoId()%>'>Update</a>
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
