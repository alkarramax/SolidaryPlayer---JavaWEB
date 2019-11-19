<%@page import="model.Necessidade"%>
<%@page import="java.util.List"%>
<%@page import="DAO.JDBCNecessidadeDAO"%>
<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../admin.css"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastrar Campanha</title>
        
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <h3>Cadastrar Necessidade</h3>
            </div>
        </div>
        <form action="../../CadastrarNecessidade" method="post" enctype="multipart/form-data">  
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nomeNecessidade"/>
                <input type="text" class="form-control" name="Necessidade"/>
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>