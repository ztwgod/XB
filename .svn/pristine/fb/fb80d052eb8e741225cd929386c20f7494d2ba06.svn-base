function showDailog(context,width,height,marginLeft){
      $(".form").html(context);
      $("#BgDiv").css({ display:"block",height:$(document).height()});
      var yscroll=document.documentElement.scrollTop;
      $("#DialogDiv").css("top","100px");
      $("#DialogDiv").css("display","block");
      
      $("#DialogDiv").css("width",width+"px");
      $("#DialogDiv").css("height",height+"px");
      $("#DialogDiv").css("margin-left",marginLeft+"px");
      
      
      document.documentElement.scrollTop=0;
	}
	
function closeDailog(){
	 $("#BgDiv").css("display","none");
     $("#DialogDiv").css("display","none");
}

 
 
 $(document).ready(function(){
	 //关闭
	 $("#btnClose").click(function(){
		 closeDailog();
	 });
 });