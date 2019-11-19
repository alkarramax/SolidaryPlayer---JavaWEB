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
        doacoes_act = document.getElementById('doacoes-actions'),
        necessidade_act = document.getElementById('necessidade-actions'),
        players_act = document.getElementById('players-actions');

    var actions = [home_act, doacoes_act, necessidade_act, players_act];

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
        doacoes  = document.getElementById('doacoes'),
        necessidades  = document.getElementById('necessidades'),
        players  = document.getElementById('player');
    
    var buttons = [home, doacoes, necessidades, players];

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

    var exit = document.getElementById("exit");
    exit.addEventListener('click', function() {
       location.assign("../Home/home.jsp");
    }, false);

};


