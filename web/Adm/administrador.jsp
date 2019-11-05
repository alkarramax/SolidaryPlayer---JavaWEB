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
                    <li><a id="entidade">Entidades</a></li>
                    <li><a id="campanha">Campanhas</a></li>
                    <li><a id="voluntariado">Voluntariado</a></li>
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
                    <div id="entidades-actions">
                        <div class="title">
                            Entidades
                        </div>
                        <div class="row">
                            <div id="botaoCadastrar" class="col-md-6">
                                <a href="./Funcoes/addEntidades.jsp" class="btn btn-primary">Adicionar Entidade</a>
                            </div>
                        </div>
                            
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Causa</th>
                                    <th>Endereço</th>
                                    <th>Email</th>
                                    <th>Telefone</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Connection connEntidade = DBConnection.getConnection();
                                    Statement statEntidade = connEntidade.createStatement();

                                    String dataEntidade = "select * from entidade";
                                    ResultSet rsEntin = statEntidade.executeQuery(dataEntidade);

                                    while(rsEntin.next()) {
                                %>  
                                <tr>
                                    <td><%=rsEntin.getString("id_entidade")%></td>
                                    <td><%=rsEntin.getString("nome")%></td>
                                    <td><%=rsEntin.getString("causa")%></td>
                                    <td><%=rsEntin.getString("endereco")%></td>
                                    <td><%=rsEntin.getString("email")%></td>
                                    <td><%=rsEntin.getString("telefone")%></td>
                                    <td>
                                    <a href="./Funcoes/editarEntidade.jsp?u=<%=rsEntin.getString("id_entidade")%>" class="btn btn-warning">Editar</a>
                                    <a href='../deleteEntidade?d=<%=rsEntin.getString("id_entidade")%>' class="btn btn-danger">Delete</a>
                                    </td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                        
                    </div>
                    <div id="campanhas-actions">
                        <div class="title">
                            Campanhas
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="./Funcoes/addCampanha.jsp" class="btn btn-primary">Adicionar Campanha</a>
                            </div>
                        </div>
                    </div>
                    <div id="voluntariado-actions">
                        <div class="title">
                            Voluntariado
                        </div>
                    </div>        
                    <div id="doacoes-actions">
                        <div class="title">
                            Doações
                        </div>
                        
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Local</th>
                                    <th>Aberta</th>
                                    <th>Funções</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    Connection connDoacao = DBConnection.getConnection();
                                    Statement statDoacao = connDoacao.createStatement();
                                    String dataDoacao = "select * from entidade";
                                    ResultSet rsDoacao = statDoacao.executeQuery(dataDoacao);

                                    while(rsDoacao.next()) {
                                %>  
                                <tr>
                                    <td><%=rsDoacao.getString("id_entidade")%></td>
                                    <td><%=rsDoacao.getString("nome")%></td>
                                    <td><%=rsDoacao.getString("endereco")%></td>
                                    <td><%=rsDoacao.getString("causa")%></td>
                                    <td>
                                    <a href="./Funcoes/criarDoacao.jsp?u=<%=rsDoacao.getInt("id_entidade")%>" class="btn btn-success">Criar Doação</a>
                                    </td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
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
                                    <a href='../deletePlayers?d=<%=rs.getString("id_softplayer")%>' class="btn btn-danger">Delete</a>
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

