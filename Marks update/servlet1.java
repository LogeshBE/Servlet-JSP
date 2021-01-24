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

/**
 *
 * @author LAP
 */
@WebServlet(urlPatterns = {"/servlet1"})
public class servlet1 extends HttpServlet {

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
            out.println("<title>Servlet servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet1 at " + request.getContextPath() + "</h1>");
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
      //  processRequest(request, response);
          PrintWriter pw=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=request.getRequestDispatcher("/newhtml.html");
        rd.include(request, response); 
        
       
                 pw.println("HI Hello");   

         
        String droll=request.getParameter("t1");
        String name =request.getParameter("t2");
        String deng=request.getParameter("t3");
        String dphy=request.getParameter("t4");
        String dche=request.getParameter("t5");
        String dmat =request.getParameter("t6");
        String dsci=request.getParameter("t7");
        
        int roll = Integer.valueOf(droll);
           int eng = Integer.valueOf(deng);
              int phy = Integer.valueOf(dphy);
                 int che  = Integer.valueOf(dche);
                    int mat  = Integer.valueOf(dmat);
                       int sci = Integer.valueOf(dsci);
                         int total=eng+phy+che+mat+sci;
   
        try
        {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;database=Logesh","sa","12345");
            
            Statement st=con.createStatement();
            
            int Result=st.executeUpdate("INSERT INTO marklist VALUES("+roll+",'"+name+"',"+eng+","+phy+","+che+","+mat+","+sci+","+total+")");
            
            ResultSet rs=st.executeQuery("select * from marklist");
            int col=rs.getMetaData().getColumnCount();
            pw.println("No. of column : "+col);
           
            String colname[]=new String[col];
            
            for (int i=0;i<col;i++)
            {
            //    pw.println("col name = "+rs.getMetaData().getColumnName(i) + "    data type "+rs.getMetaData().getColumnClassName(i));
            colname[i]=rs.getMetaData().getColumnName(i+1);
            }
                      pw.println("<html><center><table border='1'><tr>");
                      
                      for(int k=0;k<col;k++)
                      {
                          pw.println("<th>"+colname[k]+"</th>");
                      }
                      pw.println("</tr>");
            while(rs.next()==true)
            {  
                pw.println("<tr>");
                for(int j=0;j<col;j++)
                {
                    
                   pw.print("<td>"+rs.getString(colname[j])+"</td>");
                }
                pw.println("</tr>");
            }
            pw.println("</table></center></html>");
            
            
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
        doGet(request, response);
        //   processRequest(request, response);
          //        PrintWriter pw=response.getWriter();
            //     pw.println("HI Hello");
        
        //   response.sendRedirect("newhtml.html");
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
