import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        
               HttpSession session = request.getSession();

       String PhoneNum =(String)session.getAttribute("PhoneNum") ;
       int Pin_num= Integer.valueOf(session.getAttribute("Pin_num").toString()) ;
       
       if(PhoneNum.equals("null")) response.sendRedirect("index.html");
 
           String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
           String sql= "Select * from user_bankdetails where phone_num='"+PhoneNum+"' and pin="+Pin_num+";";
           
           String Name="";
           String Phonenum="",Bank_accnum="",Bank_name="";
          try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    Name=rs.getString("user_name");
                    Phonenum=rs.getString("phone_num");
                    Bank_accnum=rs.getString("bank_accnum");
                    Bank_name=rs.getString("bank_name");
                }
                pw.print("<html>"
                        +"<body>"
                        +"<button><a href=\"checkbalanceservlet\">Check Balance</a></button>"
                        +"<button><a href=\"Changepassword.html\">Change Password</a></button>"
                        +"<button><a href=\"SendPayment.html\">Send Payment</a></button>"
                        +"<button><a href=\"TransactiondetailsServlet\">Transaction Details</a></button>"
                        +"<button><a href=\"LogoutServlet\">LogOut</a></button>"
                        +"<h2><u>PROFILE</u></h2><br><br>"
                        +"Name : "+Name+"<br><br>"
                        +"Phone Number : "+ Phonenum+"<br><br>"
                        +"Bank Account Number : "+Bank_accnum+"<br><br>"
                        +"Bank Name : "+Bank_name+"<br><br>"  
                        + "</body>"
                        + "</html>");
           }
           catch(Exception e )   {  pw.print(e); } 
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        
               HttpSession session = request.getSession();

       String PhoneNum =(String)session.getAttribute("PhoneNum") ;
       int Pin_num= Integer.valueOf(session.getAttribute("Pin_num").toString()) ;
 
       if(PhoneNum.equals("null")) response.sendRedirect("index.html");
       
           String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
           String sql= "Select * from user_bankdetails where phone_num='"+PhoneNum+"' and pin="+Pin_num+";";
           
           String Name="";
           String Phonenum="",Bank_accnum="",Bank_name="";
          try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    Name=rs.getString("user_name");
                    Phonenum=rs.getString("phone_num");
                    Bank_accnum=rs.getString("bank_accnum");
                    Bank_name=rs.getString("bank_name");
                }
                pw.print("<html>"
                        +"<body>"
                        +"<button><a href=\"checkbalanceservlet\">Check Balance</a></button>"
                        +"<button><a href=\"Changepassword.html\">Change Password</a></button>"
                        +"<button><a href=\"SendPayment.html\">Send Payment</a></button>"
                        +"<button><a href=\"TransactiondetailsServlet\">Transaction Details</a></button>"
                        +"<button><a href=\"LogoutServlet\">LogOut</a></button>"
                        +"<h2><u>PROFILE</u></h2><br><br>"
                        +"Name : "+Name+"<br><br>"
                        +"Phone Number : "+ Phonenum+"<br><br>"
                        +"Bank Account Number : "+Bank_accnum+"<br><br>"
                        +"Bank Name : "+Bank_name+"<br><br>"  
                        
                        + "</body>"
                        + "</html>");
           }
           catch(Exception e )   {  pw.print(e); } 
      
    }

    

}
