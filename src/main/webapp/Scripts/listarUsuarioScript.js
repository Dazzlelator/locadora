/**
 * 
 */
var param1 = {
    action: "ListarUsuarios"   
};


$.post("main", $.param(param1), function(response) {
  	$('#acesso3').append(response);
});
