import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewUserServlet"})
public class NewUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       PrintWriter pw=response.getWriter();
       String Name = request.getParameter("Username");
       String PhoneNum= request.getParameter("MobileNum");
       int Pin_num= Integer.valueOf(request.getParameter("Password"));
       int R_Pin = Integer.valueOf(request.getParameter("R-Password"));
       String Bank_num = request.getParameter("Bank Acc");
       String Bank_name= request.getParameter("Bank Name");
       int Acc_balance= Integer.valueOf(request.getParameter("Acc_Balance"));
       String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
            String Sql="Insert into user_bankdetails values( '"+Name+"','"+PhoneNum+"',"+Pin_num+",'"+Bank_num+"','"+Bank_name+"',"+Acc_balance+");";
           
       if(Pin_num==R_Pin)
       {    
           try
           {
              Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                st.executeUpdate(Sql);
                st.executeUpdate("create table "+"T"+PhoneNum+"(payment_id varchar(20), Withdraw int, deposit int);");
           }
           catch(Exception e)
           {
               pw.println(e);
           }
//          response.sendRedirect("index.html");
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
                pw.print("<html><body><script>alert(\"Account Created Successfully\")</script></body></html>");
       }
       else
       {
           RequestDispatcher rd = request.getRequestDispatcher("NewUser.html");
          rd.include(request, response);
           pw.print("<html><body><script>alert(\"Entered password mismatch\")</script></body></html>");
       }
    }

}