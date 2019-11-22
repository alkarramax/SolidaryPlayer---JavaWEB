<%@page import="model.Necessidade"%>
<%@page import="java.util.List"%>
<%@page import="DAO.JDBCNecessidadeDAO"%>
<%@page import="java.sql.*"%>
<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="sobreCampanhaEstilo.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Doação</title>
    <link rel="shortcut icon" type="image/x-icon" href="imagens/7618Logo.ico">
</head>
<body>
     <%
        Connection connection = DBConnection.getConnection();
        Statement st = connection.createStatement();
        String u = request.getParameter("c");
        int num = Integer.parseInt(u);
        
        String data = "select * from campanha where id_campanha='"+num+"'";
        ResultSet rs = st.executeQuery(data);
        while(rs.next()) {
    %>
    <nav>
        <svg  onclick="Nova()" id="i-chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="32" height="32" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
            <path d="M20 30 L8 16 20 2" />
        </svg>
        <img src="../imagensSobre/Logo.png" alt="">
    </nav>
    <div class="text-sobre">
        <h2><%=rs.getString("nome")%></h2>
        <p><%=rs.getString("descricao")%></p>
    </div>
    <div class="text-sobre-info"> 
        <div class="text-sobre-info-detalhe">
            <p>Local:</p>
            <p><%=rs.getString("local")%></p>
        </div>
        <div class="text-sobre-info-detalhe">
            <p>Data:</p>
            <p><%=rs.getString("data")%></p>
        </div>
    <%
    }
    %>
        <div class="text-sobre-info-detalhe">
            <p>Necessidade:</p>
   <%
       JDBCNecessidadeDAO necessidadeDAO = new JDBCNecessidadeDAO();
       List<Necessidade> necessidades = necessidadeDAO.getDescricao(num);
       
       for(Necessidade amanda : necessidades) {
           out.println("<p>"+amanda.getNecessidade()+",</p>");
       }
   %>
        </div>
    </div>
        
    <%
        HttpSession sessao = request.getSession();
        int id_softplayer = (Integer) sessao.getAttribute("id");
        
        String softInfo = "select * from softplayer where id_softplayer='"+id_softplayer+"'";
        ResultSet rsSoft = st.executeQuery(softInfo);
        while(rsSoft.next()) {
        
    %>
    <div id="contact" class="contact">
        <form action="../Doar?id_campanha=<%=num%>" method="POST">
                <div class="form-separator">
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/avatar.png" alt=""/>
                            <input  id="name" type="text" name="nome" value="<%=rsSoft.getString("nome")%>" placeholder="Nome"/> <!--placeholder="" dica do input-->
                        </div>
                    </div>
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/mail (3).png" alt=""/>
                            <input id="email" type="text" name="email" value="<%=rsSoft.getString("email")%>" placeholder="E-mail"/> 
                        </div>
                    </div>
                </div>
                <div class="form-separator">
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/suitcase.png" alt=""/>
                            <input  id="cargo" type="text" name="cargo" value="<%=rsSoft.getString("cargo")%>" placeholder="Cargo"/> <!--placeholder="" dica do input-->
                        </div>
                    </div>
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/office-block.png" alt=""/>
                            <input id="unidade" type="text" name="unidade" value="<%=rsSoft.getString("unidade")%>" placeholder="Unidade"/> 
                        </div>
                    </div>
                </div>
    <%
    }
    %>
    
    <%
        String necessidade = "select necessidade.descricao from necessidade inner join campanha on campanha.id_necessidade1 = necessidade.id_necessidade or campanha.id_necessidade2 = necessidade.id_necessidade where campanha.id_campanha = '"+num+"'";;
        ResultSet rsNes = st.executeQuery(necessidade);
        
        while(rsNes.next()) {
    %>
                <div class="form-separator">
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/plank.png" alt=""/>
                            <input id="quantidade" type="text" name="quantidadeDoada" placeholder="Quantidade"/> 
                        </div>
                    </div>
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/type.png" alt=""/>
                            <input id="tipo" type="text" name="necessidade" value="<%=rsNes.getString("descricao")%>"/> 
                        </div>
                    </div>
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/type.png" alt=""/>
                            <input id="tipo" type="text" name="necessidade" value="<%=rsNes.getString("descricao")%>"/> 
                        </div>
                    </div>
                </div>
                <div class="button-doar">
                    <button type="submit" class="btn btn-primary">Doar</button>
                </div>
            </form>
        </div>
    <%
        }
    %>
        <script>
            function Nova() {
                location.href="/SA-JSP/Home/home.jsp"
            }
        </script>
        <script src="sweetalert2.all.min.js"></script>
</body>
</html>
