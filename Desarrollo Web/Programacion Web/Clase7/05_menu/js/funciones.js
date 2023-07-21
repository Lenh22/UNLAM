$(document).ready(function(){ 
    $("a.desplegable").toggle(
          function() {
            $(this).parent().find("nav.menu").slideDown('');
          },
          function() {
            $(this).parent().find("nav.menu").slideUp('');
          }                        
        );
$(window).resize(function(){
    if($(this).width()>768){
        $("a.desplegable").parent().find("nav.menu").show();
    } else{
        $("a.desplegable").parent().find("nav.menu").hide();
    }
});
});