var msgdsq;
//错误时：提示调用方法
function show_err_msg(msg){
	 jQuery('.msg_bg').html('');
	 clearTimeout(msgdsq);
	 jQuery('body').append('<div class="sub_err" style="position:absolute;top:60px;left:0;width:500px;z-index:999999;"></div>');
	 var errhtml='<div style="padding:8px 0px;border:1px solid #ff0000;width:100%;margin:0 auto;background-color:#fff;color:#B90802;border:3px #ff0000 solid;text-align:center;font-size:16px;font-family:微软雅黑;"><img style="margin-right:10px;" src="../images/error.png">';
	 var errhtmlfoot='</div>';	 
	 //jQuery('.msg_bg').height(jQuery(document).height());
	 //body.offsetHeight 
	 jQuery('.msg_bg').height(document.body.clientHeight);
	 jQuery('.sub_err').html(errhtml+msg+errhtmlfoot);
	 var left=(jQuery(document).width()-500)/2;
	 jQuery('.sub_err').css({'left':left+'px'});
	 var scroll_height= window.screen.availHeight/4; //屏幕可用工作区高度 availHeight
	 
	 jQuery('.sub_err').animate({'top': scroll_height+120},300);
	 msgdsq=setTimeout(function(){				     
		 jQuery('.sub_err').animate({'top': scroll_height+80},300);
		 setTimeout(function(){
			 jQuery('.msg_bg').remove();
			 jQuery('.sub_err').remove();
		 },800);
	 }, "1200"); 
}

//正确时：提示调用方法
function show_msg(msg,frmId){	
     jQuery('.msg_bg').html('');
	 clearTimeout(msgdsq);
	 jQuery('body').append('<div class="sub_err" style="position:absolute;top:60px;left:0;width:500px;z-index:999999;"></div>');
	 var htmltop='<div style="padding:8px 0px;border:1px solid #090;width:100%;margin:0 auto;background-color:#FFF2F8;color:#090;border:3px #090 solid;;text-align:center;font-size:16px;"><img style="margin-right:10px;" src="../images/success.png">';
	 var htmlfoot='</div>';
	 jQuery('.msg_bg').height(jQuery(document).height());
	 var left=(jQuery(document).width()-500)/2;
	 jQuery('.sub_err').css({'left':left+'px'});
	 jQuery('.sub_err').html(htmltop+msg+htmlfoot);
	 var scroll_height=jQuery(document).scrollTop(); 
	 jQuery('.sub_err').animate({'top': scroll_height+120},500);
	 msgdsq=setTimeout(function(){	    
		   jQuery('.sub_err').animate({'top': scroll_height+80},500);
		   setTimeout(function(){
			   jQuery('.msg_bg').remove();
			   jQuery('.sub_err').remove();
			   if(url!=''){
				   jQuery("#"+frmId).submit();
			   }	   
		   },800);
	 }, "1200");  
}

//显示加载动画
function show_loading(){
	/*var str='<div class="msg_bg" style="background:#000;opacity:0.5;filter:alpha(opacity=50);z-index:99998;width:100%;position:absolute;left:0;top:0"></div>';
	str+='<div class="msg_bg" style="z-index:99999;width:100%;position:absolute;left:0;top:0;text-align:center;"><img src="../images/loading.gif" alt="" class="loading"></div>'
	jQuery('body').append(str);
	var scroll_height=jQuery(document).scrollTop();
	jQuery('.msg_bg').height(jQuery(document).height());
	jQuery('.loading').css('margin-top',scroll_height+240);*/
}

//显示加载动画
function close_loading(){
	 jQuery('.msg_bg').html('');
	 jQuery('.msg_bg').remove();
	 clearTimeout(msgdsq);	
}
