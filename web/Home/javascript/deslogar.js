var deslogar = document.getElementById('deslogar');

document.getElementById('deslogar').addEventListener("click", function() {
	document.querySelector('.deslogar-modal').style.display = "flex";
});

document.querySelector('.sair').addEventListener("click", function() {
	document.querySelector('.deslogar-modal').style.display = "none";
});

