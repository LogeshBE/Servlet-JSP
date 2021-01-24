

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

@WebServlet(urlPatterns = {"/servlet1"})
public class servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        
         response.sendRedirect("/Javaweb2/newhtml.html");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        
        PrintWriter out=response.getWriter();
        String un=request.getParameter("t1");
        String pass=request.getParameter("t2");
        String age=request.getParameter("t3");
        String mn=request.getParameter("t4");
        
        int Age = Integer.valueOf(age);
       // int MN = Integer.valueOf(mn);
        
        RequestDispatcher rd=request.getRequestDispatcher("newhtml.html");
        rd.include(request, response);
        
        out.println("<br><br>");
        if(un.matches("[A-Z][a-zA-Z]*"))
        {
           // rd.include(request,response);
            out.println(" <font color='green'>User Name,Done..</font><br>");
         }
        else
        { // rd.include(request, response);    
           out.println("<font color='red'>The User must start with UpperCase</font><br>");}
       
       if(pass.matches("[0-9]{8,12}"))
       {// rd.include(request, response);
             out.println("<font color='green'>PIN set,successfully</font><br>");
       }
       
         else
        {    
           out.println("<font color='red'>The PIN must contains 8 to 12 Numbers</font><br>");}
       if((Age>=18)&&(Age<=100))
       { 
             out.println("<font color='green'>Age set,successfully</font><br>");
       }
        else
        {   
           out.println("<font color='red'>The Age must contains 18 to 100 Numbers</font><br>");}
       
        if(mn.matches("[6-9]{1}[0-9]{9}"))
       { 
             out.println("<font color='green'>Mobile number set,successfully</font><br>");
       }
       
         else
        {     
           out.println("<font color='red'>The Mobile number Must start with ( 6 to 9) and also it must contain 10 digits</font><br>");}
       
         RequestDispatcher r=request.getRequestDispatcher("servlet2");  

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
