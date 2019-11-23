

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../admin.css"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Alterar Senha</title>
        
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <%
            String emailSoftplayer = request.getParameter("email");
        %>
        
        <h2>Alterar Senha</h2>
        <form action="../../ConfirmarSenha?email=<%=emailSoftplayer%>" method="post">  
            <div class="form-group">
                <label>Senha: </label>
                <input type="password" class="form-control" name="senha"/>
            </div>
            <div class="form-group">
                <label>Confirmar Senha: </label>
                <input type="password" class="form-control" name="confirmarSenha"/>
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../home.jsp" class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>
