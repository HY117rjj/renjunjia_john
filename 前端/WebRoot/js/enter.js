//ȫ��onkeydown��enterת��tab
 jQuery(function () {
	    jQuery('input:text:first').focus();//ֱ�Ӷ�λ����ǰҳ��ĵ�һ���ı���
	    var $inp = jQuery('input:text');//�����ı���
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