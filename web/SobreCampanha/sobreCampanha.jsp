<%@page import="model.Campanha"%>
<%@page import="DAO.JDBCCampanhaDAO"%>
<%@page import="model.Softplayer"%>
<%@page import="DAO.JDBCSoftplayerDAO"%>
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
    <nav>
        <svg  onclick="Nova()" id="i-chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="32" height="32" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
            <path d="M20 30 L8 16 20 2" />
        </svg>
        <img src="../imagensSobre/Logo.png" alt="">
    </nav>
     <%
        String u = request.getParameter("id_campanha");
        int id_campanha = Integer.parseInt(u);
        
        JDBCCampanhaDAO campanhaDAO = new JDBCCampanhaDAO();
        List<Campanha> campanhas = campanhaDAO.buscarCampanha(id_campanha);
        
        for(Campanha campanha : campanhas) {
            out.println("<div class='text-sobre'>");
                out.println("<h2>"+campanha.getNome()+"</h2>");
                out.println("<p>"+campanha.getDescricao()+"</p>");
            out.println("</div>");
            
            out.println("<div class='text-sobre-info'>");
                out.println("<div class='text-sobre-info-detalhe'>");
                    out.println("<p>Local:</p>");
                    out.println("<p>"+campanha.getLocal()+"</p>");
                out.println("</div>");
                out.println("<div class='text-sobre-info-detalhe'>");
                    out.println("<p>Data:</p>");
                    out.println("<p>"+campanha.getData()+"</p>");
                out.println("</div>");
        }   
    %>
        <div class="text-sobre-info-detalhe">
            <p>Necessidade:</p>
    <%
        JDBCNecessidadeDAO necessidadeDAO = new JDBCNecessidadeDAO();
        List<Necessidade> necessidades = necessidadeDAO.getDescricao(id_campanha);

        for(Necessidade amanda : necessidades) {
            out.println("<p>"+amanda.getNecessidade()+"</p>");
        }
    %>
        </div>
    </div>
        
    <div id="contact" class="contact">
        <form action="../Doar?id_campanha=<%=id_campanha%>" method="POST">
    <%
        HttpSession sessao = request.getSession();
        int id_softplayer = (Integer) sessao.getAttribute("id");
        
        JDBCSoftplayerDAO softplayerDAO = new JDBCSoftplayerDAO();
        List<Softplayer> softplayers = softplayerDAO.buscarSoftplayer(id_softplayer);
        
        for(Softplayer softplayer : softplayers) {
            out.println("<div class='form-separator'>");
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/avatar.png' alt=''>");
                        out.println("<input id='name' type='text' name='nome' value="+softplayer.getNome()+" placeholder='Nome'>");
                    out.println("</div>");
                out.println("</div>");
                
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/avatar.png' alt=''>");
                        out.println("<input id='email' type='text' name='email' value="+softplayer.getEmail()+" placeholder='Email'>");
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
            
            
            out.println("<div class='form-separator'>");
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/avatar.png' alt=''>");
                        out.println("<input id='cargo' type='text' name='cargo' value="+softplayer.getCargo()+" placeholder='Cargo'>");
                    out.println("</div>");
                out.println("</div>");
                
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/avatar.png' alt=''>");
                        out.println("<input id='unidade' type='text' name='unidade' value="+softplayer.getUnidade()+" placeholder='Unidade'>");
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
        }
        
    %>
             
    <%
        
        for(Necessidade necessidade : necessidades) {
            out.println("<div class='form-separator'>");
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/type.png' alt=''/>");
                        out.println("<input id='quantidade' type='text' name='quantidadeDoada' placeholder='Quantidade. Ex.:"+necessidade.getUnidade()+"'>");
                    out.println("</div>");
                out.println("</div>");
                
                out.println("<input type='hidden' name='necessidade_id' value="+ necessidade.getId_necessidade() +" >");
                
                out.println("<div class='input'>");
                    out.println("<div class='caixa-input'>");
                        out.println("<img src='../imagensSobre/type.png' alt=''/>");
                        out.println("<input id='tipo' value="+necessidade.getNecessidade()+">");
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
            
        }
       
    %>
   
                <div class="button-doar">
                    <button type="submit" class="btn btn-primary">Doar</button>
                </div>
            </form>
        </div>
        <script>
            function Nova() {
                location.href="/SA-JSP/Home/home.jsp"
            }
        </script>
        <script src="sweetalert2.all.min.js"></script>
</body>
</html>
