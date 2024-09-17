<%@ page import="java.security.Provider" %>
<%@ page import="db.ConnectionProvider" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.OwnerDao" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="bean.Owner" %>
<%@ page import="java.util.ArrayList" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Vehicle</title>

</head>
<body>
<h1>Add Vehicle</h1>


<%
  Connection connection = ConnectionProvider.getConnection();
  HttpSession session = request.getSession();
  String msg = (String) session.getAttribute("msg");

  OwnerDao ownerDao = new OwnerDao(connection);
  ArrayList<Owner> owners = ownerDao.getAll();


  if (msg != null) {
%>
<div class="alert">
  <%= msg %>
</div>
<%
    session.removeAttribute("msg");
  }
%>



<form action="/vcs_war_exploded/AddRegister" method="post">

  <div class="row">
    <div class="col-md-6">

      <label> Select Owner </label>
    <select class="form-control" name="oId">
    <% for(Owner owner : owners){

      %>
         <option value="<%=owner.getoId()%>"><%=owner.getoName()%></option>
      <option value="<%=owner.getoId()%>"></option>
      <%

    }%>

    </select>
    </div>

    <label for="vRegister">Registration Number:</label>
    <input type="text" id="vRegister" name="vRegister" required>
    <br>
    <label for="vMake">Make:</label>
    <input type="text" id="vMake" name="vMake" required>
    <br>
    <label for="vEngineType">Engine Type:</label>
    <input type="text" id="vEngineType" name="vEngineType">
    <br>
    <label for="vFuelType">Fuel Type:</label>
    <input type="text" id="vFuelType" name="vFuelType">
    <br>
    <label for="vColor">Color:</label>
    <input type="text" id="vColor" name="vColor">
    <br>
<%--    <label for="oId">Owner ID:</label>--%>
<%--    <input type="number" id="oId" name="oId" required>--%>
    <br>
    <input type="submit" value="Register">
</form>
</body>
</html>
