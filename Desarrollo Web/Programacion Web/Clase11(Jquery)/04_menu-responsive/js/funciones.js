$(document).ready(function(){ 
    $("a.desplegable").click(function(){
      if($('.menu').is(":visible")){
          $('.menu').slideUp();
      }else{
        $('.menu').slideDown();
      }
    });
    $(window).resize(function(){
        if($(this).width()>768){
            $(".menu").show();
        } else{
            $(".menu").hide();
        }
    });
});