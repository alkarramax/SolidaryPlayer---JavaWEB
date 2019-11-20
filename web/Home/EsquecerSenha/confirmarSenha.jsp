

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../../ConfirmarEmail" method="post">  
            <div class="form-group">
                <label>Senha: </label>
                <input type="password" class="form-control" name="senha"/>
            </div>
            <div class="form-group">
                <label>Confirmar Senha: </label>
                <input type="password" class="form-control" name="senhaConfirmar"/>
            </div>
           
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../home.jsp" class="btn btn-default">Voltar</a>
        </form>
    </body>
</html>
