<%-- 
    Document   : customeracccreate
    Created on : Jan 19, 2020, 11:26:58 PM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Customer account create</title>
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




<h1> Create new Customer Account</h1><br>
<form action="#">
 <div class="row">
	    <div class="col-sm-5">
       <div class="form-group">
       <label for="usr">Enter the Customer Name:</label>
       <input type="text" class="form-control" id="usr">
      </div><br>
	  </div> 
	  <div class="col-sm-3"></div>
	  <div class="col-sm-4">
	  
	  
</div>
	  </div>
<div class="row">
	    <div class="col-sm-5">
       <div class="form-group">
	  <label for="ex1">Enter the Customer Mobile Number :</label>
        <input class="form-control" id="ex1" type="number">
      </div><br>
	  </div>
	  </div>
	  <div class="form-group">
    <label for="inputdefault">Additional Information of the Customer</label>
    <input class="form-control" id="inputdefault" type="text">
  </div><br>
  <div class="col-sm-1"><a href="#" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-plus"></span> Create Account</a><br><br></div>



</form>
<br>
<br>


</div>
</body>
</html>