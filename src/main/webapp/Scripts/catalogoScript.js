
// $.ajax({
//     type:'POST',    
    
//     url: "@Url.Action('CatalogarFilmesLancamento')",

// }).done(function(){
//     console.log("resposta")
// })


//isso daqui envia um parametro pro servlet depois dele ja ter carregadoa pagina. parametro assincrono


var paramFilme = {
    action: "CatalogarFilmesLancamento"   
};
var paramJogo = {
	action: "CatalogarJogosLancamento"
}

$.post("main", $.param(paramFilme), function(response) {
  	$('#filmes_id').append(response);
});
$.post("main", $.param(paramJogo), function(response){
	$("#jogos_id").append(response);
});

