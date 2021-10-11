


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

