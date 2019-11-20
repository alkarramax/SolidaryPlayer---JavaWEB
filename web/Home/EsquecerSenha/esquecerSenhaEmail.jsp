<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="../../ConfirmarEmail" method="post" enctype="multipart/form-data">  
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nomeNecessidade"/>
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../home.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>
