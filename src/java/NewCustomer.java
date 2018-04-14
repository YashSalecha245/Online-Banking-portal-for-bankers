import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCustomer extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2; ResultSet rs1;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select customerid from customer where customerid=?";
            String qr2="insert into customer values(?,?,?,?,?)";
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
        String s1=request.getParameter("customerid");
        String s2=request.getParameter("customername");
        String s3=request.getParameter("customeraddress");
        String s4=request.getParameter("customercity");
        String s5=request.getParameter("customerphone");
        try{
            ps1.setString(1,s1);
            
            ps2.setString(1,s1);
            ps2.setString(2,s2);
            ps2.setString(3,s3);        
            ps2.setString(4,s4);
            ps2.setString(5,s5);
               
            rs1=ps1.executeQuery();
            boolean found1=rs1.next();
            if (found1==true){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Customer Already Exist');");
                out.println("location='NewCustomer.jsp';");
                out.print("</script>");
            }
            else {
                ps2.executeUpdate();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('New Customer Added..Welcome To iBANK');");
                out.println("location='Home.jsp';");
                out.print("</script>");
            }
           
        }catch(Exception e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('There Was Some Problem At Our End, Try Again Later');");
                out.println("location='NewCustomer.jsp';");
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
