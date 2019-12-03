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
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Participantes</title>
    </head>
    <body>
        <table class="table">
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
        
    </body>
</html>
