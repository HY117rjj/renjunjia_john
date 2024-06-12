var $getObject2 = function (id) {

    return "string" == typeof id ? document.getElementById(id) : id;

}

var BindICD = function(object, fun) {

    return function() {

        return fun.apply(object, arguments);

    }

}

function AutoCompleteICD(icd_obj,icd_obj2,icd_autoObj,icd_value_arr){

    this.icd_obj=$getObject2(icd_obj);        //输入框
    
    this.icd_obj2=$getObject2(icd_obj2);       //输入框 第二接收框 " "分割
    
    this.icd_autoObj=$getObject2(icd_autoObj);//DIV的根节点

    this.icd_value_arr=icd_value_arr;        //不要包含重复值

    this.icd_index=-1;          //当前选中的DIV的索引

    this.icd_search_value="";   //保存当前搜索的字符

}

AutoCompleteICD.prototype={

    //初始化DIV的位置

    init: function(){
    	
        this.icd_autoObj.style.left = this.icd_obj.offsetLeft + "px";

        this.icd_autoObj.style.top  = this.icd_obj.offsetTop + this.icd_obj.offsetHeight + "px";

        this.icd_autoObj.style.width= this.icd_obj.offsetWidth - 0 + "px";//减去边框的长度2px Amazeui样式没有边框

    },

    //删除自动完成需要的所有DIV

    deleteDIV: function(){

        while(this.icd_autoObj.hasChildNodes()){

            this.icd_autoObj.removeChild(this.icd_autoObj.firstChild);

        }

        this.icd_autoObj.className="auto_hidden";

    },

    //设置值

    setValue: function(_this){

        return function(){

//            _this.icd_obj.value=this.seq;
            
            var str = this.seq.split(" ");
            
            if(_this.icd_obj.value.length>=3){
            	_this.icd_obj.value=_this.icd_obj.value + "," + str[0];
            	_this.icd_obj2.value=_this.icd_obj2.value + "," + str[1];
            }else{
            	_this.icd_obj.value=str[0];
            	_this.icd_obj2.value=str[1];
            }
            	
            _this.icd_autoObj.className="auto_hidden";

        }

    },

    //模拟鼠标移动至DIV时，DIV高亮

    autoOnmouseover: function(_this,_div_index){

        return function(){

            _this.icd_index=_div_index;

            var length = _this.icd_autoObj.children.length;

            for(var j=0;j<length;j++){

                if(j!=_this.icd_index ){

                    _this.icd_autoObj.childNodes[j].className='auto_onmouseout';

                }else{

                    _this.icd_autoObj.childNodes[j].className='auto_onmouseover';

                }

            }

        }

    },

    //更改classname

    changeClassname: function(length){

        for(var i=0;i<length;i++){

            if(i!=this.icd_index ){

                this.icd_autoObj.childNodes[i].className='auto_onmouseout';

            }else{

                this.icd_autoObj.childNodes[i].className='auto_onmouseover';

                var str = this.icd_autoObj.childNodes[i].seq.split(" ");
                
                if(this.icd_obj.value.length>=3){
                	this.icd_obj.value=this.icd_obj.value + "," + str[0];
                	this.icd_obj2.value=this.icd_obj2.value + "," + str[1];
                }else{
                	this.icd_obj.value=str[0];
                	this.icd_obj2.value=str[1];
                }
                
            }

        }

    }

    ,

    //响应键盘

    pressKey: function(event){

        var length = this.icd_autoObj.children.length;

        //光标键"↓"

        if(event.keyCode==40){

            ++this.icd_index;

            if(this.icd_index>length){

                this.icd_index=0;

            }else if(this.icd_index==length){

            	if(this.icd_obj.value.length>=3){
                	this.icd_obj.value=this.icd_obj.value + "," + this.icd_search_value;
                }else{
                	this.icd_obj.value=this.icd_search_value;;
                }

            }

            this.changeClassname(length);

        }

        //光标键"↑"

        else if(event.keyCode==38){

            this.icd_index--;

            if(this.icd_index<-1){

                this.icd_index=length - 1;

            }else if(this.icd_index==-1){

            	if(this.icd_obj.value.length>=3){
                	this.icd_obj.value=this.icd_obj.value + "," + this.icd_search_value;
                }else{
                	this.icd_obj.value=this.icd_search_value;;
                }

            }

            this.changeClassname(length);

        }

        //回车键

        else if(event.keyCode==13){

            this.icd_autoObj.className="auto_hidden";

            this.icd_index=-1;

        }else{

            this.icd_index=-1;

        }

    },

    //程序入口

    start: function(event){

        if(event.keyCode!=13&&event.keyCode!=38&&event.keyCode!=40){

            this.init();

            this.deleteDIV();
            
            if(this.icd_obj.value.indexOf(",")){
            	this.icd_search_value=this.icd_obj.value.split(",")[this.icd_obj.value.split(",").length-1];
            }else{
            	this.icd_search_value=this.icd_obj.value;
            }

            var valueArr=this.icd_value_arr;

            valueArr.sort();

            if(this.icd_obj.value.replace(/(^\s*)|(\s*$)/g,'')==""){ return; }//值为空，退出

//          try{ var reg = new RegExp("(" + this.icd_obj.value + ")","i");}
            try{ var reg = new RegExp("(" + this.icd_search_value + ")","i");}

            catch (e){ return; }

            var div_index=0;//记录创建的DIV的索引

            for(var i=0;i<valueArr.length;i++){

                if(reg.test(valueArr[i])){

                    var div = document.createElement("div");

                    div.className="auto_onmouseout";

                    div.seq=valueArr[i];

                    div.onclick=this.setValue(this);

                    div.onmouseover=this.autoOnmouseover(this,div_index);

                    div.innerHTML=valueArr[i].replace(reg,"<strong>$1</strong>");//搜索到的字符粗体显示

                    this.icd_autoObj.appendChild(div);

                    this.icd_autoObj.className="auto_show";

                    div_index++;

                    if(div_index == 11){
                    	break;
                    }                    
                }

            }

        }

        this.pressKey(event);

        window.onresize=BindICD(this,function(){this.init();});

    }

}

