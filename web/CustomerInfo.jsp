
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
     String empid=(String)session.getAttribute("empid");
     String empname=(String)session.getAttribute("empname");
     String emppassword=(String)session.getAttribute("emppassword");
        if(empid==null||empname==null||emppassword==null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert('You Are Not Logged In...Login First');");
        out.println("location='Index.jsp';");
        out.print("</script>");
    }
%>
<%
  Connection con;PreparedStatement ps1,ps2;
   
        String qr1="select * from customer where customerid=?";
        String qr2="select accountid,accountbalance,accounttype from account where customerid=?";
%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title></title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="assets/css/style.css">
  
</head>

<body>
  

<table class="responstable" border="1">
  
  <tr>
    <th data-th="Driver details"><span>Customer Id</span></th>
    <th>Name</th>
    <th>Address</th>
    <th>City</th>
    <th>Phone</th>
  </tr>
 
                                  <%
                                    String customerid=request.getParameter("customerid");
                                    try{
                                            Class.forName("com.mysql.jdbc.Driver");
                                            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
                                            ps1 = con.prepareStatement(qr1);
                                            ps2 = con.prepareStatement(qr2);
                                    ps1.setString(1, customerid);
                                    ResultSet rs1 = ps1.executeQuery();
                                    ps2.setString(1, customerid);
                                    ResultSet rs2 = ps2.executeQuery();
                                   if(!rs1.next())
                                    {
                                          out.println("<script type=\"text/javascript\">");  
                                          out.println("alert('No Customer Found');"); 
                                          out.println("location='ViewCustomerInfo.jsp';");
                                          out.println("</script>");
                                    }

                                   
                                %>

  <tr>
    
    <td><%=rs1.getString(1) %></td>
    <td><%=rs1.getString(2) %></td>
    <td><%=rs1.getString(3) %></td>
    <td><%=rs1.getString(4) %></td>
    <td><%=rs1.getString(5) %></td>
  </tr>  
  </table>
  <table class="responstable" border="1">
  <tr>
    <th data-th="Driver details"><span>Account Id</span></th>
    <th>Balance</th>
    <th>Account Type</th>
  </tr>
<%
if(!rs2.next())
{
     out.println("<script type=\"text/javascript\">");  
     out.println("alert('No Account Found');"); 
     out.println("</script>");
}  
rs2.previous();
while(rs2.next()){
%>
  <tr>
    <td><%=rs2.getString(1) %></td>
    <td><%=rs2.getString(2) %></td>
    <td><%=rs2.getString(3) %></td>
  </tr>
<% }
    }catch(Exception e)
        {
            
        } 

%>  
</table>
  <div><button type="submit" class="btn "> <a href="Home.jsp" style="color: black;">Back To Home</a></button></div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
</body>
</html>
