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

@WebServlet(urlPatterns = {"/ChangePassswordServlet"})
public class ChangePassswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {   
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        
        int oldpass=Integer.valueOf(request.getParameter("OldPassword"));
        int newpass=Integer.valueOf(request.getParameter("NewPassword"));
        
               HttpSession session = request.getSession();

       String PhoneNum =(String)session.getAttribute("PhoneNum") ;
       int Pin_num= Integer.valueOf(session.getAttribute("Pin_num").toString()) ;
       
       if(PhoneNum.equals("null")) response.sendRedirect("index.html");
 
           String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
           String sql= "Select * from user_bankdetails where phone_num='"+PhoneNum+"' and pin="+Pin_num+";";
           
           int alreadypassword=0;
          try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st=con.createStatement();  
                ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    alreadypassword=Integer.valueOf(rs.getString("pin")); 
                }
                if(oldpass==alreadypassword){
                    st.executeUpdate("Update user_bankdetails set pin = "+newpass+" where phone_num = '"+PhoneNum+"';");
                    RequestDispatcher rd = request.getRequestDispatcher("Changepassword.html");
          rd.include(request, response);
           pw.print("<html><body><script>alert(\"Password Changed successfully\")</script></body></html>");
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("Changepassword.html");
          rd.include(request, response);
           pw.print("<html><body><script>alert(\"Oldpassword mismatch!\")</script></body></html>");
                }
              
           }
           catch(Exception e )   {  pw.print(e); } 
    }

}
