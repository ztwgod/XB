<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>讯宝-平台登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>		
	<script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.form.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script type="text/javascript">
		//支持Enter键登录
		document.onkeydown = function(e){
			if(!e) e = window.event;
			if((e.keyCode || e.which) == 13){
				var obtnLogin=document.getElementById("submit_btn")
				obtnLogin.focus();
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				if($('#TxtUserName').val() == ''){
					show_err_msg('账号还没填呢！');	
					$('#TxtUserName').focus();
				}else if($('#TxtPassword').val() == ''){
					show_err_msg('密码还没填呢！');
					$('#TxtPassword').focus();
				}else if($('#TxtYZM').val() == ''){					
					show_err_msg('验证码还没填呢！');
					$('#TxtYZM').focus();
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					//show_msg('验证通过！','/');
					document.getElementById("login_form").submit();
				}
			});
		});

    	function changeImage() {
    		var root = document.getElementById("_root").value;
    		var obj = document.getElementById("img");
    		var timenow = new Date().getTime();       
    		obj.src = root+"/plat/image.jsp?d=" + timenow;
    	}

		//防止在iframe中打开登陆页面
    	if (window != top) 
    		top.location.href = location.href;
    	
    </script>
    <style type="text/css">
		* html,* html body{background-image:url(about:blank);background-attachment:fixed;}
		html{color:#000;background-color:#F2F2F2;}
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td{margin:0;padding:0;}
		table {border-collapse:collapse;border-spacing:0;}
		img,button,input {vertical-align:middle;border:none;}
		label{font-size:12px;color:#666;cursor:pointer;}
		a,span{color:#666;font-size:12px;text-decoration:none;}
		a:hover{text-decoration:underline;}
		address,caption,cite,code,dfn,em,strong,th,var{font-style:normal;font-weight:normal;}
		ol,ul,li{list-style:none;list-style-type: none;}
		h1,h2,h3,h4,h5,h6{font-size:100%;overflow:hidden;}
		
    	header {width:660px;margin:0 auto;font-size:28px;font-weight:bold;margin-top:20px;color:#ccc;text-shadow:1px 1px 1px #fff;font-family: 'revolt',georgia,'Microsoft yahei';}
		.content {width:350px;margin:90px auto auto;padding:30px 40px;border:2px solid #ccc;border-radius:10px;box-shadow:0 0 30px #ccc;}
		.ipt {border:1px solid #ddd;padding:10px 5px;width: 240px;outline:none;border-radius:3px;background-color:#fff;font-family: 'revolt',georgia,'Microsoft yahei';}
		.ipt:focus {background-color:#fefefe;box-shadow:0 0 3px #aaa;}
		.thead {font-weight:bold;font-size:20px;padding-bottom:20px!important;text-shadow:1px 1px 1px #fff;}
		.content th {color:#666;font-size:12px;font-weight:bold;text-shadow: 1px 1px 1px #fff;}
		.content td {padding:5px 0;}
		#submit_btn {background-color:#4797ED;border:none;border-radius:10px;box-shadow:0 0 3px #aaa;width:98px;height:41px;line-height:41px;color:#fff;font-size:18px;font-weight:bold;cursor:pointer;margin-right:20px;display:block;outline:none;text-shadow:0 1px 1px #777;float:left;}
		#submit_btn:hover {background-color:#d8d8d8;color:#666;text-shadow:1px 1px 1px #fff;}
		.line {float:left;margin-top:10px;}
		.pd15 {padding-top:15px!important;}
		.red {color:red;}
		.tooltip {cursor:help;position:relative;text-shadow:2px 2px 2px #999;}
		.tooltip span {font: normal 14px verdana;color: #fff;visibility: hidden;position: absolute;bottom: 30px;left: 50%;z-index: 20000;width: 250px;margin-left: -127px;padding: 10px;border: 2px solid #422A20;background: -moz-linear-gradient(top, #B4784C 0%, #422A20 100%);
		background: -webkit-gradient(linear, center top, center bottom, from(#B4784C), to(#422A20));background: -o-gradient(top, #B4784C, #422A20); border-bottom: solid 1px #422A20;-moz-border-radius: 4px;border-radius: 4px;-moz-box-shadow: 0 0 5px 5px #B1A59D;-webkit-box-shadow: 0 0 5px 5px #B1A59D;box-shadow: 0 0 5px 5px #B1A59D;}
		.tooltip:hover span {visibility: visible;} 
    </style>
</head>
<body>
	<div style="margin:auto 0;"><header> &gt;&gt; 讯宝-平台子系统登陆</header></div>
	<input type="hidden" id="_root" name="_root" value="<%=path%>" />
 	<div class="content">
    	<form action="<%=path%>/plat/doPlatLogin.do" method="post" id="login_form" name="login_form">
    	<table width="100%">
        	<thead>
            	<td colspan="2" class="thead">后台管理员登录</td>
            </thead>
            <tbody>
                <tr>
                  <th><em class="red">*</em> 用户名：</th>
                  <td><input type="text" id="TxtUserName" name="TxtUserName" value="${user.userAccount}" class="ipt"></td>
                </tr>
                <tr>
                  <th><em class="red">*</em> 密码：</th>
                  <td><input type="password" name="TxtPassword" id ="TxtPassword" class="ipt"></td>
                </tr>
				 <tr>
                  <th><em class="red">*</em>验证码：</th>
                  <td>
                  	<input type="text" name="TxtYZM" id="TxtYZM" class="ipt" maxlength="4" style="width:80px;">
                  	<span style="margin-left: 30px;padding-top: 5px;"><img  name="img" id="img" border="0" alt="校验码" src="<%=path%>/plat/image.jsp"/></span>
					<span class="thc" style="font-size: 12px;text-decoration: none;cursor: pointer;color: blue;" onclick="changeImage();" title="点击获取校验码">看不清楚?</span>
                  </td>
                </tr>
                
                <tr>
                	<td></td>
                	<td><font color="orange" style="font-size: 12px;">${message}</font></td>
                </tr>
                
                <tr>
                  <th class="pd15"></th>
                  <td class="pd15">
                  	<button id="submit_btn" type="button">登录</button>
                  </td>
                </tr>
                
            </tbody>
        </table>
        </form>
    </div>
</body>
</html>
