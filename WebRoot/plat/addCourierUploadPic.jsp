<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.com.xb.util.StringUtil"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加快递员快照</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/jquery.pager.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function checkForm(formObj)
    	{
    		show_loading();
    		if(x_isEmpty('snapshotPic'))
    		{
    			show_err_msg('请选择电子快照');
    			return false;
    		}
    		if(x_isEmpty('paperworkPic1'))
    		{
    			show_err_msg('请选择证件快照1');
    			return false;
    		}
    		if(x_isEmpty('paperworkPic2'))
    		{
    			show_err_msg('请选择证件快照2');
    			return false;
    		}
    		
    		return true;
    	}
    	
	</script>
    
</head>
<%
	String userId = StringUtil.formatStringTrimToNull(request.getParameter("userId"));
	userId = userId == null ? StringUtil.formatStringTrimToNull(request.getAttribute("userId")) : userId;
 %>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li><a href="<%=path%>/plat/getCourierList.do" style="display: block; height: 100%; width: 100%;">快递员列表</a></li>
                        <li class="current"><a>添加快递员</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap" style="padding: 50px;">
                    
                    <div class="demo" style="width: 600px;">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员管理<em></em><i></i></li>		
							<li>添加快递员信息<em></em><i></i></li>						
							<li class="current">上传快递员照片<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、电子快照为个人免冠照片。<br />
         					</div>
         		 	</fieldset>
                    
                    <div style="font-weight: 700; font-size: 28px; font-family: 'Curlz MT';">step 2 :</div>
                    <form action="<%=path %>/plat/uploadCourierPic.do" enctype="multipart/form-data" method="post" onsubmit="return checkForm(this);">
                   
                   <fieldset>
                   		<legend>上传快递员照片</legend>
                  
                    <table border="0" cellpadding="2" cellspacing="1" style="width:80%" align="center" class="newTab">
					
					  <tr>
                        <td align="right">&nbsp;</td>
					    <td>
                        	<input type="hidden" id="userId" name="userId" value="<%=userId %>"/>
                        </td>
                        
                        <td align="right">&nbsp;</td>
					    <td>
                        	&nbsp;
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right" >电子快照：</td>
					    <td colspan="3">
                        	<input type="file" id="snapshotPic" accept="image/*" name="snapshotPic"/>
                        </td>
					  </tr>
                      
                      <tr>
                        <td align="right" >证件快照：</td>
					    <td colspan="3">
                        	<input type="file" id="paperworkPic1" accept="image/*" name="paperworkPic1"/>
                        </td>
					  </tr>
                      <tr>
                        <td align="right" >&nbsp;</td>
					    <td colspan="3">
                        	<input type="file" id="paperworkPic2" accept="image/*" name="paperworkPic2"/>
                        </td>
					  </tr>
					  			  					
                      <tr>
					    <td colspan="4" style="text-align: center;">
                        	<button type="submit" id="do_search" class="search">完成</button>
                        </td>
					  </tr>                
				</table>
				 </fieldset>
				</form>
                    </div>
                </div>
            </div>
           
        </div>
        <!-- /.u-main -->
    <!-- /.row -->
</body>

</html>
