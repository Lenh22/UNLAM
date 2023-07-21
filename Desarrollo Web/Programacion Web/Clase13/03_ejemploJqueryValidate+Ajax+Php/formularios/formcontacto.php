<?
   $nombre = $_POST['nombre'];
   $email = $_POST['email'];
   $consulta = $_POST['consulta'];
   $cabeceras = 'From:'.$nombre .'<'.$email.'>'."\r\n";
   $to = "ejemplo@ejemplo.com.ar";
   $subject = "Formulario de contacto";
   $cuerpo .= "Nombre y Apellido: " . $_POST['nombre'] . "\n";;
   $cuerpo .= "Email: " . $_POST['email'] . "\n";
   $cuerpo .= "Mensaje: " . $_POST['consulta'] . "\n";

  mail($to, $subject, $cuerpo,$cabeceras);


?>

