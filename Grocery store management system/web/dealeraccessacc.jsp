<%-- 
    Document   : dealeraccessacc
    Created on : Feb 13, 2020, 3:51:06 AM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Customer account access</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
 <style>
  body {
    background-image: url("E:/photos/dealeraccessaccbg.jpg");
  background-repeat: no-repeat;
  background-size:1370px 800px;
  }</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
	  <li><a href="index.jsp">Home </a></li>
      <li ><a href="billingmodule.jsp">Billing Module</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="customeracccreate.jsp">Create C.Account</a></li>
          <li><a href="#">Access C.Account</a></li>
          <li><a href="viewallcustomeracc.jsp">View all C.Accountss</a></li>
        </ul>
      </li>
      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Dealer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="dealeracccreate.jsp">Create D.Account</a></li>
          <li><a href="#">Access D.Account</a></li>
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
<div class="container">
    <div class="row">
  <div class="cols-sm-1"></div>
    <div class="col-sm-6">
        <div style="background-color:#F4A460;" class="container-fluid">
	<h1>Access the Dealer Account</h1>
	<hr>
	
        <form class="form-inline" method="get" action="\Grocery_Store\dealeraccaccessservlet"><br>
	<label for="ex1">Enter the Dealer Mobile Number---</label>
        <input class="form-control" placeholder="Enter the mobile number"id="ex1" type="number" name="mobilenum">
  
  <button type="submit" class="btn btn-primary">Submit</button><br><br>
</form><br><center>
        
     
        </div>
    </div>
    </div>
	
	
	
</div>
</body>
</html>