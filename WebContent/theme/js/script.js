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
    });
    $(window).resize(function(){

    });

    //toogle header if mini
    $("header").hover(function(){
        if($(window).scrollTop() > 60){
            $(this).toggleClass("mini")
        }
    });

    $(window).on("click",function(e) {
        var el = e.target, target = $(el).attr("id");
        if (target == "login"){
            $("#login").toggleClass("active");
            formLogin.toggleClass("show");
        }
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
        /*
         $('output[name=logradouro]').innerText = res.logradouro;
         $('output[name=complemento]').innerText = res.complemento;
         $('output[name=bairro]').innerText = res.bairro;
         $('output[name=localidade]').innerText = res.localidade;
         $('output[name=uf]').innerText = res.uf;
         */
    });

});

