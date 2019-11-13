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
                    Admin<span>Panel</span>
                </div>
                <ul id="menu">
                    <li><a id="home">Home</a></li>
                    <li><a id="doacoes">Doações</a></li>
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
                            Doações
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="./Funcoes/addDoacao.jsp" class="btn btn-primary">Adicionar Doação</a>
                            </div>
                        </div>
                        
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Local</th>
                                    <th>data</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                            
                            <%
                               Connection connDoac = DBConnection.getConnection();
                               Statement statDoac = connDoac.createStatement();
                               
                               String dataDoac = "select * from doacao";
                               ResultSet rsDoac = statDoac.executeQuery(dataDoac);

                               while(rsDoac.next()) {
                            %>
                             <tr>
                                <td><%=rsDoac.getString("id_doacao")%></td>
                                <td><%=rsDoac.getString("nome")%></td>
                                <td><%=rsDoac.getString("local")%></td>
                                <td><%=rsDoac.getString("data")%></td>
                                <td>
                                    <a href="./Funcoes/editarDoacao.jsp?u=<%=rsDoac.getString("id_doacao")%>" class="btn btn-warning">Editar</a>
                                    <a href='../deleteDoacao?d=<%=rsDoac.getString("id_doacao")%>' class="btn btn-danger">Delete</a>
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

