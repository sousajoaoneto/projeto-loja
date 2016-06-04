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
	var scrollPosition = $(window).scrollTop();
    var documentHeight = $(document).height();
    var windowWidth = $(window).width(), windowHeight = $(window).height();
    var formLogin = $('form.login'), popup = $(".popup"), popupWidth = "",popupHeight="",popupMarginTop="";


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

    popupWidth = windowWidth * 0.6;
    popupHeight = windowHeight * 0.7;
    popupMarginTop = windowHeight * 0.15;
    popup.width(popupWidth).height(popupHeight).css("margin-top",popupMarginTop);

    $(window).resize(function(){
        scrollPosition = $(window).scrollTop();
        documentHeight = $(document).height();
        windowWidth = $(window).width(), windowHeight = $(window).height();

        popupWidth = windowWidth * 0.6;
        popupHeight = windowHeight * 0.7;
        popupMarginTop = windowHeight * 0.15;
        popup.width(popupWidth).height(popupHeight).css("margin-top",popupMarginTop);
    });

    //toogle header if mini
    $("header").hover(function(){
        if($(window).scrollTop() > 60){
            $(this).toggleClass("mini")
        }
    });
    
    $(".overlay").on("click",function(e) {
        $(".show").fadeOut().removeClass("show");
        $(this).fadeOut();
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
        $('.overlay').fadeOut();
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

    $('#cep').on('blur',function(){
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
    	setTimeOut(function(){
    		$(this).closest('.item').css('background','#FF5454').fadeOut();
    	},300);
        
        return true;
    });
    
    
    
    /* PRODUCTS*/
    $('.open_item').on('click',function(e){
        e.preventDefault();
        $("ul>li>a").removeClass("active");
        $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
        $(".show").removeClass("show");
        $('.overlay').fadeIn();
        var productShow = $('#product-show');
        productShow.addClass('show').text("");

        var productLeft = $('<div>',{class:'col-sm-6 product-left'});
        var productTitle = $('<h3>');
        var img = $('<img>',{
            css : {
                width: 300,
                height: 300
            },
        });

        var productRight = $('<div>',{class:'col-sm-6 product-right'});
        var descriptionTitle = $('<h4>',{text:'Descrição do Produto'});
        var description = $('<p>');

        var button = $('<button>',{
            text : 'Adicionar ao Carrinho',
            class: 'btn btn-primary'
        });

        /*
         * var codigo = $(this).closest('.item').data('item');
        $.ajax({
            // url para o arquivo json.php
            url : "produto/busca.json",
            data: {'codigo':codigo},
            // dataType json
            dataType : "json",
            // função para de sucesso
            success : function(data){
            	var produto = data.produto;
            	productForm.find('h4.title').text('Editar '+produto.descricao);
            	            	
            	productTitle.text(produto.descricao);
                img.attr('src',produto.imagem);
                description.html('Preço: '+produto.preco+'<br>'+
                		'Quantidade em Estoque: '+produto.estoque+'<br>'
                		+'Modelo: '+produto.modelo.descricao);
            	
            	console.log(data);
            	
            	productLeft.append(img);
                productRight.append(descriptionTitle,description);
                productShow.append(productTitle,productLeft,productRight);
                
                productShow.addClass('show')
            	$('.overlay').fadeIn();
            }
        }).fail(function(data){
          	console.log("Falha");
          	console.log(data);
        });//termina o ajax 
         * */

        productTitle.text('Tigaragatiga power');
        img.attr('src','http://localhost:8080/projeto-loja/theme/images/catalogo/produto08.png');
        description.text('lorem');

        productLeft.append(img);
        productRight.append(descriptionTitle,description,button);

        productShow.append(productTitle,productLeft,productRight);
        
        
    });
    
    $('.cad-product').on('click',function(e){
        e.preventDefault();
        $("ul>li>a").removeClass("active");
        $(".show").removeClass("show");
        $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
        $('.overlay').fadeIn();
        
        var productForm = $('#product-form');
        var form = productForm.find('form');
        var action = form.attr('action');        
        var newAction = action.replace('editar','salvar');
        
        form.find('input, textarea').val('');
        
        form.attr('action',newAction);
        productForm.find('h4.title').text('Cadastrar Produto');
        
        productForm.addClass('show');
    });
    
    $('.edit_item').on('click',function(e){
        e.preventDefault();
        $("ul>li>a").removeClass("active");
        $(".show").removeClass("show");
        $("#user-nav").find("img").attr("src","http://localhost:8080/projeto-loja/theme/images/icon-user-o.png");
        
        var productForm = $('#product-form');
        var form = productForm.find('form');
        var action = form.attr('action');
        var newAction = action.replace('salvar','editar');
        form.attr('action',newAction);
        
        var codigo = $(this).closest('.item').data('item');
        $.ajax({
            // url para o arquivo json.php
            url : "produto/busca.json",
            data: {'codigo':codigo},
            // dataType json
            dataType : "json",
            // função para de sucesso
            success : function(data){
            	var produto = data.produto;
            	productForm.find('h4.title').text('Editar '+produto.descricao);
            	
            	//set data form
            	$('#descricao').val(produto.descricao);
            	$('#modelo').val(produto.modelo.descricao);
            	$('#estoque').val(produto.estoque);
            	$('#preco').val(produto.preco);
            	$('#produto-genero').val(produto.genero);
            	$('#imagem').val(produto.imagem);
            	$('#produto-tecnologia').val(produto.tecnologia);
            	$('#produto-cor').val(produto.cor[0].descricao);
            	
            	//inserir id_produto
            	$('#id_produto').remove();
            	var inputId = $('<input>',{
            		'type':'hidden',
            		'id': 'id_produto',
            		'name':'produto.id_produto',
            		'required':''	
            	});
            	inputId.val(produto.id_produto);
            	form.prepend(inputId);
            	
            	//inserir id_modelo
            	$('#id_produto').remove();
            	var inputIdModelo = $('<input>',{
            		'type':'hidden',
            		'id': 'id_modelo',
            		'name':'produto.modelo.id_modelo',
            		'required':''	
            	});
            	inputIdModelo.val(produto.modelo.id_modelo);
            	form.prepend(inputIdModelo);
            	
            	console.log(data);
            	productForm.addClass('show');
            	$('.overlay').fadeIn();
            }
        }).fail(function(data){
          	console.log("Falha");
          	console.log(data);
        });//termina o ajax
    });

});