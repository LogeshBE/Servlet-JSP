
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

@WebServlet(urlPatterns = {"/SendPaymentServlet"})
public class SendPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        
        String transfer_id=request.getParameter("Tranfernumber");
        int Amount = Integer.valueOf(request.getParameter("Amounttobepaid"));
        
               HttpSession session = request.getSession();

       String PhoneNum =(String)session.getAttribute("PhoneNum") ;
       int Pin_num= Integer.valueOf(session.getAttribute("Pin_num").toString()) ;
       
       if(PhoneNum.equals("null")) response.sendRedirect("index.html");
 
           String Drivername = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/bankaccount";
            String dbuser="root";
            String dbpass="12345";
            int senderbalance=0,receiverbalance=0;
           String senderpaymentupdatesql= "Insert into "+"T"+PhoneNum+" values('"+transfer_id+"',"+Amount+",0);";
           String receiverpaymentupdatesql= "Insert into "+"T"+transfer_id+" values('"+PhoneNum+"',0,"+Amount+");";
           String getsenderbalancesql= "Select acc_balance from user_bankdetails where phone_num='"+PhoneNum+"';";
           String getreceiverbalancesql= "Select acc_balance from user_bankdetails where phone_num='"+transfer_id+"';";

           try 
           {
                Class.forName(Drivername);
                Connection con=DriverManager.getConnection(url,dbuser,dbpass);
                Statement st1=con.createStatement(),st2=con.createStatement(); 
                ResultSet rs1=st1.executeQuery(getsenderbalancesql);
                ResultSet rs2=st2.executeQuery(getreceiverbalancesql);
                if(PhoneNum.equals(transfer_id)){
                    RequestDispatcher rd = request.getRequestDispatcher("SendPayment.html");
                    rd.include(request, response);
                    pw.print("<script>alert(\" Transfer id must not be same on your id !\")</script>");
                }
                else{
                if(rs1.next() && rs2.next()){
                    senderbalance=Integer.valueOf(rs1.getString("acc_balance"));
                    receiverbalance=Integer.valueOf(rs2.getString("acc_balance"));
                    if(senderbalance>=Amount){
                        
                        st1.executeUpdate(senderpaymentupdatesql);
                        st1.executeUpdate("Update user_bankdetails set acc_balance = "+(senderbalance-Amount)+" where phone_num = '"+PhoneNum+"';");
                        st2.executeUpdate(receiverpaymentupdatesql);
                        st2.executeUpdate("Update user_bankdetails set acc_balance = "+(receiverbalance+Amount)+" where phone_num = '"+transfer_id+"';");
                            
                        
            RequestDispatcher rd = request.getRequestDispatcher("SendPayment.html");
          rd.include(request, response);
           pw.print("<script>alert(\"Payment transfer successfully !\")</script>");
                    }
                    else{
           RequestDispatcher rd = request.getRequestDispatcher("SendPayment.html");
          rd.include(request, response);
           pw.print("<script>alert(\"Your current balance is insufficient to tranfer !\")</script>");
                    }
                }
                else{
            RequestDispatcher rd = request.getRequestDispatcher("SendPayment.html");
          rd.include(request, response);
           pw.print("<script>alert(\"Transfer id does not exit !\")</script>");
                }
     
             }    
           }
           catch(Exception e){ pw.print(e);} 
        
    }


}
