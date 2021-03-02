
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

@WebServlet(urlPatterns = {"/TransactiondetailsServlet"})
public class TransactiondetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
           String sql= "Select * from "+"T"+PhoneNum+";";
           
          try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                ResultSet rs=st.executeQuery(sql);
                
                pw.print("<html><body><center><table border='2'><tr><td>Phone Number</td><td> Withdraw </td><td> Deposit </td></tr>");
                while(rs.next()){
                   pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
                }
                pw.print("</table></center></body></html>");
           }
          catch(Exception e) { pw.print(e);}
   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

}
