import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servlet2"})
public class servlet2 extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                     response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw=response.getWriter();
        Cookie k1[]=request.getCookies();
        String name=k1[0].getValue();
        String pass=k1[1].getValue();
                Cookie ck=new Cookie("name","");  
        ck.setMaxAge(0);  
        response.addCookie(ck);
         try
        {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_store","root","12345");
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from login");
              while(rs.next())
            {    
                 if(name.equals(rs.getString(1)))
                 {  
                      if(pass.equals(rs.getString(2))){ 
                          response.sendRedirect("store1billingmodule.jsp");
                      }
                         }
            }                  
            rs.close();
            st.close();
            con.close();
           
        }
         catch(Exception e)
        {  pw.println("Error message:"+e.toString());
        }

                pw.close();
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
