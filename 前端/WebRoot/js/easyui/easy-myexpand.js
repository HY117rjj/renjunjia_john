Number.prototype.toFixed = function(s)
	{
		var changenum;
		if(this>=0){
			changenum=(parseInt(this * Math.pow( 10, s ) + 0.5)/ Math.pow( 10, s )).toString();
			index=changenum.indexOf(".");
			if(index<0&&s>0){
				changenum=changenum+".";
			for(i=0;i<s;i++){
				changenum=changenum+"0";
			}		   
			}else {
			index=changenum.length-index;
			for(i=0;i<(s-index)+1;i++){
				 changenum=changenum+"0";
			   }	  
			}
		}else if(this<0){
			var t = this * (-1);
			changenum=((parseInt(t * Math.pow( 10, s ) + 0.5)/ Math.pow( 10, s ))*(-1)).toString();
			index=changenum.indexOf(".");
			if(index<0&&s>0){
				changenum=changenum+".";
			for(i=0;i<s;i++){
				changenum=changenum+"0";
			}		   
			}else {
			index=changenum.length-index;
			for(i=0;i<(s-index)+1;i++){
				 changenum=changenum+"0";
			   }	  
			}
		}
			  
	    return  changenum;
	}
	
$.extend($.fn.validatebox.defaults.rules, {  
    minLength: {  
        validator: function(value, param){  
            return value.length >= param[0];  
        },  
        message: '输入长度不得小于 {0}'  
    },
    maxLength:{
        validator: function(value, param){  
            return value.length <= param[0];  
        },  
        message: '输入长度不得大于 {0}'      
    },
    validCombo:{
    	validator:function(value,param){
    		var val = $("#"+param[0]).combo("getValue");
    		var text = $("#"+param[0]).combo("getText");
    		return val!=text;
    	},
    	message:'不是有效的下拉列表值，请重新选择'
    },
    yxqError:{
    	validator:function(value,param){
		    return RQcheck(value);
    	},
    	message:'有效期不合法或格式不对，<br/>请按照yyyy-mm-dd的格式输入！'
    },

    checkCgl:{
    	validator:function(value,param,sffs){
		    return checkCgsl(value);
    	},
    	message:'采购数量不能小于0！'
    },
    checkPdl:{
    	validator:function(value,param,sffs){
		    return checkCgsl(value);
    	},
    	message:'盘点数量不能小于0！'
    }
}); 

// msg
function rightBottom(message) {
	$.messager.show({
				title : '提示信息',
				msg : message,
				showType : 'show'
			});
}


function checkCgsl(value){
   if(parseFloat(value)<0){
	   return false;
	}else{
		return true;
	}	
}

function checksl(sl,param){
	if(parseFloat(sl)<parseFloat(param)){
		return false;
		
	}else{
		return true;
	}
}

function getPageArea() {
	if (document.compatMode == 'BackCompat') {
		return {
			width : Math.max(document.body.scrollWidth,
					document.body.clientWidth),
			height : Math.max(document.body.scrollHeight,
					document.body.clientHeight)
		}
	} else {
		return {
			width : Math.max(document.documentElement.scrollWidth,
					document.documentElement.clientWidth),
			height : Math.max(document.documentElement.scrollHeight,
					document.documentElement.clientHeight)
		}
	}
}

$.extend($.fn.datagrid.defaults.editors, {
    combogrid: {
        init: function (container, options) {
            var input = $('<input type="text" class="datagrid-editable-input">').appendTo(container);
            input.combogrid(options);
            return input;
        },
        destroy: function (target) {
            $(target).combogrid('destroy');
        },
        getValue: function (target) {
            return $(target).combogrid('getValue');
        },
        setValue: function (target, value) {
            $(target).combogrid('setValue', value);
        },
        resize: function (target, width) {
            $(target).combogrid('resize', width);
        }
    }
});

var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 

function isCardID(sId){ 
	var iSum=0 ;
	var info="" ;
	if(!/^\d{17}(\d|x)$/i.test(sId)) return "你输入的身份证长度或格式错误"; 
	sId=sId.replace(/x$/i,"a"); 
	if(aCity[parseInt(sId.substr(0,2))]==null) return "你的身份证地区非法"; 
	sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2)); 
	var d=new Date(sBirthday.replace(/-/g,"/")) ;
	if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return "身份证上的出生日期非法"; 
	for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
	if(iSum%11!=1) return "你输入的身份证号非法"; 
	return true;//aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女") 
} 


$.extend($.fn.validatebox.defaults.rules, {   
    idcared: {   
        validator: function(value,param){  
    		var flag = isCardID(value);
            return flag==true?true:false;  
        },   
        message: '不是有效的身份证号码'  
    },
	minLength: {
	    validator: function (value, param) {
	        return value.length >= param[0];
	    },
	    message: '请输入至少（2）个字符.'
	},
	length: { validator: function (value, param) {
	    var len = $.trim(value).length;
	    return len >= param[0] && len <= param[1];
	},
	    message: "输入内容长度必须介于{0}和{1}之间."
	},
	phone: {// 验证电话号码
	    validator: function (value) {
	        return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
	    },
	    message: '格式不正确,请使用下面格式:020-88888888'
	},
	mobile: {// 验证手机号码
	    validator: function (value) {
	        return /^(13|15|18)\d{9}$/i.test(value);
	    },
	    message: '手机号码格式不正确'
	},
	intOrFloat: {// 验证整数或小数
	    validator: function (value) {
	        return /^\d+(\.\d+)?$/i.test(value);
	    },
	    message: '请输入数字，并确保格式正确'
	},
	currency: {// 验证货币
	    validator: function (value) {
	        return /^\d+(\.\d+)?$/i.test(value);
	    },
	    message: '货币格式不正确'
	},
	qq: {// 验证QQ,从10000开始
	    validator: function (value) {
	        return /^[1-9]\d{4,9}$/i.test(value);
	    },
	    message: 'QQ号码格式不正确'
	},
	integer: {// 验证整数 可正负数
	    validator: function (value) {
	        //return /^[+]?[1-9]+\d*$/i.test(value);
	
	        return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
	    },
	    message: '请输入整数'
	},
	age: {// 验证年龄
	    validator: function (value) {
	        return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
	    },
	    message: '年龄必须是0到120之间的整数'
	},
	
	chinese: {// 验证中文
	    validator: function (value) {
	        return /^[\Α-\￥]+$/i.test(value);
	    },
	    message: '请输入中文'
	},
	english: {// 验证英语
	    validator: function (value) {
	        return /^[A-Za-z]+$/i.test(value);
	    },
	    message: '请输入英文'
	},
	unnormal: {// 验证是否包含空格和非法字符
	    validator: function (value) {
	        return /.+/i.test(value);
	    },
	    message: '输入值不能为空和包含其他非法字符'
	},
	username: {// 验证用户名
	    validator: function (value) {
	        return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
	    },
	    message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
	},
	faxno: {// 验证传真
	    validator: function (value) {
	        //            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value);
	        return /^((\d2,3)|(\d{3}\-))?(0\d2,3|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
	    },
	    message: '传真号码不正确'
	},
	zip: {// 验证邮政编码
	    validator: function (value) {
	        return /^[1-9]\d{5}$/i.test(value);
	    },
	    message: '邮政编码格式不正确'
	},
	ip: {// 验证IP地址
	    validator: function (value) {
	        return /d+.d+.d+.d+/i.test(value);
	    },
	    message: 'IP地址格式不正确'
	},
	name: {// 验证姓名，可以是中文或英文
	    validator: function (value) {
	        return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
	    },
	    message: '请输入姓名'
	},
	date: {// 验证姓名，可以是中文或英文
	    validator: function (value) {
	        //格式yyyy-MM-dd或yyyy-M-d
	        return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
	    },
	    message: '清输入合适的日期格式'
	},
	msn: {
	    validator: function (value) {
	        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
	    },
	    message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
	},
	same: {
	    validator: function (value, param) {
	        if ($("#" + param[0]).val() != "" && value != "") {
	            return $("#" + param[0]).val() == value;
	        } else {
	            return true;
	        }
	    },
	    message: '两次输入的密码不一致！'
	}
});


