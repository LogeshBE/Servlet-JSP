<%@page import="java.sql.*"%>
<%
    String fname=request.getParameter("fname");
    String lname=request.getParameter("lname");
    String bg=request.getParameter("BG");
    String cno=request.getParameter("contactnumber");
    String address=request.getParameter("Address");
  String query="insert into persondetails values('"+fname+"','"+lname+"','"+bg+"','"+cno+
            "','"+address+"')";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_donation","root","12345");
    Statement st=con.createStatement();
    st.executeUpdate(query);
    RequestDispatcher rd=request.getRequestDispatcher("index.html");
    rd.include(request, response);
    
%>