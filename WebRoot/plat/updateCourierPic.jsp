<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加快递员</title>
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
    		if(document.getElementById('snapshotBut').value == '取消' && x_isEmpty('snapshotPic'))
    		{
    			show_err_msg('请选择电子快照');
    			return false;
    		}
    		if(document.getElementById('paper1But').value == '取消' && x_isEmpty('paperworkPic1'))
    		{
    			show_err_msg('请选择证件快照1');
    			return false;
    		}
    		if(document.getElementById('paper2But').value == '取消' && x_isEmpty('paperworkPic2'))
    		{
    			show_err_msg('请选择证件快照2');
    			return false;
    		}
    		
    		return true;
    	}
    	
    	// 切换图片上传修改
    	function changeFile(butObj, oldTdId, newTdId)
    	{
    		var butValue = butObj.value;
    		if(butValue == '修改')
    		{
    			document.getElementById(oldTdId).style.display = 'none';
    			document.getElementById(newTdId).style.display = 'block';
    			butObj.value = '取消';
    		}else if(butValue == '取消')
    		{
    			document.getElementById(oldTdId).style.display = 'block';
    			document.getElementById(newTdId).style.display = 'none';
    			butObj.value = '修改';
    		}
    	}
	</script>
    
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li><a href="<%=path%>/plat/toModifyCourierPage.do?userId=${userId}" style="display: block; height: 100%; width: 100%;">修改快递员信息</a></li>
                        <li class="current"><a>修改照片</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                    <div class="u-form-wrap">
                    
                    <div class="demo" style="width: 600px;">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>快递员管理<em></em><i></i></li>		
							<li>修改快递员信息<em></em><i></i></li>						
							<li class="current">修改照片信息<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、电子快照为个人免冠照片。<br />
         					</div>
         		 	</fieldset>
                    
                    <div style="font-weight: 700; font-size: 28px; font-family: 'Curlz MT';">step 2 :</div>
                    <form action="<%=path %>/plat/doModifyCourierPicInfo.do" enctype="multipart/form-data" method="post" onsubmit="return checkForm(this);">
                    
                    <fieldset>
                    	<legend>修改照片信息</legend>
                  
                    <table cellpadding="2" cellspacing="1" class="newTab">
					  <tr>
                        <td align="right" width="30%">&nbsp;</td>
					    <td width="30%">
                        	<input type="hidden" id="userId" name="userId" value="${userId }"/>
                        </td>
					    <td>
                        	&nbsp;
                        </td>
					  </tr>
					  
					  <tr>
                        <td align="right" >电子快照：</td>
					    <td id="oldSnapshotPicTD">
					    	<input type="hidden" id="snapshotPicId" name="snapshotPicId" value="${cw.snapshotPicId }"/>
					    	<img id="oldSnapshotPic" src="<%=path %>/${cw.snapshotPicPath}" alt="" width="150px" height="100px"/>
					    	<!-- img id="newSnapshotPic" src="" alt="" width="150px" height="100px"/ -->
                        </td>
                        <td id="snapshotPicTD" style="display: none;">
                        	<input type="file" id="snapshotPic" accept="image/*" name="snapshotPic"/>
                        </td>
                        <td><input id="snapshotBut" type="button" value="修改" onclick="changeFile(this, 'oldSnapshotPicTD', 'snapshotPicTD')"/></td>
					  </tr>
                      
                      <tr>
                        <td align="right" >证件快照：</td>
					    <td id="oldPaperworkPic1TD">
					    	<input type="hidden" id="paperworkPic1Id" name="paperworkPic1Id" value="${cw.paperworkPic1Id }"/>
					    	<img id="oldPaperworkPic1" src="<%=path %>/${cw.paperworkPic1Path}" alt="" width="150px" height="100px"/>
					    	<!-- img id="newPaperworkPic1" src="" alt="" width="150px" height="100px"/ -->
                        </td>
                        <td id="paperworkPic1TD" style="display: none;">
                        	<input type="file" id="paperworkPic1" accept="image/*" name="paperworkPic1"/>
                        </td>
                        <td><input id="paper1But" type="button" value="修改" onclick="changeFile(this, 'oldPaperworkPic1TD', 'paperworkPic1TD')"/></td>
					  </tr>
					  
                      <tr>
                        <td align="right" >&nbsp;</td>
					    <td id="oldPaperworkPic2TD">
					    	<input type="hidden" id="paperworkPic2Id" name="paperworkPic2Id" value="${cw.paperworkPic2Id }"/>
					    	<img id="oldPaperworkPic2" src="<%=path %>/${cw.paperworkPic2Path}" alt="" width="150px" height="100px"/>
					    	<!-- img id="newPaperworkPic2" src="" alt="" width="150px" height="100px"/ -->
                        </td>
                        <td id="paperworkPic2TD" style="display: none;">
                        	<input type="file" id="paperworkPic2" accept="image/*" name="paperworkPic2"/>
                        </td>
                        <td><input id="paper2But" type="button" value="修改" onclick="changeFile(this, 'oldPaperworkPic2TD', 'paperworkPic2TD')"/></td>
					  </tr>
					  	
                      <tr>
					    <td colspan="3" style="text-align: center;">
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
<script type="text/javascript">changeCouCom('${cw.excoId}', 0);</script>
</html>
