import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter pw=response.getWriter();
        
         String PhoneNum= request.getParameter("PhoneNumber");
       int Pin_num= Integer.valueOf(request.getParameter("PinNumber"));
       
        HttpSession session = request.getSession();
        session.setAttribute("PhoneNum",PhoneNum);
        session.setAttribute("Pin_num",Pin_num);
       
        String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
           String sql= "Select * from user_bankdetails where phone_num='"+PhoneNum+"' and pin="+Pin_num+";";
           try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                ResultSet rs=st.executeQuery(sql);
                if(rs.next())
                {
//                    response.sendRedirect("/HomeServlet");
          RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
          rd.forward(request, response);
                }
                else
                {
                     RequestDispatcher rd = request.getRequestDispatcher("index.html");
          rd.include(request, response);
           pw.print("<html><body><script>alert(\"Invalid PhoneNum or Password\")</script></body></html>");
                }
           }
           catch(Exception e)
                   {
                       pw.println(e);
                   }
    }
}
