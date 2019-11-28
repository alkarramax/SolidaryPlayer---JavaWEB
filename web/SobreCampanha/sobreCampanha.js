var id_softplayer, id_campanha, qtdDoada, id_necessidade;

function PopUp() {
    var popUpAparece = document.getElementById("popUpAparecer");
    var modalBg = document.querySelector(".popup");

    popUpAparece.addEventListener("", function() {
        modalBg.classList.add("popup-active");
    });
}

