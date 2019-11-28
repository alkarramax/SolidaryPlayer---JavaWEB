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
                <h3>Cadastrar Campanha</h3>
            </div>
        </div>
        <form action="../../cadastrarCampanha" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="nome" >
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
                <label>Descrição: </label>
                <textarea class="form-control" name="descricao"  maxlength="1000" ></textarea>
            </div>
            
            <label>Beneficiario</label>
            <div class="form-check">
                <input type="checkbox" name="beneficiarios" class="form-check-input" id="idosos" value="idoso">
                <label class="form-check-label" for="idosos">Idosos</label>
            </div>
            <div class="form-check">
                <input type="checkbox" name="beneficiarios" class="form-check-input" id="criancas" value="crianca">
                <label class="form-check-label" for="criancas">Crianças</label>
            </div>
            
            <div>
                <input type="file" name="file" size="50"/>
            </div>
            
            <div>
                <label style="margin-right: 150px;">Necessidade</label>
                <select name="necessidade" class="form-control" style="width: 250px;">
                    <option value="-1">Selecione a necessidade</option>
                    <%
                        JDBCNecessidadeDAO necessidadeDAO = new JDBCNecessidadeDAO();
                        List<Necessidade> nest = necessidadeDAO.listar();
                        
                        for(Necessidade nec : nest) {
                            out.println("<option value="+nec.getId_necessidade()+">"+nec.getNecessidade()+"</option>");
                        }
                    %>    
                </select>
            </div>
            
            </br>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="../administrador.jsp" class="btn btn-default">Voltar</a>
        </form>

    </body>
</html>
