/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/branchlogin1servlet"})
public class branchlogin1servlet extends HttpServlet {

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
            out.println("<title>Servlet branchlogin1servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet branchlogin1servlet at " + request.getContextPath() + "</h1>");
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
        
        
        
               PrintWriter pw=response.getWriter();
             response.setContentType("text/html;charset=UTF-8");
             
             String name =request.getParameter("usr");
            String upass =request.getParameter("pswd");
            pw.println("The username is "+name+"<br><br>");
            pw.println("The password is "+upass);
            
            pw.println("<br><br><br>");
            
            Cookie c1=new Cookie("uname",name);
            Cookie c2=new Cookie("upass",upass);
            
            response.addCookie(c1);
            response.addCookie(c2);
            
//             Cookie k1[]=request.getCookies();
//		
//		pw.println("Hai name is  "+k1[0].getValue());
//                pw.println("<br>");
//                pw.println("Hai password is "+k1[1].getValue());
                
                response.sendRedirect("/Grocery_Store/branchlogin2servlet");
////           pw.println("HELLO   "+"<br>");
//    pw.print("<form method='get' action=\"\\cookies\\servlet2\" >");  
//    pw.print("<input type='submit' value='go'>");  
//    pw.print("</form>");  
//          
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
