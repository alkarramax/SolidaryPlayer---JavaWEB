window.onload = function () {
    var minimize_btn = document.getElementById("minimize"),
    maximize_btn = document.getElementById("maximize"),
    leftnav      = document.getElementById("leftnav"),
    topnav       = document.getElementById("topnav"),
    main         = document.getElementById("main");
    
    minimize_btn.addEventListener('click', minimize, false);
    maximize_btn.addEventListener('click', maximize, false);


    function minimize() {

        maximize_btn.style.transform = 'scale(1)';
        leftnav.style.left           = '-200px';
        topnav.style.left            = '0px';
        topnav.style.width           = '100%';
        main.style.left              = '0px';
        main.style.width             = '100%';
        

    }

    function maximize() {

        maximize_btn.style.transform = 'scale(0)';
        leftnav.style.left      = '0px';
        topnav.style.left       = '200px';
        topnav.style.width      = 'calc(100% - 200px)';
        main.style.left         = '200px';
        main.style.width        = 'calc(100% - 200px)';

    }

    var home_act = document.getElementById('home-actions'),
        entidade_act = document.getElementById('entidades-actions'),
        campanhas_act = document.getElementById('campanhas-actions'),
        voluntariado_act = document.getElementById('voluntariado-actions'),
        doacoes_act = document.getElementById('doacoes-actions'),
        players_act = document.getElementById('players-actions');

    var actions = [home_act, entidade_act, campanhas_act, voluntariado_act, doacoes_act, players_act];

    function show(index) {
        for(var i = 0; i < actions.length; i++) {

            if(i !== index ) {
                actions[i].style.display = 'none';
            }else {
                actions[i].style.display = 'block';
            }
        }
    }

    show(0);

    var home = document.getElementById('home'),
        entidade = document.getElementById('entidade'),
        campanhas = document.getElementById('campanha'),
        voluntariado = document.getElementById('voluntariado'),
        doacoes  = document.getElementById('doacoes'),
        players  = document.getElementById('player');
    
    var buttons = [home, entidade, campanhas, voluntariado, doacoes, players];

    buttons[0].addEventListener('click', function() {
        show(0);
    }, false);
    buttons[1].addEventListener('click', function() {
        show(1);
    }, false);
    buttons[2].addEventListener('click', function() {
        show(2);
    }, false);
    buttons[3].addEventListener('click', function() {
        show(3);
    }, false);
    buttons[4].addEventListener('click', function() {
        show(4);
    }, false);
    buttons[5].addEventListener('click', function() {
        show(5);
    }, false);

    var exit = document.getElementById("exit");
    exit.addEventListener('click', function() {
       location.assign("../Home/home.jsp");
    }, false);

};


