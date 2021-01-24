<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
    <%! ResultSet rs=null;%>
    <div class="container bg-primary">
    <%
        try{
    String Bloodgroup=request.getParameter("BG");
    String query="Select * from persondetails where Blood_Group='"+Bloodgroup+"'";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_donation","root","12345");
    Statement st=con.createStatement();
    rs=st.executeQuery(query); 
        
    %>
     <font color="black"><button onclick="document.location='index.html'">Click hear to go Home Page</button>
    </font>
     <center> 
    <table border="10" style="background-color:red;">
       
        <tr> 
            <th><h3>First Name</h3></th>
            <th><h3>Last Name</h3></th>
            <th><h3>Blood Group<h3></th>
            <th><h3>Contact Number<h3></th>
            <th><h3>Address<h3></th>
        </tr>
     <% while(rs.next()){ %>
        <tr align="center" style="background-color:#1E90FF;">
        <td><h4><%=rs.getString(1)%></h4></td>
        <td><h4><%=rs.getString(2)%></h4></td>
        <td><h4><%=rs.getString(3)%></h4></td>
        <td><h4><%=rs.getString(4)%></h4></td>
        <td><h4><%=rs.getString(5)%></h4></td>
        </tr>
        
      <%  }
      }
     catch(Exception e){ out.print(e);}%>
    </table> 
    </center>
</div>
    
</body></html>