

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    Connection con; PreparedStatement ps;  ResultSet rs;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr="select empid,empname,emppassword from employee where empid=? and empname=? and emppassword=?";
            ps=con.prepareStatement(qr);            
        }
        catch(Exception e){}
    }
    @Override
    public void destroy(){
        try{
        con.close();
        }
        catch(Exception e){}
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("empid");
        String s2=request.getParameter("empname");
        String s3=request.getParameter("emppassword");
        
        try{              
            ps.setString(1,s1);               
            ps.setString(2,s2);             
            ps.setString(3,s3);
            rs=ps.executeQuery();
            boolean found=rs.next();
            if(found==true){
                String empid=rs.getString(1);
                String empname=rs.getString(2);
                String emppassword=rs.getString(3);
                HttpSession session=request.getSession();
                session.setAttribute("empid",empid);
                session.setAttribute("empname",empname);
                session.setAttribute("emppassword",emppassword);
                //storing id/pwd to cookiess
                String s4=request.getParameter("checkbox");
                Cookie c1;
                Cookie c2;
                Cookie c3;
                if(s4!=null){
                    //step-1 (create cookie object(s)
                    c1=new Cookie("empid",empid);
                    c2=new Cookie("empname",empname);
                    c3=new Cookie("emppassword",emppassword);
                    //step-2 (set the maximum age of the cookie)
                    c1.setMaxAge(60*60*24*7);
                    c2.setMaxAge(60*60*24*7);
                    c3.setMaxAge(60*60*24*7);
                    //step-3 (add the cookie object(s) to response
                    response.addCookie(c1);
                    response.addCookie(c2);
                    response.addCookie(c3);
                    
                }
                else if (s4==null){
                                        //step-1 (create cookie object(s)
                    c1=new Cookie("empid",empid);
                    c2=new Cookie("empname",empname);
                    c3=new Cookie("emppassword",emppassword);
                    
                    //step-2 (set the maximum age of the cookie)
                    c1.setMaxAge(0);
                    c2.setMaxAge(0);
                    c3.setMaxAge(0);
                    //step-3 (add the cookie object(s) to response
                    response.addCookie(c1);
                    response.addCookie(c2);
                    response.addCookie(c3);
            
                }
            response.sendRedirect("Home.jsp");
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid Employee Credentials');");
                out.println("location='Index.jsp';");
                out.print("</script>");
            }
            
            }
            catch(Exception e){
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