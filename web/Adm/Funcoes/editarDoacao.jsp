<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <%
        Connection connDoacao = DBConnection.getConnection();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Editar Doacao</title>
        
        <style>
            body {
                margin: 50px;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <h3>Editar Doacao</h3>
            </div>
        </div>
        <form action="../../editarDoacao" method="post">
            <%
                Statement st = connDoacao.createStatement();
                String u = request.getParameter("u");
                int num = Integer.parseInt(u);
                
                String data = "select * from doacao where id_doacao='"+num+"'";
                ResultSet rs = st.executeQuery(data);
                while(rs.next()) {
            %>
            <input type="hidden" name="id_doacao" value='<%= rs.getString("id_doacao")%>'/>
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nome" value='<%= rs.getString("nome")%>' >
            </div>
            <div class="form-group">
                <label>Descrição: </label>
                <input type="text" class="form-control" name="descricao" value='<%= rs.getString("descricao")%>'>
            </div>
            <div class="form-group">
                <label>Local: </label>
                <input type="text" class="form-control" name="local" value='<%= rs.getString("local")%>'>
            </div>
            <div class="form-group">
                <label>Data: </label>
                <input type="text" class="form-control" name="data" value='<%= rs.getString("data")%>'>
            </div>
            <%
            }
            %>
            
            <button type="submit" class="btn btn-primary">Editar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>
<%
    
%>
