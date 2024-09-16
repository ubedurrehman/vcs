<%@ page import="bean.Owner" %>
<%@ page import="db.ConnectionProvider" %>
<%@ page import="dao.OwnerDao" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/15/2024
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Owner</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
Owner owner=null;
    if(request.getParameter("Cnic")!=null) {
    String Cnic = request.getParameter("Cnic");

    OwnerDao ownerDao = new OwnerDao(ConnectionProvider.getConnection());
    try {
        owner = ownerDao.searchCnic(Cnic);
    }catch (Exception ee){
        ee.printStackTrace();
    }
}
%>

       <form action="/vcs_war_exploded/pages/SearchOwner.jsp" method="POST">

            <input type="text" class="form-control" name="Cnic" placeholder="Enter Cnic">

            <button type="submit" class="btn btn-primary">Search</button>

        </form>
        <%

            if (owner != null) {
              %>
                    OWner CNic  : <%= owner.getoCnic() %> <br>
                    OWner Name  : <%= owner.getoName() %> <br>


    <%  }   else {    %>
        <h1>CNOC DAOES NOT EXIST IN OUR DATABASE , PLEasE contact with admIN</h1>
<%
    }%>




</body>
</html>
