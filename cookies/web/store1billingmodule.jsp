<%-- 
    Document   : store1billingmodule
    Created on : Jan 18, 2020, 2:08:15 AM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Store 1 Billing Module</title>
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
	  <li><a href="index.jsp">Home </a></li>
      <li class="active"><a href="#">Billing Module</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Customer Account <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="customeracccreate.jsp">Create C.Account</a></li>
          <a href="#"></a>
          <li><a href="customeraccess.jsp">Access C.Account</a></li>
          <a href="#"></a>
          <li><a href="">View all C.Accountss</a></li>
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
<div class="row">
      <div class="col-sm-5">  
 <br><h1>Branch 1 - Billing Module</h1><br> </div>
 <div class="col-sm-3"> </div>
 <div class="col-sm-4">

       <h3 S>
<div id="clockbox"></div>

<script type="text/javascript">
var tday=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
var tmonth=["January","February","March","April","May","June","July","August","September","October","November","December"];

function GetClock(){
var d=new Date();
var nday=d.getDay(),nmonth=d.getMonth(),ndate=d.getDate(),nyear=d.getFullYear();
var nhour=d.getHours(),nmin=d.getMinutes(),nsec=d.getSeconds(),ap;

if(nhour==0){ap=" AM";nhour=12;}
else if(nhour<12){ap=" AM";}
else if(nhour==12){ap=" PM";}
else if(nhour>12){ap=" PM";nhour-=12;}

if(nmin<=9) nmin="0"+nmin;
if(nsec<=9) nsec="0"+nsec;

var clocktext=""+tday[nday]+", "+tmonth[nmonth]+" "+ndate+", "+nyear+" "+nhour+":"+nmin+":"+nsec+ap+"";
document.getElementById('clockbox').innerHTML=clocktext;
}

GetClock();
setInterval(GetClock,1000);
</script>


	  </h3>




 </div>
 
 
 </div>
  <a href="#" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-file"></span>Create a new Bill</a><br><br>
  <h4>Enter the Bill Product Details:</h4>
 
 <form action="#">
  <div class="row">
      <div class="col-sm-7">  
	  <div class="form-group">
      <label for="sel1">Product Name</label>
      <select class="form-control" id="sel1">
        <option>-</option>
        <option>colgate(toothpaste)</option>
        <option>pepsudent(toothpaste)</option>
        <option>doberman(toothpaste)</option>
      </select>
      </div>
	  </div> 
	  <div class="col-sm-2">
	  <div class="form-group">
      <label for="sel1">Unit</label>
      <select class="form-control" id="sel1">
        <option>-</option>
        <option>gram(g)</option>
        <option>Kilogram(g)</option>
        <option>milliliter(ml)</option>
		<option>liter(l)</option>
      </select>
    </div>
	  
	  </div>
	  
</div> <br>
  <div class="row">
      <div class="col-sm-5"> 
	    <div class="form-group">
      <label for="sel1">Volume</label>
      <select class="form-control" id="sel1">
        <option>-</option>
        <option>1</option>
        <option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
		 <option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
		<option></option>
        <option></option>
      </select>
    </div>
      </div>	
	  <div class="col-sm-2">
	  <div class="form-group">
	  <label for="ex1">Quantity</label>
        <input class="form-control" id="ex1" type="number">
      </div>
	  </div>
	  <div class="col-sm-2">
	  <fieldset disabled>
	  <div class="form-group">
      <label for="disabledTextInput">Price</label>
      <input type="text" id="disabledTextInput" class="form-control" placeholder="Fixed"></fieldset>
    </div>
	  </div>  
 </div><br>
	  <div class="row">
	    <div class="col-sm-1"></div>
		<div class="col-sm-1">
		<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Another Item</button>
	       </div>
	     </div></form><br>
		 <div class="row">
	    <div class="col-sm-5"></div>
	    <div class="col-sm-1"><a href="#" class="btn btn-primary btn-lg" role="button"> <span class="glyphicon glyphicon-print"></span> Generate Bill</a><br><br></div>
		</div>
		 
	  </div>
</body>
</html>
