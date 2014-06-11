<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-角色分配模块</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function checkModule(moduleId)
    	{
    		var clickObj = $("#moduleId_"+moduleId)[0];
    		if(clickObj.checked)
			{
				// 获取子目录列表
				//$("#info").load("loadInfo");
				var roleId = '${roleId}';
				$.ajax({
					url:'<%=path%>/plat/getSubRoleModuleList.do',
					type:'post',
					data:{roleId:roleId,
						moduleId:moduleId
					},
					success:function(obj){
						$("#subMId_"+moduleId).html(obj);
					}
				});
			}else{
				// 删除子目录列表
				$("#subMId_"+moduleId).html('');
			}
    	}
    </script>
</head>
<body>
      <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                        <li><a href="<%=path %>/plat/toModifyRolePage.do?roleId=${roleId}" style="display: block; height: 100%; width: 100%;">修改用户角色</a></li>
                        <li class="current"><a>角色分配模块</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                	<div class="demo" style="margin-top: 15px;">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>角色管理<em></em><i></i></li>
							<li class="current">角色分配模块<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、系统角色菜单管理，在此页面分配该角色需要显示的菜单项。<br />
         					</div>
         		 	</fieldset>
					
					<fieldset>
						<legend>角色分配模块</legend>
					
                  
                    <form action="<%=path %>/plat/doModifyRoleModule.do" method="post">
                         <table border="0" cellpadding="2" cellspacing="1" style="width:60%;" align="center" class="newTab">
                    <tr>
                    	<input type="hidden" name="roleId" value="${roleId }"/>
                    	<div id="subMId_${moduleId }">
                    		<jsp:include page="/plat/roleModuleTreeList.jsp"></jsp:include>
                    	</div>
                    </tr>
                    <tr>
                    	<td align="center">
                        	<button id="do_search" class="search" type="button" onclick="window.location.href='<%=path %>/plat/toModifyRolePage.do?roleId=${roleId}'">返回</button>&nbsp;&nbsp;
                            <button id="do_search" class="search" type="submit">确定</button>
                        </td>
                    </tr>
                  </table>
                  </form>
                   
                    </fieldset>                  
                </div>
            </div>            
        </div>
        <!-- /.u-main -->
    </div>
    <!-- /.row -->
</body>

</html>
