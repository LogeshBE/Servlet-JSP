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
@WebServlet(urlPatterns = {"/customeracccreateservlet"})
public class customeracccreateservlet extends HttpServlet {

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
            out.println("<title>Servlet customeracccreateservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customeracccreateservlet at " + request.getContextPath() + "</h1>");
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
        String name=request.getParameter("name");
        String mobilenum=request.getParameter("mobileno");
        String addinfo=request.getParameter("addinfo");
//        pw.print(branch);
         try
        {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_store","root","12345");
            
            Statement st=con.createStatement();
             int rs=st.executeUpdate("INSERT INTO  customer_accounts VALUES('"+branch+"','"+name+"','"+mobilenum+"','"+addinfo+"')");
//            int Result=st.executeUpdate("INSERT INTO marklist VALUES("+roll+",'"+name+"',"+eng+","+phy+","+che+","+mat+","+sci+")");
//              response.sendRedirect("/Grocery_Store/customeracccreate.jsp");
             RequestDispatcher rd=request.getRequestDispatcher("customeracccreate.jsp");
        rd.include(request, response);
               pw.println("<html><body><script>alert(\""+name+" account is successfully created..\");</script></body></html>");
              
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
