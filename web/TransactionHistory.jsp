
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
  Connection con;PreparedStatement ps;
   
        String qr="select *from transaction where customerid=? and accountid=?  ";
       
     
      
        
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
    <th>Account Id</th>
    <th>Time and Date</th>
    <th>Type</th>
    <th>Destination Id</th>
    <th>Amount</th>
  </tr>
 
                                  <%
                                    String customerid=request.getParameter("customerid");
                                    String accountid=request.getParameter("accountid");
                                      try{
                                            Class.forName("com.mysql.jdbc.Driver");
                                            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
                                            ps = con.prepareStatement(qr);
                                       
                                    ps.setString(1, customerid);
                                    ps.setString(2, accountid);
                                    ResultSet rs = ps.executeQuery();
                                    
                                   if(!rs.next())
                                    {
                                          out.println("<script type=\"text/javascript\">");  
                                          out.println("alert('No Result Found');"); 
                                          out.println("location='ShowTransaction.jsp';");
                                          out.println("</script>");
                                    }
                                    do
                                    {
                                %>

  <tr>
    
    <td> <%=rs.getString(1) %> </td>
    <td><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
    <td><%=rs.getString(6) %></td>
  </tr>
  
  <%
      }while (rs.next());
}catch(Exception e){}
  %>
  
</table>
  <div><button type="submit" class="btn "> <a href="Home.jsp" style="color: black;">Back To Home</a></button></div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
</body>
</html>
