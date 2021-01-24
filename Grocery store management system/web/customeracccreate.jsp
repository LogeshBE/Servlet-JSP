<%-- 
    Document   : customeracccreate
    Created on : Jan 19, 2020, 11:26:58 PM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
  <style>
  body {
    background-image: url("E:/photos/createcustomeraccbg.jpg");
  background-repeat: no-repeat;
  background-size:1370px 800px;
  }</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
      <li ><a href="billingmodule.jsp">Billing Module</a></li>
      <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Create C.Account</a></li>
          <li><a href="customeraccess.jsp">Access C.Account</a></li>
          <li><a href="viewallcustomeracc.jsp">View all C.Accountss</a></li>
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
<div class="container">

 <div class="row">
  <div class="cols-sm-1"></div>
    <div class="col-sm-5">

<div style="background-color:#F4A460;" class="container-fluid">
    <h1> Create new Customer Account</h1><hr>
<form method="get" action="\Grocery_Store\customeracccreateservlet">

		
       <div class="form-group">
       <label for="usr">Enter the Customer Name:</label>
       <input type="text" class="form-control" id="usr" name="name" required>
      </div><br>
       <div class="form-group">
	  <label for="ex1">Enter the Customer Mobile Number :</label>
          <input class="form-control" id="ex1" type="number" name="mobileno" required>
      </div><br>
	  <div class="form-group">
    <label for="inputdefault">Additional Information about the Customer</label>
    <input class="form-control" id="inputdefault" type="text" name="addinfo" required>
  </div><br>
   <div class="col-sm-1"><button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-plus"></span> Create Account</button><br></div>
</div>
    </div>
 </div>
</form>
<br>
<br>


</div>
</body>
</html>