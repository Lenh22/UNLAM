$(document).ready(function(){
    $('#btnEnviar').click(function(){
       setTimeout(function(){ 
			toastr.success("Todo enviado");
            Ladda.stopAll();
		},5000);
    });
	Ladda.bind( '.ladda-button', { timeout: 30000 } );
});