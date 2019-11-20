<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../admin.css"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Esqueceu sua senha?</title>
        
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <h3>Insira o seu e-mail</h3>
            </div>
        </div>
        <form action="../../ConfirmarEmail" method="post">  
            <div class="form-group">
                <label>E-mail: </label>
                <input type="email" class="form-control" name="email"/>
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../home.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>
