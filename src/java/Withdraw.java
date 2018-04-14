import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class Withdraw extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2,ps3; ResultSet rs1,rs2;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select accountid,accountbalance from account where customerid=? and accountid=?";
            String qr2="update account set accountbalance=? where accountid=?";
            String qr3="insert into transaction values(?,?,?,?,?,?)";
            ps1=con.prepareStatement(qr1);
            ps2=con.prepareStatement(qr2);
            ps3=con.prepareStatement(qr3);
        }catch(ClassNotFoundException | SQLException e){
         }
    }
    @Override
    public void destroy(){
        try{
        con.close();
        }catch(SQLException e){}
    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Date date=new Date();
        String s1=request.getParameter("customerid");
        String s2=request.getParameter("accountid");
        String s3=request.getParameter("amount");
        String s4= date.toString();
        String s5="Withdraw";
        try{
            ps1.setString(1,s1);
            ps1.setString(2,s2);
            rs1=ps1.executeQuery();
            boolean found1=rs1.next();
            if(found1!=true)
             {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Account Does Not Exist');");
                out.println("location='Withdraw.jsp';");
                out.print("</script>");
             }
            else {
                String amount=rs1.getString(2);
                String s7=Integer.toString(Integer.parseInt(amount)-(Integer.parseInt(s3))); 
                out.print(s7);
                if(Integer.parseInt(s7)>500)
                {
                    ps2.setString(2,s2);
                    ps2.setString(1,s7);
                    
                    ps3.setString(1,s1);
                    ps3.setString(2,s2);
                    ps3.setString(3,s4);        
                    ps3.setString(4,s5);
                    ps3.setString(5,s2);
                    ps3.setString(6,s3);
                    
                    ps2.executeUpdate();
                    ps3.executeUpdate();

                }
                else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please Withdraw Above Atleast 500');");
                out.println("location='Withdraw.jsp';");
                out.print("</script>");
                }
            }
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Withdrawl Succesful');");
                out.println("location='Home.jsp';");
                out.print("</script>");
        
        }catch(NumberFormatException | SQLException e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Problem In Money Withdrawl, Try Again Later');");
                out.println("location='Withdraw.jsp';");
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
