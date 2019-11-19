<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css">
       
        <title>Admin</title>
        <style>
            #botaoCadastrar {
                margin-left: 865px;
            }
           
            h3 {
                align-items: center;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <nav id="leftnav">
                <div id="logo">
                    Admin<span>Painel</span>
                </div>
                <ul id="menu">
                    <li><a id="home">Home</a></li>
                    <li><a id="doacoes">Campanha</a></li>
                    <li><a id="necessidades">Necessidade</a></li>
                    <li><a id="player">Players</a></li>
                </ul>
                <div id="minimize" class="minimize">
                    &lt;
                </div>
            </nav>
            <header id="topnav">
                <div id="links">
                    <a id="exit">Sair</a>
                </div>
            </header>
            <main id="main">
                <div id="maximize" class="maximize">
                    &gt;
                </div>
                <div id="actions-container" class="actions-container">
                    <div id="home-actions">
                        <div class="title">
                            Home
                        </div>
                    </div>
                           
                    <div id="doacoes-actions">
                        <div class="title">
                            Campanhas
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="./Funcoes/cadastrarCampanha.jsp" class="btn btn-primary">Adicionar Campanha</a>
                            </div>
                        </div>
                       
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Local</th>
                                    <th>Data</th>
                                    <th>Qtd. Doada</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                           
                            <%
                               Connection connCamp = DBConnection.getConnection();
                               Statement statCamp= connCamp.createStatement();
                               
                               String dataCamp = "select * from campanha";
                               ResultSet rsCamp = statCamp.executeQuery(dataCamp);

                               while(rsCamp.next()) {
                            %>
                             <tr>
                                <td><%=rsCamp.getString("id_campanha")%></td>
                                <td><%=rsCamp.getString("nome")%></td>
                                <td><%=rsCamp.getString("local")%></td>
                                <td><%=rsCamp.getString("data")%></td>
                                <td><%=rsCamp.getInt("quantidade_doada")%></td>
                                <td>
                                    <a href="./Funcoes/editarCampanha.jsp?u=<%=rsCamp.getString("id_campanha")%>" class="btn btn-warning">Editar</a>
                                    <a href='../deleteCampanha?d=<%=rsCamp.getString("id_campanha")%>' class="btn btn-danger">Delete</a>
                                </td>

                             </tr>
                            <%
                             }
                            %>
                           
                        </table>
                    </div>
                    
                    <div id="necessidade-actions">
                        <div class="title">
                            Necessidades
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="./Funcoes/cadastrarNecessidade.jsp" class="btn btn-primary">Adicionar Necessidade</a>
                            </div>
                        </div>
                        
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Local</th>
                                    <th>Data</th>
                                    <th>Qtd. Doada</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                           
                            <%
                               
                               String dataNecessidade = "select * from necessidade";
                               ResultSet rsNecessidade = statCamp.executeQuery(dataNecessidade);

                               while(rsNecessidade.next()) {
                            %>
                             <tr>
                                <td><%=rsNecessidade.getString("id_necessidade")%></td>
                                <td><%=rsNecessidade.getString("descricao")%></td>
                                <td>
                                    <a href='../DeleteNecessidade?n=<%=rsNecessidade.getString("id_necessidade")%>' class="btn btn-danger">Delete</a>
                                </td>

                             </tr>
                            <%
                             }
                            %>
                           
                        </table>
                            
                    </div>        
                            
                    <div id="players-actions">
                        <div class="title">
                            Players
                        </div>
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>Cargo</th>
                                    <th>Unidade</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                           
                            <%
                               Connection conn = DBConnection.getConnection();
                               Statement stat = conn.createStatement();
                               
                               String data = "select * from softplayer";
                               ResultSet rs = stat.executeQuery(data);

                               while(rs.next()) {
                            %>
                             <tr>
                                <td><%=rs.getString("id_softplayer")%></td>
                                <td><%=rs.getString("nome")%></td>
                                <td><%=rs.getString("email")%></td>
                                <td><%=rs.getString("cargo")%></td>
                                <td><%=rs.getString("unidade")%></td>
                                <td>
                                    <a href='../DeletePlayers?d=<%=rs.getString("id_softplayer")%>' class="btn btn-danger">Delete</a>
                                </td>

                             </tr>
                            <%
                             }
                            %>
                           
                        </table>
                    </div>
                </div>
            </main>
        </div>
        <script src="admin.js"></script>
    </body>
</html>