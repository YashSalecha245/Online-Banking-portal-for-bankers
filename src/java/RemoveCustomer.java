import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.http.HttpSession;

public class RemoveCustomer extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2; ResultSet rs1,rs2;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select * from loan where customerid=?";
            String qr2="delete from customer where customerid=?";
            ps1=con.prepareStatement(qr1);
            ps2=con.prepareStatement(qr2);
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
        String s2=request.getParameter("customerid");
        try{
            ps1.setString(1,s2);
            rs1=ps1.executeQuery();
            if(rs1.next()){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Cannot Remove Customer..Pay Pending Loans First!!');");
                out.println("location='RemoveCustomer.jsp';");
                out.print("</script>");
            }
            else {
                ps2.setString(1,s2);
                ps2.executeUpdate();
            
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Customer Succesfully Removed');");
                out.println("location='Home.jsp';");
                out.print("</script>");
            }
            
        }catch(Exception e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error In Removing Customer..Try Again Later');");
                out.println("location='NewAccount.jsp';");
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


