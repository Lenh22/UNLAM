

(function (globals) {

  var django = globals.django || (globals.django = {});

  
  django.pluralidx = function (n) {
    var v=(n != 1);
    if (typeof(v) == 'boolean') {
      return v ? 1 : 0;
    } else {
      return v;
    }
  };
  

  
  /* gettext library */

  django.catalog = {
    "%(sentDate)s by %(user)s": "%(sentDate)s por %(user)s", 
    "A newer version of this article has been published since this draft was saved. You can restore the draft to view the content, but you will not be able to submit it for publishing.": "Se ha publicado una nueva versi\u00f3n de este art\u00edculo desde que se guard\u00f3 este borrador. Puedes restaurar el borrador para ver el contenido, pero no podr\u00e1s enviarlo para su publicaci\u00f3n.", 
    "Article Title Lookup / Link Text": "B\u00fasqueda del t\u00edtulo del art\u00edculo / texto del v\u00ednculo", 
    "Aspect ratio": "Relaci\u00f3n de aspecto", 
    "Attachments": "Archivos adjuntos", 
    "Autosave enabled.": "Autoguardado activado.", 
    "CSS": "CSS", 
    "Changes saved.": "Se han guardado los cambios.", 
    "Close": "Cerrar", 
    "Close notification": "Cerrar notificaci\u00f3n", 
    "Close submenu": "Cerrar submen\u00fa", 
    "Compare this date to the latest revision date to ensure you're not overwriting later changes.": "Compara esta fecha con la de la \u00faltima revisi\u00f3n para asegurarte de que no est\u00e1s sobreescribiendo los \u00faltimos cambios.", 
    "Create a Redirect": "Crear una Redirecci\u00f3n", 
    "Default": "Predeterminada", 
    "Details": "Detalles", 
    "Discard draft.": "Descartar borrador.", 
    "Document": "Documento", 
    "Draft autosaved:": "Borrador autoguardado:", 
    "Draft discarded.": "Borrador descartado.", 
    "Draft discarded:": "Borrador descartado:", 
    "Draft published:": "Borrador publicado:", 
    "Draft restored.": "Borrador recuperado.", 
    "Edit Page": "Editar p\u00e1gina", 
    "Embed YouTube Video": "Integrar video de YouTube", 
    "Error loading content, please refresh the page": "Error al cargar contenido, por favor actualice la p\u00e1gina", 
    "Error submitting as %(type)s": "Error al enviarlo como %(type)s", 
    "HTML": "HTML", 
    "Hang on! Updating filters\u2026": "\u00a1Espera! Actualizando filtros\u2026", 
    "History": "Historial", 
    "Insert Code Sample Template": "Insertar plantilla de muestra de c\u00f3digo", 
    "Insert Code Sample iFrame": "Insertar una muestra de c\u00f3digo iFrame", 
    "JavaScript": "JavaScript", 
    "Launch": "Lanzar", 
    "Locate a YouTube Video": "Ubicar un video de YouTube", 
    "MDN Redirect": "Redirecci\u00f3n a MDN", 
    "More about the beta.": "Saber m\u00e1s sobre la versi\u00f3n beta.", 
    "Never": "Nunca", 
    "New compatibility tables are in beta ": "Las nuevas tablas de compatibilidad est\u00e1n en beta ", 
    "New interest...": "Nuevo inter\u00e9s...", 
    "New tag...": "Nueva etiqueta...", 
    "No": "No", 
    "No Highlight": "No resaltar", 
    "No attachments available": "No hay archivos adjuntos disponibles", 
    "No selection": "No se ha seleccionado nada", 
    "Open": "Abrir", 
    "Open implementation notes": "Abrir notas de implementaci\u00f3n", 
    "Open in %(site)s": "Abrir en %(site)s", 
    "Paste YouTube Video URL": "Pegar la URL de un video de YouTube", 
    "Published version": "Versi\u00f3n publicada", 
    "Publishing changes\u2026": "Publicando cambios...", 
    "Publishing failed. Please copy and paste your changes into a safe place and try submitting the form using the \"Publish\" button.": "La publicaci\u00f3n ha fallado. Copia y pega los cambios en un lugar seguro e intenta enviar el formulario de nuevo utilizando el bot\u00f3n \"Publicar\".", 
    "Publishing failed. You are not currently signed in. Please use a new tab to sign in and try publishing again.": "La publicaci\u00f3n ha fallado. No tienes iniciada la sesi\u00f3n. Vuelve a iniciar sesi\u00f3n en una nueva pesta\u00f1a e intenta publicarlo de nuevo.", 
    "Report an error.": "Informar de un error.", 
    "Reported. Thanks!": "Enviado. \u00a1Gracias!", 
    "Restore draft.": "Recuperar borrador.", 
    "Result": "Resultado", 
    "Return to compatibility table.": "Volver a la tabla de compatibilidad.", 
    "Revert": "Deshacer", 
    "Revision history.": "Historial de revisi\u00f3n.", 
    "Sample CSS Content": "Muestra de contenido CSS", 
    "Sample Finder": "Buscador de muestras", 
    "Sample HTML Content": "Muestra de contenido HTML", 
    "Sample JavaScript Content": "Muestra de contenido JavaScript", 
    "Search Stack Overflow": "Buscar en Stack Overflow", 
    "Sections in Document": "Secciones del documento", 
    "Select a section": "Selecciona una secci\u00f3n", 
    "Select an attachment": "Selecciona un archivo adjunto", 
    "Selected: ": "Seleccionado:\u00a0", 
    "Show old table.": "Mostrar la tabla antigua.", 
    "Submitted as %(submissionType)s": "Enviado como %(submissionType)s", 
    "Submitting...": "Enviando...", 
    "Syntax Highlighter": "Resaltar sintaxis", 
    "Take the survey": "Hacer la encuesta", 
    "The URL you've entered doesn't appear to be valid": "La URL que has introducido parece que no es v\u00e1lida", 
    "URL": "URL", 
    "Updated filters.": "Filtros actualizados.", 
    "View Page": "Ver p\u00e1gina", 
    "View draft.": "Ver borrador.", 
    "Viewing old draft. This draft cannot be published.": "Est\u00e1s viendo un borrador antiguo, que no se puede publicar.", 
    "What should the sample title be?": "\u00bfCu\u00e1l deber\u00eda ser el t\u00edtulo de la muestra?", 
    "Would you answer 4 questions for us? <a %(url)s>Open the survey in a new tab</a> and fill it out when you are done on the site. Thanks!": "\u00bfContestar\u00edas a 4 preguntas? <a %(url)s>Abre la encuesta en una nueva pesta\u00f1a</a> y rell\u00e9nala cuando termines en el sitio. \u00a1Gracias!", 
    "Yes": "S\u00ed", 
    "You are now viewing this site in %(localeName)s. Do you always want to view this site in %(localeName)s?": "Ahora est\u00e1s viendo este sitio en %(localeName)s. \u00bfQuieres ver siempre este sitio en %(localeName)s?", 
    "You have a draft from: %(time)s.": "Tienes un borrador de: %(time)s.", 
    "You must input a valid YouTube video URL.": "Debes introducir una URL v\u00e1lida para un video de YouTube.", 
    "Your browser does not support MathML. A CSS fallback has been used instead.": "Tu navegador no admite MathML. En su lugar, se ha utilizado otro recurso CSS.", 
    "an unknown date": "una fecha desconocida"
  };

  django.gettext = function (msgid) {
    var value = django.catalog[msgid];
    if (typeof(value) == 'undefined') {
      return msgid;
    } else {
      return (typeof(value) == 'string') ? value : value[0];
    }
  };

  django.ngettext = function (singular, plural, count) {
    var value = django.catalog[singular];
    if (typeof(value) == 'undefined') {
      return (count == 1) ? singular : plural;
    } else {
      return value[django.pluralidx(count)];
    }
  };

  django.gettext_noop = function (msgid) { return msgid; };

  django.pgettext = function (context, msgid) {
    var value = django.gettext(context + '\x04' + msgid);
    if (value.indexOf('\x04') != -1) {
      value = msgid;
    }
    return value;
  };

  django.npgettext = function (context, singular, plural, count) {
    var value = django.ngettext(context + '\x04' + singular, context + '\x04' + plural, count);
    if (value.indexOf('\x04') != -1) {
      value = django.ngettext(singular, plural, count);
    }
    return value;
  };
  

  django.interpolate = function (fmt, obj, named) {
    if (named) {
      return fmt.replace(/%\(\w+\)s/g, function(match){return String(obj[match.slice(2,-2)])});
    } else {
      return fmt.replace(/%s/g, function(match){return String(obj.shift())});
    }
  };


  /* formatting library */

  django.formats = {
    "DATETIME_FORMAT": "j \\d\\e F \\d\\e Y \\a \\l\\a\\s H:i", 
    "DATETIME_INPUT_FORMATS": [
      "%d/%m/%Y %H:%M:%S", 
      "%d/%m/%Y %H:%M:%S.%f", 
      "%d/%m/%Y %H:%M", 
      "%d/%m/%y %H:%M:%S", 
      "%d/%m/%y %H:%M:%S.%f", 
      "%d/%m/%y %H:%M", 
      "%Y-%m-%d %H:%M:%S", 
      "%Y-%m-%d %H:%M:%S.%f", 
      "%Y-%m-%d %H:%M", 
      "%Y-%m-%d"
    ], 
    "DATE_FORMAT": "j \\d\\e F \\d\\e Y", 
    "DATE_INPUT_FORMATS": [
      "%d/%m/%Y", 
      "%d/%m/%y", 
      "%Y-%m-%d"
    ], 
    "DECIMAL_SEPARATOR": ",", 
    "FIRST_DAY_OF_WEEK": "1", 
    "MONTH_DAY_FORMAT": "j \\d\\e F", 
    "NUMBER_GROUPING": "3", 
    "SHORT_DATETIME_FORMAT": "d/m/Y H:i", 
    "SHORT_DATE_FORMAT": "d/m/Y", 
    "THOUSAND_SEPARATOR": ".", 
    "TIME_FORMAT": "H:i", 
    "TIME_INPUT_FORMATS": [
      "%H:%M:%S", 
      "%H:%M:%S.%f", 
      "%H:%M"
    ], 
    "YEAR_MONTH_FORMAT": "F \\d\\e Y"
  };

  django.get_format = function (format_type) {
    var value = django.formats[format_type];
    if (typeof(value) == 'undefined') {
      return format_type;
    } else {
      return value;
    }
  };

  /* add to global namespace */
  globals.pluralidx = django.pluralidx;
  globals.gettext = django.gettext;
  globals.ngettext = django.ngettext;
  globals.gettext_noop = django.gettext_noop;
  globals.pgettext = django.pgettext;
  globals.npgettext = django.npgettext;
  globals.interpolate = django.interpolate;
  globals.get_format = django.get_format;

}(this));

