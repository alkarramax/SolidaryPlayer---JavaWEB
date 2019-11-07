<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <%
        Connection connVoluntariado = DBConnection.getConnection();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Editar Voluntariado</title>
        
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
                <h3>Editar Voluntariado</h3>
            </div>
        </div>
        <form action="../../editarVoluntariado" method="post">
            <%
                Statement st = connVoluntariado.createStatement();
                String u = request.getParameter("u");
                int num = Integer.parseInt(u);
                
                String data = "select * from voluntariado where id_voluntariado='"+num+"'";
                ResultSet rs = st.executeQuery(data);
                while(rs.next()) {
            %>
            <input type="hidden" name="id_voluntariado" value='<%= rs.getString("id_voluntariado")%>'/>
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nome" value='<%= rs.getString("nome")%>' >
            </div>
            <div class="form-group">
                <label>Local: </label>
                <input type="text" class="form-control" name="email" value='<%= rs.getString("local")%>'>
            </div>
            <div class="form-group">
                <label>Data: </label>
                <input type="text" class="form-control" name="causa" value='<%= rs.getString("data")%>'>
            </div>
            <div class="form-group">
                <label>Hora:</label>
                <input type="text" class="form-control" name="endereco" value='<%= rs.getString("hora")%>'>
            </div>
            <div class="form-group">
                <label>Descrição: </label>
                <textarea class="form-control" name="descricao" ><%= rs.getString("descricao")%></textarea>
            </div>
            <div class="form-group">
                <label>Imagem: </label>
                <input type="tel" class="form-control" name="telefone" value='<%= rs.getString("imagem")%>'>
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
