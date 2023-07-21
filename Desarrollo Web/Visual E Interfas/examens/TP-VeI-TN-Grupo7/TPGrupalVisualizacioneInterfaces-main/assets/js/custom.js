$(document).ready(function(){
	"use strict";
    
        /*==================================
* Author        : "ThemeSINE"
* Template Name : Zombiz HTML Template
* Version       : 1.0
==================================== */




        /*=========== TABLE OF CONTENTS ===========
1. Scroll To Top 
2. hcsticky 
3. Counter
4. owl carousel
5. vedio player
======================================*/

    // 1. Scroll To Top 
		$(window).on('scroll',function () {
			if ($(this).scrollTop() > 600) {
				$('.return-to-top').fadeIn();
			} else {
				$('.return-to-top').fadeOut();
			}
		});
		$('.return-to-top').on('click',function(){
				$('html, body').animate({
				scrollTop: 0
			}, 1500);
			return false;
		});
	
	
	// 2 . hcsticky 

		$('#menu').hcSticky();


	// 3. counter
		$(window).on('load', function(){	
			$('.counter').counterUp({
				delay: 10,
				time: 3000
			});	
		});
	
	
	// 4. owl carousel

		// i. .team-carousel 
	
		
		var owl=$('.team-carousel');
		owl.owlCarousel({
			items:4,
			margin:0,
			
			loop:true,
			autoplay:true,
			smartSpeed:500,
			
			//nav:false,
			//navText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"],
			
			dots:false,
			autoplayHoverPause:true,
		
			responsiveClass:true,
				responsive:{
					0:{
						items:1
					},
					640:{
						items:2
					},
					768:{
						items:3
					},
					992:{
						items:4
					}
				}
			
			
		});

		// ii. .client (carousel)
		
		$('#client').owlCarousel({
			items:5,
			loop:true,
			smartSpeed: 1000,
			autoplay:true,
			dots:false,
			autoplayHoverPause:true,
			responsive:{
					0:{
						items:2
					},
					415:{
						items:2
					},
					600:{
						items:3
					},
					1000:{
						items:5
					}
				}
			});
			
			
			$('.play').on('click',function(){
				owl.trigger('play.owl.autoplay',[1000])
			})
			$('.stop').on('click',function(){
				owl.trigger('stop.owl.autoplay')
			})

		// iii.  testimonial
		
		$("#testemonial-carousel").owlCarousel({
			items: 1,
			autoplay: true,
			loop: true,
			dots:true,
			mouseDrag:true,
			nav:false,
			smartSpeed:1000,
			transitionStyle:"fade",
			animateIn: 'fadeIn',
			animateOut: 'fadeOutLeft'
			// navText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
		});

	// 5. vedio player
		$('.vedio-play-icon').magnificPopup({
			
			type:'video'
		
		});

	// 6. animation support

        $(window).load(function(){

            $(".single-slide-item-content h2, .single-slide-item-content p").removeClass("animated fadeInUp").css({'opacity':'0'});
            $(".single-slide-item-content button").removeClass("animated fadeInLeft").css({'opacity':'0'});
        });

        $(window).load(function(){

            $(".single-slide-item-content h2, .single-slide-item-content p").addClass("animated fadeInUp").css({'opacity':'0'});
            $(".single-slide-item-content button").addClass("animated fadeInLeft").css({'opacity':'0'});

        });

    
    // 6. Smooth Scroll spy
        
        // $('.header-area').sticky({
        //    topSpacing:0
        // });
        
        //=============

        $('li.smooth-menu a').bind("click", function(event) {
            event.preventDefault();
            var anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $(anchor.attr('href')).offset().top - -1
            }, 1200,'easeInOutExpo');
        });
        
        $('body').scrollspy({
            target:'.navbar-collapse',
            offset:0
        });
		
});	
	