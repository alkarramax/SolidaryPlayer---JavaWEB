<%@page import="DB.DBConnection"%>
<%@page import="model.Doacao"%>
<%@page import="java.util.List"%>
<%@page import="DAO.JDBCDoacaoDAO"%>
<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Participantes</title>
        <link rel="shortcut icon" type="image/x-icon" href="../../Home/imagens/7618Logo.ico">
        <link rel="stylesheet" type="text/css" href="participantes.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
         <nav>
            <svg  onclick="Nova()" id="i-chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="32" height="32" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
                <path d="M20 30 L8 16 20 2" />
            </svg>
            <img src="../imagens/Logo.png" alt="">
        </nav>
        <div class="table-responsive">
            <table class="table" style="width: 80%" >
                <thead>
                  <tr>
                    <th scope="col">Doador</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Unidade</th>
                    <th scope="col">Quantidade</th>
                  </tr>
                </thead>
            <%
                String id = request.getParameter("campanha");
                int id_campanha = Integer.parseInt(id);

                Connection connection = DBConnection.getConnection();

                String SQL = "SELECT doacao.campanha_id, doacao.quantidade_doada, softplayer.nome, softplayer.email, softplayer.unidade \n" +
                            "FROM doacao \n" +
                            "INNER JOIN campanha \n" +
                            "ON campanha.id_campanha = doacao.campanha_id\n" +
                            "INNER JOIN softplayer\n" +
                            "ON softplayer.id_softplayer = doacao.softplayer_id WHERE campanha.id_campanha ='"+id_campanha+"'";
                PreparedStatement ps = connection.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {

            %>
                <tbody>
                  <tr>
                    <td><%= rs.getString("softplayer.nome") %></td>
                    <td><%= rs.getString("softplayer.email")%></td>
                    <td><%= rs.getString("softplayer.unidade")%></td>
                    <td><%= rs.getInt("doacao.quantidade_doada")%></td>
                  </tr>
                </tbody>
            <%
             }
            %>
            </table>
        </div>
    <script>
        function Nova() {
            location.href="/SA-JSP/SobreCampanha/sobreCampanha.jsp?id_campanha=<%=id_campanha%>";
        }
    </script>
    </body>
</html>
