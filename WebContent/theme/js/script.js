/**
 * Created by Joao Sousa on 18/05/2016.
 */
function cpfValidate(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    //strCPF  = RetiraCaracteresInvalidos(strCPF,11);
    if (strCPF == "00000000000" || strCPF == "11111111111" || strCPF == "22222222222" || strCPF == "33333333333" || strCPF == "44444444444")
        return false;
    for (i=1; i<=9; i++)
        Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11))
        Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) )
        return false;
    Soma = 0;
    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11))
        Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) )
        return false;
    return true;
}

$(window).ready(function(){
    var scrollPosition = $(window).scrollTop(), documentHeight = $(document).height(),windowHeight = $(window).height();
    var formLogin = $('form.login');

    if( windowHeight < 567 ){
        $("footer").fadeIn();
    }else{
        $("footer").fadeOut();
    }

    $(window).scroll(function(){
        scrollPosition = $(window).scrollTop();
        //header
        if(scrollPosition > 60){
            $("header").addClass("mini");
        }else{
            $("header").removeClass("mini");
        }
        //footer
        if( scrollPosition >= (documentHeight - windowHeight) ){
            $("footer").fadeIn();
        }else{
            $("footer").fadeOut();
        }
        //$(".show").removeClass("show");
    });
    $(window).resize(function(){

    });

    //toogle header if mini
    $("header").hover(function(){
        if($(window).scrollTop() > 60){
            $(this).toggleClass("mini")
        }
    });

    /*
     $(window).on("click",function(e) {
     var el = e.target, target = $(el).attr("id");
     if (target == "login"){
     $("#login").toggleClass("active");
     formLogin.toggleClass("show");
     }
     if (target == "user-nav"){
     $("#user-nav a").toggleClass("active");
     $(".user-nav-options").toggleClass("show");
     }
     });
     */

    //MENU
    //CHANGE THIS CODE
    $(".shop").on("click",function(e) {
        e.preventDefault();
        $("ul>li>a").removeClass("active");
        $("#cart").toggleClass("show");
        $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
        $(".show").not("#cart").removeClass("show");
    });
    //CHANGE THIS CODE
    $("#login").on("click",function(e) {
        e.preventDefault();
        $("ul>li>a").not(this).removeClass("active");
        $("#login").toggleClass("active");
        formLogin.toggleClass("show");
        $(".show").not(formLogin).removeClass("show");
        $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
    });
    // CHANGE THIS CODE
    $("#user-nav").on("click",function(e) {
        e.preventDefault();
        $("ul>li>a").not("#user-nav").removeClass("active");

        $("#user-nav").toggleClass("active");

        if($("#user-nav").hasClass("active")){
            $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o-w.png");
        }else{
            $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
        }
        $(".user-nav-options").toggleClass("show");
        $(".show").not(".user-nav-options").removeClass("show");
    });

    $('input[class=cep]').on('blur',function(){
        var cep = $jq(this).val();
        console.log(cep);
        $.get('http://viacep.com.br/ws/'+cep+'/json', function(data){
            console.log("Conectado");
        }).done(function(data){
            /*
             * data{cep, logradouro, complemento, bairro, localidade, uf, ibge, gia}
             */
            //$jq('input[name=endereco]').val(data.logradouro);
            //$jq('input[name=bairro]').val(data.bairro);
            $('input[name=cidade]').val(data.localidade);
            $('input[name=estado]').val(data.uf);
            $('input[name=cep]').attr('style','border-color:#449D44;color:#449D44');
        }).fail(function(){
            $('input[name=cep]').attr('style','border-color:#C9302C;color:#C9302C');
            console.log("Falha na coneção");
        });
    });

    //cart
    $('#cart').on('click','a.remove',function(){
        $(this).closest('.item').css('background','#FF5454').fadeOut();
    });

});