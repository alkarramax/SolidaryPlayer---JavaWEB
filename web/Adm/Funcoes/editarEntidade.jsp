<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <%
        Connection connEntidade = DBConnection.getConnection();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Editar Entidade</title>
        
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
                <h3>Editar Entidade</h3>
            </div>
        </div>
        <form action="../../editarEntidade" method="post">
            <%
                Statement st = connEntidade.createStatement();
                String u = request.getParameter("u");
                int num = Integer.parseInt(u);
                
                String data = "select * from entidade where id='"+num+"'";
                ResultSet rs = st.executeQuery(data);
                while(rs.next()) {
            %>
            <input type="hidden" name="id" value='<%= rs.getString("id")%>'/>
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nome" value='<%= rs.getString("nome")%>' >
            </div>
            <div class="form-group">
                <label>Email: </label>
                <input type="text" class="form-control" name="email" value='<%= rs.getString("email")%>'>
            </div>
            <div class="form-group">
                <label>Causa: </label>
                <input type="text" class="form-control" name="causa" value='<%= rs.getString("causa")%>'>
            </div>
            <div class="form-group">
                <label>Endereço: </label>
                <input type="text" class="form-control" name="endereco" value='<%= rs.getString("endereco")%>'>
            </div>
            <div class="form-group">
                <label>Telefone: </label>
                <input type="tel" class="form-control" name="telefone" value='<%= rs.getString("telefone")%>'>
            </div>
            <div class="form-group">
                <label>Descrição: </label>
                <textarea class="form-control" name="descricao" ><%= rs.getString("descricao")%></textarea>
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
