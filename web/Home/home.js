 $(window).on("scroll", function(){
            if($(window).scrollTop()){
                $("nav").addClass("navFixed");
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
class TypeWriter {
    constructor(txtElement, words, wait = 3000) {
      this.txtElement = txtElement;
      this.words = words;
      this.txt = '';
      this.wordIndex = 0;
      this.wait = parseInt(wait, 10);
      this.type();
      this.isDeleting = false;
}
  
    type() {
        const current = this.wordIndex % this.words.length;
        const fullTxt = this.words[current];
            
            if(this.isDeleting) {
                this.txt = fullTxt.substring(0, this.txt.length - 1);
            } else {
                this.txt = fullTxt.substring(0, this.txt.length + 1);
            }
        
        this.txtElement.innerHTML = `<span class="txt">${this.txt}</span>`;
        let typeSpeed = 100;
    
            if(this.isDeleting) {
                typeSpeed /= 2;
            }
    
            if(!this.isDeleting && this.txt === fullTxt) {
                typeSpeed = this.wait;
                this.isDeleting = true;
            } else if(this.isDeleting && this.txt === '') {
                this.isDeleting = false;
                this.wordIndex++;
                typeSpeed = 500;
            }
    
        setTimeout(() => this.type(), typeSpeed);
    }
}
  
document.addEventListener('DOMContentLoaded', init);
  
function init() {
    const txtElement = document.querySelector('.txt-type');
    const words = JSON.parse(txtElement.getAttribute('data-words'));
    const wait = txtElement.getAttribute('data-wait');
    new TypeWriter(txtElement, words, wait);
}

var popUpAparece = document.getElementById("popUpAparecer");
var modalBg = document.querySelector(".popup");
var modalClose = document.querySelector(".close");
var modalClose2 = document.querySelector(".close2");

popUpAparece.addEventListener("click", function() {
    modalBg.classList.add("popup-active");
});

modalClose.addEventListener("click", function() {
    modalBg.classList.remove("popup-active");
});

modalClose2.addEventListener("click", function() {
    modalBg.classList.remove("popup-active");
});

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener("click", () => container.classList.add('right-panel-active'));
signInButton.addEventListener("click", () => container.classList.remove('right-panel-active'));



function autorizacao() {
    var user = document.getElementById("email").value;
    var senha = document.getElementById("senha").value;

    if(user == "admin" && senha == "admin") {
        return autorizado();
    } 
}
function autorizado() {
    location.assign("../Adm/administrador.html");
}


