

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <a href="addnew.jsp" class="btn btn-primary">Add New Data</a>
            </div>
        </div>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Email</th>
                    <th>Cargo</th>
                    <th>Unidade</th>
                </tr>
            </thead>
            <tbody>
            <%
               String host = "jdbc:mysql://localhost:3306/sa?serverTimezone=UTC";
               Connection conn = null;
               Statement stat = null;
               ResultSet rs = null;
               Class.forName("com.mysql.cj.jdbc.Driver");
               conn = DriverManager.getConnection(host, "root", "master123");
               stat = conn.createStatement();

               String data = "select * from softplayer";
               rs = stat.executeQuery(data);

               while(rs.next()) {
            %>
             <tr>
                <td><%=rs.getString("id")%></td>
                <td><%=rs.getString("nome")%></td>
                <td><%=rs.getString("sobrenome")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("cargo")%></td>
                <td><%=rs.getString("unidade")%></td>
                
             </tr>
            <%
             }
            %>
            </tbody>
        </table>
    </body>
</html>
