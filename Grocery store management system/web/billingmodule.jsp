<%-- 
    Document   : billingmodule
    Created on : Feb 13, 2020, 3:13:56 AM
    Author     : LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>billing module</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body style="background-color:#F4A460;">

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
  
<div class="container"  >
    
<div class="row">
      <div class="col-sm-5">  
 <br><h1>Billing Module</h1><br> </div>
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
      <div class="col-sm-3">  
	  <div class="form-group">
      <label for="sel1">Product Name</label>
      <select class="form-control" id="sel1">
        <option>-</option>
        <option>colgate(toothpaste)</option>
        <option>pepsudent(toothpaste)</option>
        <option>doberman(toothpaste)</option>
		 <option>colgate(toothpaste)</option>
        <option>pepsudent(toothpaste)</option>
        <option>doberman(toothpaste)</option>
		 <option>colgate(toothpaste)</option>
        <option>pepsudent(toothpaste)</option>
        <option>doberman(toothpaste)</option>
      </select><br>
	  <label for="sel1">Volume</label>
      <input class="form-control" id="ex1" type="number"><br><br>
	  <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Another Item</button>
      </div>
	  </div> 
      <div class="col-sm-2">
          <div class="form-group">
      <label for="sel1">Product Code</label> 
      <input class="form-control" id="ex1" type="number"><br>
        <label for="ex1">Quantity</label>
        <input class="form-control" id="ex1" type="number">
	  </div>
          <br><br><br><br><br><br><br>
		  <a href="#" class="btn btn-primary btn-lg" role="button"> <span class="glyphicon glyphicon-print"></span> Generate Bill</a>

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
	  <div class="col-sm-4">
          <iframe src="bills.html" style="width: 400px; height: 200px;"></iframe>
           
          </div>
	  
</div> <br>
  
</form></div>
		 
	  

</body>
</html>

