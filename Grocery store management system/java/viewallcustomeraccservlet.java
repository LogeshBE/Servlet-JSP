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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAP
 */
@WebServlet(urlPatterns = {"/viewallcustomeraccservlet"})
public class viewallcustomeraccservlet extends HttpServlet {

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
            out.println("<title>Servlet viewallcustomeraccservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewallcustomeraccservlet at " + request.getContextPath() + "</h1>");
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
        Cookie k[]=request.getCookies();
        String branch=k[1].getValue();
         try
        {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_store","root","12345");
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM customer_accounts where branch_id='"+branch+"'");
                               RequestDispatcher rd=request.getRequestDispatcher("viewallcustomeracc.jsp");
        rd.include(request, response); 
             pw.println("<html><body><br><br><br><font color=\"white\"><table border=\"10\" style=\"background-color:gray;\" cellpadding=\"100\" align=\"center\"><center>");
             pw.println("<tr style=\"background-color:#1E90FF;\"><th><h3> BRANCH ID</h3></th><th><h3> CUSTOMER NAME </h3></th><th><h3>CUSTOMER MOBILE NUMBER</h3></th><th><h3>ADDITIONAL INFORMATION</h3></th></tr>");
        
              while(rs.next())
            {    
              
               pw.println("<tr align=\"center\"><td><h4>"+" "+rs.getString(1)+" "+"</h4></td><td><h4>"+" "+rs.getString(2)+" "+"</h4></td><td><h4>"+" "+rs.getString(3)+" "+"</h4></td><td><h4>"+" "+rs.getString(4)+" "+"</h4></td></tr>");
            }  
              pw.println("</center></table></font></body></html>");
              
            rs.close();
            st.close();
            con.close();
           
        }
         catch(Exception e)
        {  pw.println("Error message:"+e.toString());
        }
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
