    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="sobreCampanha.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Campanha</title>
    <link rel="shortcut icon" type="image/x-icon" href="imagens/7618Logo.ico">
    
    <script>
    function Nova() {
        location.href="../Home/home.html"
    }
    </script>
</head>
<body>
    <nav>
        <svg  onclick="Nova()" id="i-chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="32" height="32" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
            <path d="M20 30 L8 16 20 2" />
        </svg>
        <img src="../imagensSobre/Logo.png" alt="">
        <button type="button" class="btn btn-primary">Venha fazer parte dessa comunidade.</button>
    </nav>
    <div class="text-sobre">
        <h2>Lorem ipsum</h2>
        <p>	Lorem ipsum integer pharetra duis inceptos orci convallis integer, quisque platea cubilia praesent euismod 
            ligula tortor, lacus sit pellentesque lorem conubia hendrerit est. curae nibh fusce class taciti pulvinar varius
            malesuada torquent augue, vitae leo euismod nec sociosqu vulputate cursus aliquam pulvinar, est sed lorem id 
            adipiscing magna scelerisque nunc. primis praesent potenti mi laoreet orci gravida ultrices orci tincidunt 
            etiam, quam ac porttitor at fames mi suspendisse diam maecenas, dapibus integer taciti condimentum vestibulum 
            placerat in nisi blandit. libero praesent curae sed at orci elementum, ut gravida maecenas justo quisque faucibus 
            ac, dapibus ultricies ipsum volutpat aliquam. </p>
    </div>
    <div class="text-sobre-info"> 
        <div class="text-sobre-info-detalhe">
            <p>Local onde poderá levar a doação:</p>
            <p>Softplan recepção</p>
        </div>
        <div class="text-sobre-info-detalhe">
            <p>Data início:</p>
            <p>30/10/2019</p>
        </div>
        <div class="text-sobre-info-detalhe">
            <p>Data de término</p>
            <p>12/12/2019</p>
        </div>
    </div>
    <div id="contact" class="contact">
            <form>
                <div class="form-separator">
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/avatar.png" alt=""/>
                            <input id="name" type="text" placeholder="Nome"/> <!--placeholder="" dica do input-->
                        </div>
                    </div>
                    <div class="input">
                        <div class="caixa-input">
                            <img src="../imagensSobre/mail (3).png" alt=""/>
                            <input id="email" type="text" placeholder="E-mail"/> 
                        </div>
                    </div>
                </div>
                <div class="form-separator">
                    <div class="input2">
                        <div class="caixa-input2">
                            <img src="../imagensSobre/wallet (1).png" alt=""/>
                            <input id="cpf" type="text" placeholder="CPF"/> 
                        </div>
                    </div>
                    <div class="input2">
                        <div class="caixa-input2">
                            <img src="../imagensSobre/suitcase.png" alt=""/>
                            <input id="cargo" type="text" placeholder="Cargo"/> 
                        </div>
                    </div>
                    <div class="input2">
                        <div class="caixa-input2">
                            <img src="../imagensSobre/office-block.png" alt=""/>
                            <input id="unidade" type="text" placeholder="Unidade"/> 
                        </div>
                    </div>
                </div>
            </form>
            <div class="button-doar">
                    <button type="button" class="btn btn-primary">Participar</button>
            </div>
        </div>
</body>
</html>
