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
			'consulta': "required"
		},
		messages: {'nombre': "Ingrese su nombre",'email': { required: 'Debe ingresar un email', email: 'Debe ingresar un email v&aacute;lido' },'consulta': "Ingrese un mensaje"},
		debug: true,errorElement: "label",errorContainer: $("#errores"),
		submitHandler: function(form){
			$("#mensaje").show();
			$("#mensaje").html("<p class='pensando'>Enviando el formulario, por favor espere...</p>");
			$.ajax({
				type: "POST",
				url:"formularios/formcontacto.php",
				contentType: "application/x-www-form-urlencoded",
				processData: true,
				data: "&nombre="+escape($('#nombre').val())+"&email="+escape($('#email').val())+"&consulta="+escape($('#consulta').val()),
				success: function(msg){
					$("#mensaje").html("<p class='ok'>El mensaje ha sido enviado correctamente.Gracias!</p>");
					document.getElementById("nombre").value="";
					document.getElementById("email").value="";
					document.getElementById("consulta").value="";
					setTimeout(function() {$('#mensaje').fadeOut('fast');}, 6000);

				}
			});
		}
	});;
});