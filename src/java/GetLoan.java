import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class GetLoan extends HttpServlet {

    Connection con; PreparedStatement ps1,ps2,ps3,ps4; ResultSet rs1,rs2;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
            String qr1="select accounttype from account where customerid=? and accountid=?";
            String qr2="insert into loan values(?,?,?)";
            String qr3="insert into payment values(?,?,?,?)";
            String qr4="select loanid from loan where loanid=?";
            ps1=con.prepareStatement(qr1);
            ps2=con.prepareStatement(qr2);
            ps3=con.prepareStatement(qr3);
            ps4=con.prepareStatement(qr4);
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
        String s4=request.getParameter("installment");
        String s5= date.toString();
        String s6="Withdraw";
        String s8=s1+s2;
        try{
            ps1.setString(1,s1);
            ps1.setString(2,s2);
            rs1=ps1.executeQuery();
            boolean found1=rs1.next();
            if (found1==true){
                ps4.setString(1,s8);
                rs2=ps4.executeQuery();
                boolean found2=rs2.next();
                if(found2==true)
                {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Loan Already Exist For Particular Account');");
                    out.println("location='GetLoan.jsp';");
                    out.print("</script>");
                }
                String type=rs1.getString(1);
                int rate=0;
                if(type.equals("Saving"))
                {
                    rate=2*Integer.parseInt(s3);
                }
                else if(type.equals("Current"))
                {
                    rate=5*Integer.parseInt(s3);
                }
                String s7=Integer.toString(Integer.parseInt(s3)+ (rate/100)); 
                int payment=Integer.parseInt(s7);
                if(payment>0)
                {
                    
                    ps2.setString(1,s1);
                    ps2.setString(2,s8);
                    ps2.setString(3,s7);
                    
                    ps2.executeUpdate();
                    int amount=payment; 
                    int temp=Integer.parseInt(s4);
                    for(int i=1;i<=temp&&payment>0;i++)
                    {
                        
                    ps3.setString(1,s8);
                    ps3.setString(2,s2+i);
                    ps3.setString(3,s5);        
                    ps3.setString(4,Integer.toString(amount/temp));
                    
                    ps3.executeUpdate();
                    payment-=amount/temp;
                    }
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Loan Succesfully Granted');");
                    out.println("location='Home.jsp';");
                    out.print("</script>");
                    
                }
                else{
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Select Valid Loan Amount And Installments');");
                    out.println("location='GetLoan.jsp';");
                    out.print("</script>");
                }
            }
            else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid Account Credentials');");
                out.println("location='GetLoan.jsp';");
                out.print("</script>");
            }
           
        }catch(NumberFormatException | SQLException e){
                out.print(e);
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */