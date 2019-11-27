function () {
    var popUpAparece = document.getElementById("popUpAparecer");
    var modalBg = document.querySelector(".popup");

    popUpAparece.addEventListener("", function() {
        modalBg.classList.add("popup-active");
    });
    
};
