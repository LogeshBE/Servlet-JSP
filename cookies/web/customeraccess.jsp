<%-- 
    Document   : customeraccess
    Created on : Jan 19, 2020, 11:29:12 PM
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
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Store 1</a>
    </div>
    <ul class="nav navbar-nav">
	  <li><a href="#">Home </a></li>
      <li ><a href="#">Billing Module</a></li>
      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Create C.Account</a></li>
          <li><a href="#">Access C.Account</a></li>
          <li><a href="#">View all C.Accountss</a></li>
        </ul>
      </li>
      <li><a href="#">Dealers</a></li>
	  <li><a href="#">Stocks</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="container">
    
	
	<h1>Access the Customer Account</h1>
	<hr>
	<center><h2>Enter the Customer name (or) Mobile number to access the account</h2></center><br><br>
	
	
	<form class="form-inline" action="#">
	 <label for="usr">Enter the Customer Name:</label>
       <input type="text" class="form-control" placeholder="Enter the customer name" id="usr">
  
  <button type="submit" class="btn btn-primary">Submit</button><br><br><br><br>
  </form>
<form class="form-inline" action="#">
	<label for="ex1">Enter the Customer Mobile Number :</label>
        <input class="form-control" placeholder="Enter the mobile number"id="ex1" type="number">
  
  <button type="submit" class="btn btn-primary">Submit</button><br><br>
</form>
	
	
	
</div>
</body>
</html>