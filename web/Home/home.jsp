<%@page import="DB.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <link rel="shortcut icon" type="image/x-icon" href="imagens/7618Logo.ico">
    <link rel="stylesheet" href="imagens/Logo.png" type="img">
    <link rel="stylesheet" type="text/css" href="./style1.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(window).on("scroll", function(){
            if($(window).scrollTop()){
                $("nav").addClass("navFixed");
            }else{
                $("nav").removeClass("navFixed");
            }
        });
        $(document).ready(function(){
            $("#bar").click(function(){
                $(".navbar").toggleClass("active");
            });
        });
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
                $("html,body").animate({scrollTop:$(this.hash).offset().top},800);
            });
        });
    </script>
</head>
<body>
    <div class="popup">
        <div class="popup-content">
            <div class="container" id="container">
                <div class="form-container sign-up-container">
                    <img src="imagens/./baseline_clear_black_18dp.png" alt="Close" class="close2">
                    <form action="../cadastro">
                        <h1>Crie Sua Conta</h1>
                        <input type="text" name="nome" placeholder="Nome">
                        <input type="text" name="sobrenome" placeholder="Sobrenome">
                        <input type="password" name="senha" placeholder="Senha">
                        <input type="email" name="email" placeholder="Email">
                        <input type="text" name="cargo" placeholder="Cargo">
                        <input type="text" name="unidade" placeholder="Unidade">
                        <button>Cadastrar</button>
                    </form>
                </div>
                <div class="form-container sign-in-container">
                    <form action="../login">
                        <h1>Entrar</h1>
                        <input type="email" id="email" name="emailLogar" placeholder="Email">
                        <input type="password" id="senha" name="senhaLogar" placeholder="Senha">
                        <a href="#">Esqueceu sua senha?</a>
                        <button>Entrar</button>
                    </form>
                </div>
                <div class="overlay-container">
                    <div class="overlay">
                        <div class="overlay-panel overlay-left">
                            <h1>Welcome Back!</h1>
                            <p>To keep connected with us please login with your personal info</p>
                            <button class="ghost" id="signIn">Entrar</button>
                        </div>
                        <div class="overlay-panel overlay-right">
                            <img src="imagens/./baseline_clear_black_18dp.png" alt="Close" class="close">
                            <h1>Olá, Softplayer!</h1>
                            <p>Ainda não tem cadastro? Cadastre-se para se tornar um Solidarity Player</p>
                            <button class="ghost" id="signUp">Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div id="singOut">
        <span class="ion-checkmark-round"></span>
        <a></a>
        
        <a class="closeSignOut">Fechar</a>
    </div>
    
    <header class="header">
        <nav class="navbar-one">
            <div class="responsive-bar">
            <div class="responsive-logo">
                <img src="imagens/Logo.png"/>
                <h1>Solidarity Player</h1>
            </div>
            <i id="bar" class="fa fa-bars" aria-hidden="true"></i>
            </div>
            <div class="navbar">
                <div class="logo">
                    <img src="imagens/Logo.png"/>
                    <h1>Solidarity Player</h1>
                </div>
                <div class="menu">
                    <%
                        String nomeUsuario = (String) session.getAttribute("nome");
                        
                    %>
                    
                    <ul>
                        <li><a class="ancora-scroll" href="#causas">Causas</a></li>
                        <li><a class="ancora-scroll" href="#sobre">Sobre</a></li>
                        <li><a class="ancora-scroll" href="#como-funciona">Como funciona?</a></li>
                        
                        <% if(nomeUsuario == null) { %>
                        <li><a class="nav-link" href="#" id="popUpAparecer" value="">Login</a></li>
                        <%} else {%>
                        <li><a class="nav-link" href="#" id="signOut" value=""><%=nomeUsuario%></a></li>
                        <%}%>
                        
                    </ul>
                   
                </div>
            </div>
        </nav>
          <div class="leftside">
            <h1>Olá, aqui você </br> 
                 <span class="txt-type" data-wait="3000" data-words='["gera impacto.", "tem transparência.", "ajuda quem precisa."]'></span>
            </h1>
            <h3> Quem você quer ajudar hoje?</h3>
            <h2> Faça a diferença na vida das pessoas, </br>role para baixo e descubra quem precisa</br> de você!</h2>
            <h2> O solidarity player te conecta com causas</br> e pessoas.</h2>
          </div>
    </header>
    <section>
        <div id="causas" class="causa1">
            <h2>Apoio para pacientes com câncer</h2>
            <div class="tab-wrapper">
                <ul>
                  <li><a href="#" class="active" data-product-info-link="1">Doações</a></li>
                  <li><a href="#" data-product-info-link="2">Campanhas</a></li>
                  <li><a href="#" data-product-info-link="3">Voluntariado</a></li>
                </ul>
                <div class="product-info-tab" data-product-info-tab="1" style="display: block;">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="../SobreDoacao/sobreDoacao.jsp" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="../SobreDoacao/sobreDoacao.jsp" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="../SobreDoacao/sobreDoacao.jsp" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
                <div class="product-info-tab" data-product-info-tab="2">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
                <div class="product-info-tab" data-product-info-tab="3">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="causa">
            <h2 class="h2card">Apoio para pacientes com câncer</h2>
            <div class="tab-wrapper">
                <ul>
                    <li><a href="#" class="active" data-product-info-link="1">Doações</a></li>
                    <li><a href="#" data-product-info-link="2">Campanhas</a></li>
                    <li><a href="#" data-product-info-link="3">Voluntariado</a></li>
                </ul>
                    <div class="product-info-tab" data-product-info-tab="1" style="display: block;">
                        <div class="card-wrapper">
                            <div class="card">
                                <img src="imagens/back.jpg" alt="card background" class="card-img">
                                <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                                <h1>Solidarity Player</h1>
                                <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                    que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                                </p>
                                <a href="#" class="btn-doar">Contribua agora</a>
                            </div>
                            <div class="card">
                                <img src="imagens/back.jpg" alt="card background" class="card-img">
                                <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                                <h1>Solidarity Player</h1>
                                <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                    que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                                </p>
                                <a href="#" class="btn-doar">Contribua agora</a>
                            </div>
                            <div class="card">
                                <img src="imagens/back.jpg" alt="card background" class="card-img">
                                <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                                <h1>Solidarity Player</h1>
                                <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                    que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                                </p>
                                <a href="#" class="btn-doar">Contribua agora</a>
                            </div>
                        </div>
                    </div>
                    <div class="product-info-tab" data-product-info-tab="2">
                        <div class="card-wrapper">
                            <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
                <div class="product-info-tab" data-product-info-tab="3">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                            que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="causa">
        <h2 class="h2card">Apoio para pacientes com câncer</h2>
            <div class="tab-wrapper">
                <ul>
                    <li><a href="#" class="active" data-product-info-link="1">Doações</a></li>
                    <li><a href="#" data-product-info-link="2">Campanhas</a></li>
                    <li><a href="#" data-product-info-link="3">Voluntariado</a></li>
                </ul>
                <div class="product-info-tab" data-product-info-tab="1" style="display: block;">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
                <div class="product-info-tab" data-product-info-tab="2">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
                <div class="product-info-tab" data-product-info-tab="3">
                    <div class="card-wrapper">
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                        <div class="card">
                            <img src="imagens/back.jpg" alt="card background" class="card-img">
                            <img src="imagens/logo-branco-300x287.png" alt="profile image" class="profile-img">
                            <h1>Solidarity Player</h1>
                            <p>A ABRALE – Associação Brasileira de Linfoma e Leucemia é uma das mais conceituadas e importantes associações 
                                que trabalha em todo o país para democratizar o tratamento e qualidade de vida de pessoas com doenças hematológicas.
                            </p>
                            <a href="#" class="btn-doar">Contribua agora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </section>
    <section>
        <section id="sobre">
            <div class="img-impacto">
                <h1>Como você quer o mundo?</h1>
                <h2>A mudança começa a partir de você!</h2>
            </div>
        </section>
    </section>
    <section  class="sobre">
        <h1> Como o grupo Solidario ajudou </br> milhares de pessoas?</h1>
        <div class="container-sobre">
            <div class="container-sobre-img">
                <img src="imagens/campanha_do-_agasalho_03-768x768.jpg" alt="">
                <h4>Grupo Solidario</h4>
                <p>O Grupo Solidário nasceu por iniciativa de colaboradores voluntários da Softplan, 
                    que se unem para promover ações de assistência social, organizando campanhas beneficentes. 
                    A Softplan é uma das parceiras, e apoia financeiramente as campanhas, enquanto os colaboradores
                     voluntários se reúnem e doam um pouco do seu tempo livre. </p>
            </div>
            <div class="container-sobre-info">
                <h2>Campanha do agasalho </br> solidário</h2>
                <div class="sobre-info">
                    <div class="info">
                        <h4>Comunidade Frei Damião</h4>
                    </div>
                </div>
                <div class="sobre-info">
                        <div class="info">
                            <h4>Comunidade Brejarú</h4>
                        </div>
                    </div>
                <div class="sobre-info">
                    <div class="info">
                        <h4>152 kits de higiene pessoal</h4>
                    </div>
                </div>
                <div class="sobre-info">
                    <div class="info">
                        <h4>1223 peças</h4>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="como-funciona" class="como-funciona">
        <h1>Como funciona?</h1>
        <div class="container">
            <div class="container-sobre">
                <img src="imagens/Design sem nome (6).png" alt="">
                <p>Dapibus nam elit condimentum sollicitudin inceptos accumsan odio in mattis elit, 
                    venenatis litora pulvinar sed sit fusce elit sagittis vestibulum.</p>
            </div>
            <div class="container-sobre">
                    <img src="imagens/Design sem nome (7).png" alt="">
                    <p>Dapibus nam elit condimentum sollicitudin inceptos accumsan odio in mattis elit, 
                        venenatis litora pulvinar sed sit fusce elit sagittis vestibulum.</p>
            </div>
        </div>
        <div class="container-function2">
            <div class="container-sobre2">
                <img src="imagens/Design sem nome (8).png" alt="">
                <p>Dapibus nam elit condimentum sollicitudin </br> inceptos accumsan odio in mattis elit,
                    venenatis </br> litora pulvinar sed sit fusce elit sagittis vestibulum.</p>
            </div>
        </div>
    </section>
    <footer>
        
    </footer>
    <script src="home.js"></script>
</body>
</html>