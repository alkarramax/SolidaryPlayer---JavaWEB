<%@page import="model.Campanha"%>
<%@page import="DAO.JDBCCampanhaDAO"%>
<%@page import="java.util.List"%>
<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <link rel="shortcut icon" type="image/x-icon" href="imagens/7618Logo.ico">
    <link rel="stylesheet" type="text/css" href="/SA-JSP/Home/home.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript">
 $(window).on("scroll", function(){
            if($(window).scrollTop()){
                $('nav').addClass('navFixed');
            }else{
                $("nav").removeClass("navFixed");
            }
        })
        $(document).ready(function(){
            $("#bar").click(function(){
                $(".navbar").toggleClass("active");
            })
        })
        $(function() {
        $( "[data-product-info-link]" ).click(function(e) {
            e.preventDefault();
            var theLink = $(this);
            var tabNum = $(this).data('product-info-link');
            var tabItem = '[data-product-info-tab="' + tabNum +'"]';
            var check = $(tabItem).is(':visible');
            if ( !check ) {
                var other = $('[data-product-info-link]').not(this).removeClass('active');
                var fadeOutDone = $('[data-product-info-tab]').css('display','none');
                $(tabItem).css('display','block');
                $(theLink).addClass('active');
            }
        });
    });
        jQuery(document).ready(function($){
            $(".ancora-scroll").click(function(event){
                event.preventDefault();
                $("html,body").animate({scrollTop:$(this.hash).offset().top},1000)
            });
        });
        $(document).ready(function(){
            $('#children').slick({
            infinite: false,
            speed: 300,
            slidesToShow: 3,
            slidesToScroll: 3,
            nextArrow: $('.right'),    
            prevArrow: $('.left'),
            responsive: [
            {
                breakpoint: 1024,
                settings: {
                slidesToShow: 2,
                slidesToScroll: 2,
                infinite: true,
                }
            },
            {
                breakpoint: 880,
                settings: {
                slidesToShow: 1,
                slidesToScroll: 1
                }
            }
            ]
        });
        });
        $(document).ready(function(){
            $('#seniors').slick({
            infinite: false,
            speed: 300,
            slidesToShow: 3,
            slidesToScroll: 3,
            nextArrow: $('.right2'),    
            prevArrow: $('.left2'),
            responsive: [
            {
                breakpoint: 1024,
                settings: {
                slidesToShow: 2,
                slidesToScroll: 2,
                infinite: true,
                }
            },
            {
                breakpoint: 880,
                settings: {
                slidesToShow: 1,
                slidesToScroll: 1
                }
            }
            ]
        });
    });
    </script>
</head>
<body>
<div class="popup">
        <div class="popup-content">
            <div class="container" id="container">
                <div class="form-container sign-up-container">
                    <img src="/SA-JSP/Home/imagens/./baseline_clear_black_18dp.png" alt="Close" class="close2">
                    <form action="../CadastroSoftplayer">
                        <h1>Crie Sua Conta</h1>
                        <input type="text" name="nome" placeholder="Nome completo" required name=nome>
                        <input type="password" name="senha" placeholder="Senha"  required name=nome>
                        <input type="email" name="email" placeholder="Email"  required name=nome>
                        <input type="text" name="cargo" placeholder="Cargo"  required name=nome>
                        <input type="text" name="unidade" placeholder="Unidade"  required name=nome>
                        <button>Cadastrar</button>
                    </form>
                </div>
                <div class="form-container sign-in-container">
                    <form action="../Login">
                        <h1>Entrar</h1>
                        <input type="email" name="email" id="email" placeholder="Email" required name=email>
                        <input type="password" name="senha" id="senha" placeholder="Senha"required name=senha>
                        <a href="./EsquecerSenha/esquecerSenhaEmail.jsp">Esqueceu sua senha?</a>
                        <button>Entrar</button>
                    </form>
                </div>
                <div class="overlay-container">
                    <div class="overlay">
                        <div class="overlay-panel overlay-left">
                            <h1>Que bom que você voltou!</h1>
                            <p>Faça o seu login e continue ajudando quem precisa.</p>
                            <button class="ghost" id="signIn">Entrar</button>
                        </div>
                        <div class="overlay-panel overlay-right">
                            <img src="imagens/./baseline_clear_black_18dp.png" alt="Close" class="close">
                            <h1>Olá, Softplayer!</h1>
                            <p>Ainda não tem cadastro? Cadastre-se para se tornar um Solidarity Player.</p>
                            <button class="ghost" id="signUp">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <header class="header">
        <nav class="navbar">
            <div class="responsive">
                <div class="logo">
                    <img src="/SA-JSP/Home/imagens/Logo.png"/>
                    <h1>Solidarity Player</h1>
                </div>
                <i id="bar" class="fa fa-bars" aria-hidden="true"></i>
            </div>
            <div class="normal">
                <div class="logo">
                    <img src="/SA-JSP/Home/imagens/Logo.png"/>
                    <h1>Solidarity Player</h1>
                </div>
                <div class="menu">
                    <%String nomeUsuario = (String) session.getAttribute("nome"); %>
                    <ul>
                        <li><a class="ancora-scroll" href="#campaigns">Causas</a></li>
                        <li><a class="ancora-scroll" href="#about">Sobre</a></li>
                        <li><a class="ancora-scroll" href="#how-it-works">Como funciona?</a></li>
                        
                        <% if(nomeUsuario == null) { %>
                        <li> <a class="nav-link" href="#" id="popUpAparecer">Entrar | Cadastrar</a>
                        <%} else {%>
                        <li><a class="nav-link" href="#" id="deslogar"><%=nomeUsuario%></a>
                            <ul class="deslogar">
                                <li><a href="../deslogar">Sair</a></li>
                            </ul>
                        </li>
                        <%}%>
                    </ul>
                   
                </div>
            </div>
        </nav>
          <div class="text">
            <h1>Olá, aqui você </br> 
                 <span class="txt-type" data-wait="3000" data-words='["gera impacto.", "tem transparência.", "ajuda quem precisa."]'></span>
            </h1>
            <h3> Quem você quer ajudar hoje?</h3>
            <h2> Faça a diferença na vida das pessoas, </br><a id="link-text" class="ancora-scroll" href="#campaigns">role</a> para baixo e descubra quem precisa</br> de você!</h2>
            <h2> O solidarity player te conecta com causas</br> e pessoas.</h2>
          </div>
    </header>
        <section class="campaigns" id="campaigns">
        <div class="children height-session">
        <h2>Invista no futuro de crianças e adolescentes</h2>
            <div id="right" class="right">
                <i class="fa fa-angle-right"></i>
            </div>    
            <div id="left" class="left"> 
                <i class="fa fa-angle-left"></i>
            </div>
            <div class="card-wrapper" id="children">
                <%
                    JDBCCampanhaDAO campanhaDAO = new JDBCCampanhaDAO();
                    List<Campanha> listCrianca = campanhaDAO.listarCrianca();
                    for(Campanha y : listCrianca) {
                        out.println("<div class='card'>");
                            out.println("<img src='/SA-JSP/Home/imageCampanha/"+y.getImagem()+"' alt='card backgroud' class='card-img'>");
                            out.println("<img src='/SA-JSP/Home/imagens/logo-branco-300x287.png' alt='profile backgroud' class='profile-img'>");
                            out.println("<h1>"+y.getNome()+"</h1>");
                            out.println("<p>"+y.getDescricao()+"</p>");
                            out.println("<a href='../ControlarDoacao?c="+y.getId_campanha()+"' class='btn-doar'>Contribua agora</a>");
                        out.println("</div>");
                    }
                %>
            </div>
        </div>
        <div class="seniors height-session">
        <h2 class="h2card">Apoie os idosos e preserve a nossa história</h2>
         <div id="right" class="right2">
                <i class="fa fa-angle-right"></i>
            </div>    
            <div id="left" class="left2"> 
                <i class="fa fa-angle-left"></i>
            </div>
        <div class="card-wrapper" id="seniors">
                 <%
                    JDBCCampanhaDAO campanhaDAO2 = new JDBCCampanhaDAO();
                    List<Campanha> listIdoso = campanhaDAO2.listarIdosos();
                    for(Campanha g : listIdoso) {
                        out.println("<div class='card'>");
                            out.println("<img src='/SA-JSP/Home/imageCampanha/"+g.getImagem()+"' alt='card backgroud' class='card-img'>");
                            out.println("<img src='/SA-JSP/Home/imagens/logo-branco-300x287.png' alt='profile backgroud' class='profile-img'>");
                            out.println("<h1>"+g.getNome()+"</h1>");
                            out.println("<p>"+g.getDescricao()+"</p>");
                            out.println("<a href='../ControlarDoacao?c="+g.getId_campanha()+"' class='btn-doar'>Contribua agora</a>");
                        out.println("</div>");
                    }
                %>
            </div>
        </div>
    </section>
        <div class="separator-card-and-about">
            <h1>Como você quer o mundo?</h1>
            <h2>A mudança começa a partir de você!</h2>
        </div>
    <section class="about" id="about">
        <h1> Como a Softplan e o grupo Solidário </br> ajudaram centenas de pessoas?</h1>
        <div class="container-first">
            <div class="text-and-img">
                <img src="imagens/campanha_do-_agasalho_03-768x768.jpg" alt="">
                <h4>Grupo Solidário</h4>
                <p>O Grupo Solidário nasceu por iniciativa de colaboradores voluntários da Softplan, 
                    que se unem para promover ações de assistência social, organizando campanhas beneficentes. 
                    A Softplan é uma das parceiras, e apoia financeiramente as campanhas, enquanto os colaboradores
                     voluntários se reúnem e doam um pouco do seu tempo livre. </p>
            </div>
            <div class="topics">
                <h2>Campanha do agasalho </br> solidário</h2>
                <div class="info">
                    <div class="text">
                        <h4>Comunidade Frei Damião</h4>
                    </div>
                </div>
                <div class="info">
                        <div class="text">
                            <h4>Comunidade Brejarú</h4>
                        </div>
                    </div>
                <div class="info">
                    <div class="text">
                        <h4>152 kits de higiene pessoal</h4>
                    </div>
                </div>
                <div class="info">
                    <div class="text">
                        <h4>1223 peças</h4>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-last">
            <img src="/SA-JSP/Home/imagens/img-pacto-onu.jpg" alt="">
            <div class="text">
                <div class="title"><h2>Pacto Global da ONU</h2></div>
                <p>Desde 2017 a Softplan é signátaria do Pacto Global da ONU. O Pacto Global é uma iniciativa que 
                    visa mobilizar a comunidade empresarial internacional para a adoção, em suas práticas de negócios,
                    de valores fundamentais e internacionalmente aceitos nas áreas de direitos humanos, relações de
                    trabalho, meio ambiente e combate à corrupção refletidos em 10 princípios.</p>
            </div>
        </div>
    </section>
        <div class="separator-about-and-how-it-works">
            <h1>Vá além do trabalho, mude a vida das pessoas.</h1>
        </div>
        <section class="how-it-works" id="how-it-works">
        <h1>Como funciona?</h1>
        <div class="container-first">
            <div class="text-and-img">
                <img src="/SA-JSP/Home/imagens/Design sem nome (6).png" alt="">
                <p>Com o solidarity player ajudar uma causa fica ainda mais simples!
                     1° Você se cadastra no site, escolhe uma campanha e doa!</p>
            </div>
            <div class="text-and-img">
                <img src="/SA-JSP/Home/imagens/Design sem nome (7).png" alt="">
                <p>2° Você leva a sua doação até o local solicitado. Isso tudo dentro da sua empresa!</p>
            </div>
        </div>
        <div class="container-last">
            <div class="text-and-img">
                <img src="/SA-JSP/Home/imagens/Design sem nome (8).png" alt="">
                <p>3° O grupo solidário leva as doações </br> arrecadadas até as comunidades/entidades.</br> 
                    Você faz o bem se ver a quem!</p>
            </div>
        </div>
    </section>
    <footer>
        <div class="footer-info">
            <div class="footer-info-img">
                <div class="footer-img"> 
                   <a href="https://www.linkedin.com/in/amanda-farias-sena-506bb817b/" target="_blank"><img src="/SA-JSP/Home/imagens/linkedin.png" alt=""></a> 
                    <h3>Amanda Farias Sena</h3>
                </div>
                <div class="footer-img"> 
                    <a href="https://www.linkedin.com/in/alkarramax-junior-6a560b162/" target="_blank"><img src="/SA-JSP/Home/imagens/linkedin.png" alt=""></a> 
                    <h3>Alkarramax Junior</h3>
                </div>
                <div class="footer-img"> 
                    <a href="https://www.linkedin.com/in/leonardo-rangel-230821162/" target="_blank"><img src="/SA-JSP/Home/imagens/linkedin.png" alt=""></a> 
                    <h3>Leonardo Rangel</h3>
                </div>
            </div>
            <div class="footer-info-text">
                <p>Fortalecendo a cultura de doações através da tecnologia, desde 2019.</p>
            </div>
            <div class="logo-empresas">
                <img src="/SA-JSP/Home/imagens/logo_softplan (1).png" alt="">
                <img src="/SA-JSP/Home/imagens/senai-logo-1 (1).png" alt="">
            </div>
        </div>
    </footer>

    <script src="./javascript/home.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script src="https://kit.fontawesome.com/27aa4e62af.js" crossorigin="anonymous"></script>
</body>
</html>
