$(document).ready(function(){
	$("#mensaje").hide();
	$("#form").validate({
		event: "blur",rules: 
		{
			'nombre': "required",
			'email': 
		    {
				required: true,
				email:true
			},
			'apellido': {
                required:true,
                maxlength: 4
            },
            'provincia':"required",
            'condiciones':"required",
            'sexo':"required"
		},
		messages: {'nombre': "Ingrese su nombre",'email': { required: 'Debe ingresar un email', email: 'Debe ingresar un email v&aacute;lido' },'apellido': { required: 'Debe ingresar un email', maxlength: 'No mas de 4 caracteres' }},
		debug: true,errorElement: "label",errorContainer: $("#errores"),
		submitHandler: function(form){
			$("#mensaje").show();
			$("#mensaje").html("<p class='pensando'>Enviando el formulario, por favor espere...</p>");
			form.submit();
		}
	});;
});