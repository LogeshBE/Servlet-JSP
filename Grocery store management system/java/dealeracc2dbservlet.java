/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LAP
 */
@WebServlet(urlPatterns = {"/dealeracc2dbservlet"})
public class dealeracc2dbservlet extends HttpServlet {

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
            out.println("<title>Servlet dealeracc2dbservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dealeracc2dbservlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        Cookie k[]=request.getCookies();
        String branch=k[1].getValue();
        String pname=request.getParameter("productname");
        String pcode=request.getParameter("productcode");
        String punit=request.getParameter("unit");
        String pvolume=request.getParameter("volume");
        String pquantity=request.getParameter("quantity");
        String pprice=request.getParameter("price");
          HttpSession session=request.getSession(); 
          String dealer_mobile=session.getAttribute("mn").toString(); 
//          pw.println(dealer_mobile);
          try
        {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/grocery_store","root","12345");
            
            Statement st=con.createStatement();
             int rs=st.executeUpdate("INSERT INTO  stock_details VALUES('"+branch+"','"+dealer_mobile+"','"+pname+"','"+pcode+"','"+punit+"','"+pvolume+"','"+pquantity+"','"+pprice+"')");
//            int Result=st.executeUpdate("INSERT INTO marklist VALUES("+roll+",'"+name+"',"+eng+","+phy+","+che+","+mat+","+sci+")");
//              response.sendRedirect("/Grocery_Store/customeracccreate.jsp");
             RequestDispatcher rd=request.getRequestDispatcher("dealeraccessacc.jsp");
        rd.include(request, response);
               pw.println("<html><body><script>alert(\" Product is successfully added..\");</script></body></html>");
              session.invalidate();  
            st.close();
            con.close();
           
        }
         catch(Exception e)
        {  pw.println("Error message:"+e.toString());
        }

                pw.close();

        
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
