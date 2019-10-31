<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../admin.css"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastrar Entidade</title>
        
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <h3>Cadastrar Campanha</h3>
            </div>
        </div>
        <form action="../../criarCampanha" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nome" >
            </div>
            <div class="form-group">
                <label>Email: </label>
                <input type="text" class="form-control" name="email" >
            </div>
            <div class="form-group">
                <label>Causa: </label>
                <input type="text" class="form-control" name="causa" >
            </div>
            <div class="form-group">
                <label>Endereço: </label>
                <input type="text" class="form-control" name="endereco" >
            </div>
            <div class="form-group">
                <label>Telefone: </label>
                <input type="text" class="form-control" name="telefone" placeholder="(xx)9xxxx-xxxx" >
            </div>
            <div class="form-group">
                <label>Descrição: </label>
                <textarea class="form-control" name="descricao" ></textarea>
            </div>
            
            <div>
                <input type="file" name="file" size="50"/>
            </div>
            
            </br>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>
