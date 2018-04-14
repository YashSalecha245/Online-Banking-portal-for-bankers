import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.http.HttpSession;
public class CloseAccount extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2; ResultSet rs1,rs2;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="delete from account where accountid=? and customerid=?";
            ps1=con.prepareStatement(qr1);
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
        String s1=request.getParameter("accountid");
        String s2=request.getParameter("customerid");
        try{
            ps1.setString(1,s1);
            ps1.setString(2,s2);
            int n=ps1.executeUpdate();
            if(n==0)
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Account Does Not Exist');");
                out.println("location='CloseAccount.jsp';");
                out.print("</script>");
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Account Successfully Closed');");
                out.println("location='Home.jsp';");
                out.print("</script>");
            }
        }catch(Exception e){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Unable To Close This Account Right Now..Try Again Later');");
                out.println("location='CloseAccount.jsp';");
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


