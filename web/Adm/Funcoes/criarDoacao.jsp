<%-- 
    Document   : criarDoacao
    Created on : 28/10/2019, 16:55:42
    Author     : Aluno
--%>

<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastrar Doação</title>
        <style>
            body {
                margin: 12px;
            }
            
        </style>
    </head>
    <body>
        <form action="../../cadastrarDoacao" method="post" enctype="multipart/form-data">
            <label style="margin-right: 150px;">Entidade:</label>
            <select class="form-control" style="width: 250px;">
                <option value="-1">Selecione a Entidade</option>
                <%
                    Connection connEntidade = DBConnection.getConnection();
                    Statement statEntidade = connEntidade.createStatement();
                    String SQL = "select * from Entidade"; 
                    ResultSet rs = statEntidade.executeQuery(SQL);

                    while(rs.next()) {
                        %>
                        <option name="entidade" value="<%=rs.getString("id_entidade")%>"><%=rs.getString("nome")%></option>
                        <%
                    }
                %>
            </select>
            <div class="form-group">
                <label>Nome da doação: </label>
                <input type="text" class="form-control" name="nome" >
            </div>
            <div class="form-group">
                <label>Descrição: </label>
                <textarea class="form-control" name="descricao" ></textarea>
            </div>
            <div class="form-group">
                <label>Local: </label>
                <input type="text" class="form-control" name="local" >
            </div>
            <div class="form-group">
                <label>Data: </label>
                <input type="date" class="form-control" name="data" >
            </div>
            <div class="form-group">
                <label>Necessidade: </label>
                <input type="text" class="form-control" name="necessidade" >
            </div>
            <div>
                <input type="file" name="photo" size="50"/>
            </div>
            </br>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>
        
    </body>
</html>
