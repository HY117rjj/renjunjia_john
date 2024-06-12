//trim methord
String.prototype.trim = function(){
return this.replace(/(^\s*)|(\s*$)/g, "");
}

//main methord
function validator_rule(obj,rule){
	var ruler=new RegExp(rule);
	var result=ruler.test(obj);
	ruler=null;
	return result;
}

//check string is empty or not
function empty(obj){
  return !validator_rule(obj,"\\S+");
}

//check mobile phone number
function mobile(obj){
	return validator_rule(obj,"[0]{0,1}[1-9]{1}\d{10}");
} 

//check common phone number
function phone(obj){
	return validator_rule(obj,"(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}");
} 

//check email
function email(obj){
    return validator_rule(obj,"\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*");
}    