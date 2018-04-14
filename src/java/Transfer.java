import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class Transfer extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7; ResultSet rs1,rs2,rs3;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select accountbalance from account where customerid=? and accountid=?";
            String qr2="select customerid,accountbalance from account where accountid=?";
            String qr3="select customername from customer where customerid=?";
            String qr4="update account set accountbalance=? where accountid=?";
            String qr5="update account set accountbalance=? where accountid=?";
            String qr6="insert into transaction values(?,?,?,?,?,?)";
            String qr7="insert into transaction values(?,?,?,?,?,?)";
            
            
            ps1=con.prepareStatement(qr1);
            ps2=con.prepareStatement(qr2);
            ps3=con.prepareStatement(qr3);
            ps4=con.prepareStatement(qr4);
            ps5=con.prepareStatement(qr5);
            ps6=con.prepareStatement(qr6);
            ps7=con.prepareStatement(qr7);
        }catch(Exception e){
         }
    }
    @Override
    public void destroy(){
        try{
        con.close();
        }catch(Exception e){}
    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Date date=new Date();
        String s1=request.getParameter("customerid");
        String s2=request.getParameter("accountid");
        String s3=request.getParameter("amount");
        String s4=request.getParameter("destinationid");
        String s5= date.toString();
        String s6="Deposit";
        String s7="Send";
        String s8="Receive";
        try{
            ps1.setString(1,s1);
            ps1.setString(2,s2);
            rs1=ps1.executeQuery();
            boolean found1=rs1.next();
            if (found1==false){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Account Does Not Exist);");
                out.println("location='Transfer.jsp';");
                out.print("</script>");
            }
            ps2.setString(1,s4);
            rs2=ps2.executeQuery();
            boolean found2=rs2.next();
            if (found2==false){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Destination Account Id Is Invalid');");
                out.println("location='Transfer.jsp';");
                out.print("</script>");
            }
            String destinationCustomerId = rs2.getString(1); 
            ps3.setString(1,destinationCustomerId);
            String destinationamount=rs2.getString(2);
            rs3=ps3.executeQuery();
            rs3.next();
            String amount=rs1.getString(1);
            String destinationname=rs3.getString(1);
            if (found1==true&&found2==true){
                String s9=Integer.toString((Integer.parseInt(amount)-Integer.parseInt(s3)));
                String s10=Integer.toString((Integer.parseInt(destinationamount)+Integer.parseInt(s3)));
                if(Integer.parseInt(s9)>500)
                {
                    ps4.setString(1,s9);
                    ps4.setString(2,s2);
                    ps5.setString(1,s10);
                    ps5.setString(2,s4);
                    
                    ps4.executeUpdate();
                    ps5.executeUpdate();
                    
                    ps6.setString(1,s1);        
                    ps6.setString(2,s2);
                    ps6.setString(3,s5);
                    ps6.setString(4,s7);
                    ps6.setString(5,s4);
                    ps6.setString(6,s3);
                    
                    ps7.setString(1,destinationCustomerId);        
                    ps7.setString(2,s4);
                    ps7.setString(3,s5);
                    ps7.setString(4,s8);
                    ps7.setString(5,s2);
                    ps7.setString(6,s3);
                    
                    ps6.executeUpdate();
                    ps7.executeUpdate();
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Tranfer Process Complete')");
                    out.println("location='Home.jsp';");
                    out.print("</script>");
                }
                else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Balance Not Sufficient For Transfer');");
                out.println("location='Deposit.jsp';");
                out.print("</script>");
                }
            }
        }catch(Exception e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Problem In Processing Transfer..Try Again Later');");
                out.println("location='Transfer.jsp';");
                out.print("</script>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
