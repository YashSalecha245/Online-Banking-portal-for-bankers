import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2,ps3; ResultSet rs1,rs2;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select empid from employee where empid=? and emppassword=?";
            String qr2="select empid from employee where empid=?";
            String qr3="insert into employee values(?,?,?,?,?)";
            ps1=con.prepareStatement(qr1);
            ps2=con.prepareStatement(qr2);
            ps3=con.prepareStatement(qr3);
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
        String s1=request.getParameter("empidold");
        String s2=request.getParameter("emppasswordold");
        String s3=request.getParameter("empid");
        String s4=request.getParameter("empname");
        String s5=request.getParameter("emppassword");
        String s6=request.getParameter("empphone");
        String s7=request.getParameter("empaddress");
        try{
            ps1.setString(1,s1);
            ps1.setString(2,s2);
         
            ps2.setString(1,s3);
            
            ps3.setString(1,s3);        
            ps3.setString(2,s4);
            ps3.setString(3,s5);
            ps3.setString(4,s6);
            ps3.setString(5,s7);
            rs1=ps1.executeQuery();
            boolean found1=rs1.next();
            if (found1!=true){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid Employee Credentials');");
                out.println("location='Index.jsp';");
                out.print("</script>");
                //response.sendRedirect("Index.jsp");
            }
            else {
                rs2=ps2.executeQuery();
                boolean found2=rs2.next();
                if (found2!=true){
                    ps3.executeUpdate();
                    out.println("done");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Signup Successful');");
                    out.println("location='Index.jsp';");
                    out.print("</script>");
                    
                }
                else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('This Employee Already Exists');");
                out.println("location='Index.jsp';");
                out.print("</script>");
                }
            }
           
        }catch(Exception e){
           out.println(e);
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
