<%-- 
    Document   : dealeraccess2
    Created on : Feb 20, 2020, 9:34:06 PM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <style>
  body {
    font: 400 15px Lato, sans-serif;
    background-image: url("E:/photos/woodenboard.jpg");
    color: #818181;
  }
 </style>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
  <div class="container">
   
    <ul class="nav navbar-nav">
	  <li><a href="index.jsp">Home </a></li>
      <li class="active"><a href="#">Billing Module</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="customeracccreate.jsp">Create C.Account</a></li>
          <li><a href="customeraccess.jsp">Access C.Account</a></li>
          <li><a href="viewallcustomeracc.jsp">View all C.Accounts</a></li>
        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Dealer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="dealeracccreate.jsp">Create D.Account</a></li>
          <li><a href="dealeraccessacc.jsp">Access D.Account</a></li>
          <li><a href="#">View all D.Accounts</a></li>
        </ul>
      </li>
	  <li><a href="#">Stocks</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Login</a></li>
    </ul>
  </div>
</nav>
 
    </body>
</html>
