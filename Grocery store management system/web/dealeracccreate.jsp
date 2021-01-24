<%-- 
    Document   : dealeracccreate
    Created on : Feb 13, 2020, 3:36:10 AM
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
    background-image: url("E:/photos/dealeracccreatebg.jpg");
  background-repeat: no-repeat;
  background-size:1370px 800px;
  }</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
      <li ><a href="billingmodule.jsp">Billing Module</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Create C.Account</a></li>
          <li><a href="customeraccess.jsp">Access C.Account</a></li>
          <li><a href="viewallcustomeracc.jsp">View all C.Accountss</a></li>
        </ul>
      </li>
       <li class="dropdown active"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Dealer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="customeracccreate.jsp">Create D.Account</a></li>
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
    <h1> Register Dealer Account</h1><hr>
<form method="get" action="\Grocery_Store\dealeracccreateservlet">

		<div class="form-group">
       <label for="usr">Dealer Name :</label>
       <input type="text" class="form-control" id="id" name="name" required>
</div><br>
       <div class="form-group">
       <label for="usr">Supply Products :</label>
       <input type="text" class="form-control" id="usr" name="product" required>
      </div><br>
       <div class="form-group">
	  <label for="ex1">Mobile Number :</label>
          <input class="form-control" id="ex1" type="number" name="num" required>
      </div><br>
      <div class="form-group">
	  <label for="ex1">E-Mail Address(optional) :</label>
        <input class="form-control" id="ex1" type="email" name="mail">
      </div><br>
	  <div class="form-group">
    <label for="inputdefault">Additional Info :</label>
    <input class="form-control" id="inputdefault" type="text" name="addinfo">
  </div><br>
  <div class="col-sm-1"><button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-plus"></span> Create Account</button><br><br></div>

</div>
    </div>
 </div>
</form>
<br>
<br>


</div>
</body>
</html>