
(function ($) {


	"use strict";


	/**
	 * introLoader - Preloader
	 */
	$("#introLoader").introLoader({
		animation: {
			name: 'gifLoader',
			options: {
				ease: "easeInOutCirc",
				style: 'dark bubble',
				delayBefore: 500,
				delayAfter: 0,
				exitTime: 300
			}
		}
	});



	/**
	 * Sticky Header
	 */
	$(".container-wrapper").waypoint(function() {
		$(".navbar").toggleClass("navbar-sticky-function");
		$(".navbar").toggleClass("navbar-default navbar-sticky");
		return false;
	}, { offset: "-20px" });



	/**
	 * Main Menu Slide Down Effect
	 */

		// Mouse-enter dropdown
	$("#navbar li").on("mouseenter", function() {
		$(this).find('ul').first().stop(true, true).delay(350).slideDown(500, 'easeInOutQuad');
	});

	// Mouse-leave dropdown
	$("#navbar li").on("mouseleave", function() {
		$(this).find('ul').first().stop(true, true).delay(100).slideUp(150, 'easeInOutQuad');
	});



	/**
	 * Effect to Bootstrap Dropdown
	 */
	$(".bt-dropdown-click").on('show.bs.dropdown', function(e) {
		$(this).find('.dropdown-menu').first().stop(true, true).slideDown(500, 'easeInOutQuad');
	});
	$(".bt-dropdown-click").on('hide.bs.dropdown', function(e) {
		$(this).find('.dropdown-menu').first().stop(true, true).slideUp(250, 'easeInOutQuad');
	});



	/**
	 * Icon Change on Collapse
	 */
	$(".collapse.in").prev(".panel-heading").addClass('active');
	$(".bootstarp-accordion, .bootstarp-toggle").on('show.bs.collapse', function(a) {
			$(a.target).prev('.panel-heading').addClass('active');
		})
		.on("hide.bs.collapse", function(a) {
			$(a.target).prev('.panel-heading').removeClass('active');
		});



	/**
	 * Slicknav - a Mobile Menu
	 */
	var $slicknav_label;
	$("#responsive-menu").slicknav({
		duration: 300,
		easingOpen: 'easeInExpo',
		easingClose: 'easeOutExpo',
		closedSymbol: '<i class="fa fa-plus"></i>',
		openedSymbol: '<i class="fa fa-minus"></i>',
		prependTo: '#slicknav-mobile',
		allowParentLinks: true,
		label:""
	});



	/**
	 * Smooth scroll to anchor
	 */
	$("a.anchor[href*=#]:not([href=#])").on("click",function() {
		if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			if (target.length) {
				$("html,body").animate({
					scrollTop: (target.offset().top - 90) // 90 offset for navbar menu
				}, 1000);
				return false;
			}
		}
	});



	/**
	 * Another Bootstrap Toggle
	 */
	$(".another-toggle").each(function(){
		if( $('h4',this).hasClass('active') ){
			$(this).find('.another-toggle-content').show();
		}
	});
	$(".another-toggle h4").click(function(){
		if( $(this).hasClass('active') ){
			$(this).removeClass('active');
			$(this).next('.another-toggle-content').slideUp();
		} else {
			$(this).addClass('active');
			$(this).next('.another-toggle-content').slideDown();
		}
	});



	/**
	 *  Arrow for Menu has sub-menu
	 */
	/* if ($(window).width() > 992) {
	 $(".navbar-arrow > ul > li").has("ul").children("a").append("<i class='arrow-indicator fa fa-angle-down'></i>");
	 } */

	if ($(window).width() > 992) {
		$(".navbar-arrow ul ul > li").has("ul").children("a").append("<i class='arrow-indicator fa fa-angle-right'></i>");
	}



	/**
	 * Back To Top
	 */
	$(window).scroll(function(){
		if($(window).scrollTop() > 500){
			$("#back-to-top").fadeIn(200);
		} else{
			$("#back-to-top").fadeOut(200);
		}
	});
	$("#back-to-top").on("click",function() {
		$('html, body').animate({ scrollTop:0 }, '800');
		return false;
	});



	/**
	 * Bootstrap Tooltip
	 */
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	})



	/**
	 * Placeholder
	 */
	$("input, textarea").placeholder();



	/**
	 * Latest Job Ticker
	 */
	$(".latest-job-ticker").easyTicker({
		visible: 1,
		interval: 4000
	});


	/**
	 * Counter - Number animation
	 */
	$(".counter").countimator();



	/**
	 * Price Range Slider
	 */
	$("#price_range").ionRangeSlider({
		type: "double",
		grid: true,
		min: 0,
		max: 5,
		from: 1,
		to: 800,
		prefix: ""
	});




	/**
	 * Tokenfield for Bootstrap
	 * http://sliptree.github.io/bootstrap-tokenfield/
	 */

	$(".tokenfield").tokenfield()

	// Autocomplete Tagging
	var engine = new Bloodhound({
		local: [{value: 'red'}, {value: 'blue'}, {value: 'green'} , {value: 'yellow'}, {value: 'violet'}, {value: 'brown'}, {value: 'purple'}, {value: 'black'}, {value: 'white'}],
		datumTokenizer: function(d) {
			return Bloodhound.tokenizers.whitespace(d.value);
		},
		queryTokenizer: Bloodhound.tokenizers.whitespace
	});
	engine.initialize();
	$("#autocompleteTagging").tokenfield({
		typeahead: [null, { source: engine.ttAdapter() }]
	});



})(jQuery);





