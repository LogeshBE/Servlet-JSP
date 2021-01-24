<%-- 
    Document   : viewalldealeracc
    Created on : Feb 14, 2020, 4:02:38 PM
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
    background-image: url("E:/photos/viewallcustomeraccbg.jpg");
  background-repeat: no-repeat;
  background-size:1370px 800px;
  }</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
	  <li><a href="index.jsp">Home </a></li>
      <li ><a href="billingmodule.jsp">Billing Module</a></li>
      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="customeracccreate.jsp">Create C.Account</a></li>
          <li><a href="customeraccess.jsp">Access C.Account</a></li>
          <li><a href="#">View all C.Accountss</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Dealer Account <span class="caret"></span></a>
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
    <div class="col-sm-8">
        <div style="background-color:#F4A460;" class="container-fluid">
	
        <form method="get" action="\Grocery_Store\viewalldealeraccservlet">
            <label for="usr"><h1>Click the below button to view all the Dealers Accounts in this Branch</h1></label>
  <button type="submit" class="btn btn-primary">Click hear!</button><br><br><br><br>
  </form>
        </div>
    </div>
    </div>
	
	
	
</div>
</body>
</html>