$(document).ready(function() {
	$(".goto-top-btn").click(function() {
		$("html, body").animate({ scrollTop: 0 }, "slow");
	});
	$( "#videoCarousel" ).videoCarousel();

});

var VideoCarousel = function() {

	function VideoCarousel(element, config) {
		this._config = this._getConfig(config);
		this._element = element;
		this._id = this._element.id;
		this._initializeHtml();
		this._addEventListeners();
		this._setAutoSlide(this._config);
	}
	
	var DATA_KEY$2 = 'bs.videoCarousel';
	var videoCarouselDefault = {
		interval: 50000
	};
	var _proto = VideoCarousel.prototype;

	_proto._initializeHtml = function _initializeHtml() {
		
		var _this = this;
				
		// Append Indicator Controls
		var parentEle = $("#" + this._id + " .carousel-inner");
		var numOfChildren = parentEle.children().length;
		var liIndicatorsHtml = "<li data-target='#" + this._id + "' data-slide-to='0' class='active'></li>"
		for(var i=1; i < numOfChildren; i++) {
			liIndicatorsHtml += "<li data-target='#" + this._id + "' data-slide-to='" + i + "' ></li>"
		}
		$(_this._element).append("<ul class='carousel-indicators mb-4'>" + liIndicatorsHtml + "</ul>");

		// Append Video Carousel Controls
		parentEle.append("<a class='carousel-control carousel-control-prev' data-slide='prev'>"
				+ "<span class='carousel-control-icon carousel-control-prev-icon'></span></a>");
		parentEle.append("<a class='carousel-control carousel-control-next' data-slide='next'>"
				+ "<span class='carousel-control-icon carousel-control-next-icon'></span></a>");
	
		// Append Youtube Player Modal
		if(!$("body .youtube-player-modal").length) {
			$("body").append("<div class='youtube-player-modal d-none'><div class='youtube-player-body'><i class='close-btn fas fa-times'></i><div></div>");
		}
	}

	_proto._addEventListeners = function _addEventListeners() {

		var _this = this;
		
		// Click Video Carousel Control Events
		$(_this._element).on("click", ".carousel-control-prev", function() {
			var activeEleIndex = $("#" + _this._id + " .video-carousel-item.active").index() - 1;
			_this._swipeImages(activeEleIndex);
		});
		$(_this._element).on("click", ".carousel-control-next", function() {
			var activeEleIndex = $("#" + _this._id + " .video-carousel-item.active").index() + 1;		
			_this._swipeImages(activeEleIndex);
		});
		
		// Click Video Carousel Indicator Events
		$(_this._element).on("click", ".carousel-indicators li", function() {
			var index = $(this).index();
			$("#" + _this._id + " .carousel-indicators li").removeClass("active");
			$(this).addClass("active");
			_this._swipeImages(index);
		});
		
		// Click button play video
		$(_this._element).on("click", ".btn-play-video", function() {
			var youtubeId = $(this).data("youtube-id");
			if (youtubeId) {
				var youtubeUrl = "https://www.youtube.com/embed/" + youtubeId + "?autoplay=1";
				$(".youtube-player-modal .youtube-player-body iframe").remove();
				$(".youtube-player-modal .youtube-player-body").append("<iframe width='100%' height='100%' src='" + youtubeUrl + "' frameborder='0' allowfullscreen=''></iframe>");
				$(".youtube-player-modal").removeClass("d-none");
			}		
		});		
		
		$(".youtube-player-modal").on("click", ".close-btn", function() {
			$(".youtube-player-modal").addClass("d-none");
		});
		$("body").on("click", ".youtube-player-modal:not(.youtube-player-body)", function() {
			$(".youtube-player-modal").addClass("d-none");
		});			
	}

	_proto._getConfig = function _getConfig(config) {
		config = _objectSpread2({}, videoCarouselDefault, {}, config);
		return config;
	};
	
	_proto._setAutoSlide = function _setAutoSlide(config) {

		var _this = this;
		var intervalTime = $(_this).data("interval");
		if (!intervalTime) {
			intervalTime = config.interval;
		}

		setInterval(function() {
			var activeEleIndex = $(".video-carousel-item.active").index() + 1;		
			_this._swipeImages(activeEleIndex);
		}, intervalTime);
	}

	_proto._swipeImages = function _swipeImages(activeEleIndex) {

		var _this = this;
		var nextEleIndex;
		var prevEleIndex;	
		var parentEle = $("#" + _this._id + " .carousel-inner");
		var numOfChildren = parentEle.children(".video-carousel-item").length;
		var videoCarouselItems = $("#" + _this._id + " .video-carousel-item");		
	
		if (activeEleIndex >= numOfChildren) {
			activeEleIndex = 0;
		}
		
		if(activeEleIndex == 0) {
			nextEleIndex = 1;
			prevEleIndex = numOfChildren - 1;
		} else if (activeEleIndex < 0) {
			activeEleIndex = numOfChildren - 1;
			nextEleIndex = 0;	
			prevEleIndex = activeEleIndex - 1;
		} else {
			nextEleIndex = activeEleIndex + 1;
			prevEleIndex = activeEleIndex - 1;
			if (prevEleIndex < 0) {
				prevEleIndex = numOfChildren - 1;
			}
			if (nextEleIndex == numOfChildren) {
				nextEleIndex = 0;
			}
		}
		
		videoCarouselItems.removeClass().addClass("video-carousel-item hide");
		videoCarouselItems.eq(activeEleIndex).removeClass("hide").addClass("active");
		videoCarouselItems.eq(nextEleIndex).removeClass("hide").addClass("next");
		videoCarouselItems.eq(prevEleIndex).removeClass("hide").addClass("prev");
		$("#" + _this._id + " .carousel-indicators li").removeClass("active");
		$("#" + _this._id + " .carousel-indicators li").eq(activeEleIndex).addClass("active");
	}

	VideoCarousel._jQueryInterface = function _jQueryInterface(config) {
		return this.each(function () {
			var _config = _objectSpread2({}, videoCarouselDefault, {}, $(this).data());
			if (typeof config === 'object') {
				_config = _objectSpread2({}, _config, {}, config);
			}
			$(this).data(DATA_KEY$2, new VideoCarousel(this, _config));
		});
	};
	return VideoCarousel;
}();
	
/**
* ------------------------------------------------------------------------
* jQuery
* ------------------------------------------------------------------------
*/

$.fn["videoCarousel"] = VideoCarousel._jQueryInterface;


function ownKeys(object, enumerableOnly) {
	var keys = Object.keys(object);

	if (Object.getOwnPropertySymbols) {
		var symbols = Object.getOwnPropertySymbols(object);
		if (enumerableOnly)
			symbols = symbols.filter(function(sym) {
				return Object.getOwnPropertyDescriptor(object, sym).enumerable;
			});
		keys.push.apply(keys, symbols);
	}

	return keys;
}

function _objectSpread2(target) {
	for (var i = 1; i < arguments.length; i++) {
		var source = arguments[i] != null ? arguments[i] : {};

		if (i % 2) {
			ownKeys(Object(source), true).forEach(function(key) {
				_defineProperty(target, key, source[key]);
			});
		} else if (Object.getOwnPropertyDescriptors) {
			Object.defineProperties(target, Object.getOwnPropertyDescriptors(source));
		} else {
			ownKeys(Object(source)).forEach(
					function(key) {
						Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key));
					});
		}
	}
	return target;
}

function _defineProperty(obj, key, value) {
	if (key in obj) {
		Object.defineProperty(obj, key, {
			value : value,
			enumerable : true,
			configurable : true,
			writable : true
		});
	} else {
		obj[key] = value;
	}

	return obj;
}