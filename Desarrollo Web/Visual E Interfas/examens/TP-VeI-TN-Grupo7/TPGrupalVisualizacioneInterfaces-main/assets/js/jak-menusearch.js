$(document).ready(function(){
	"use strict";


	$('.search span').click(function () {
		var return_bool = false;

		if($(this).hasClass('active') && $('.search input').val().length !==0) {

			return_bool = true;
		}

		else if($(this).hasClass('active') && $('.search input').val().length ===0) {

			$('.search input').animate({

				width:'15px',
				opacity:0
			},350,'easeOutExpo',function(){
				$('.search span').removeClass('active');

			});

			return_bool = false;
		}

		else{

			$(this).addClass('active');
			$('.search input').animate({

				width:'150px',
				opacity:1
			},350,'easeOutExpo');

			return_bool = false;
		}

		return return_bool;

	});

});	
	