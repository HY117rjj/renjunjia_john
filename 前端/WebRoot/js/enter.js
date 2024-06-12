//全局onkeydown的enter转乘tab
 jQuery(function () {
	    jQuery('input:text:first').focus();//直接定位到当前页面的第一个文本框
	    var $inp = jQuery('input:text');//所有文本框
	    $inp.bind('keydown', function (e) {
	        var key = e.which;
	        if (key == 13) {
	            e.preventDefault();
	            var nxtIdx = $inp.index(this) + 1;
	            jQuery(":input:text:eq(" + nxtIdx + ")").select();
	            jQuery(":input:text:eq(" + nxtIdx + ")").focus();
	        }
	    });
	});