/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author LAP
 */
@WebServlet(urlPatterns = {"/dealeraccaccessservlet"})
public class dealeraccaccessservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dealeraccaccessservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dealeraccaccessservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        String mobilenum=request.getParameter("mobilenum");
         HttpSession session=request.getSession();  
        session.setAttribute("mn",mobilenum);  
        int count=0;
         try
        {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_store","root","12345");
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from dealer_accounts");
              while(rs.next())
            {    
                 if(mobilenum.equals(rs.getString(4)))
                 {  
                          response.sendRedirect("/Grocery_Store/dealer1.html");
//                      String dealer_mobile=(String)session.getAttribute("mobilenum"); 
//                      pw.println(dealer_mobile);
                  }
                 else count++;
            }   
              if(count>0){
                            RequestDispatcher rd=request.getRequestDispatcher("dealeraccessacc.jsp");
        rd.include(request, response); 
        pw.println("<html><body><script>alert(\" "+mobilenum+" not found in Dealers Account!\");</script></body></html>");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
