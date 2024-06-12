$(function(){
	 var upload = $('#event').AmazeuiUpload({
//     url: 'http://localhost:8080/edu/courseware/uploading.do',
       url: 'http://localhost:8080/edu/js/AmazeUIUpload-master/nginx/html/demo.json',
       downloadUrl:'',
       maxfiles: 1 , // 单次上传的数量
       maxfilesize: 20,  // 单个文件允许的大小 (M)
       multithreading: false, // true为同时上传false为队列上传
       useDefTemplate: true // 开启默认模版
    });

  	$('#callBack').on("click",function(){
        var arr = upload.selectResult();
        alert(arr);
  	});


});
