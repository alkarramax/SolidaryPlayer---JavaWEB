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
        <title>Cadastrar Necessidade</title>
        
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
        <form action="../../CadastrarNecessidade" method="post">  
            <div class="form-group">
                <label>Necessidade: </label>
                <input class="form-control" name="necessidade" placeholder="Ex: Roupas" />
            </div>
            <div class="form-group">
                <label>Unidade: </label>
                <input class="form-control" name="unidade" placeholder="Ex: Peças" />
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>