/**
 *  EasyUI格式化
 *
 * @author gaochangkai
 * @date 2015/03/24
 *
 */
function formatDate (value, rowData, index){
	var rq = value;
	if(rq == null){
		return '';
	}
	return new Date(rq).format("yyyy-MM-dd");
}

function formatTime (value, rowData, index){
	var rq = value;
	if(rq == null){
		return '';
	}
	return new Date(rq).format("yyyy-MM-dd hh:mm:ss");
}


Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth()+1, //month
		"d+" : this.getDate(), //day
		"h+" : this.getHours(), //hour
		"m+" : this.getMinutes(), //minute
		"s+" : this.getSeconds(), //second
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter
		"S" : this.getMilliseconds() //millisecond
	}
	if(/(y+)/.test(format)){
		format = format.replace(RegExp.$1,(this.getFullYear()+"").substr(4- RegExp.$1.length));
	} 
	for(var k in o){
		if(new RegExp("("+ k +")").test(format)){
			format = format.replace(RegExp.$1,RegExp.$1.length==1? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		}
	}
	return format;
};
 