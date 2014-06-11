<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-添加物箱</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/addBox.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab clearfix">
                    	 <li onclick="toListBox();"><a>物箱列表</a></li>
                        <li  class="current"><a>添加物箱</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
             
                <div id="tab-box">
                    <div class="u-form-wrap">
                  	  <!--  -->
                    <div class="demo">
						<ul class="clearfix">
							<li>物箱管理<em></em><i></i></li>
							<li>物箱维护<em></em><i></i></li>
							<li class="current">添加物箱<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         						2、物箱代码必须与对应的真实的物箱上面的代码一致。<br />
         						3、物箱型号为当前物箱的软件版本号。<br />
         						4、物箱数据卡号与IP地址两个必须录入其中一个。<br />
         						5、必须先选择物箱组才能添加物箱代码。<br />
         						6、物箱代码录入规则【区域>地点>物箱组>物箱】。<br />
         						7、物箱代码 = 物箱区域+地点+物箱组+输入的代码，所以物箱组与物箱代码在此处添加后将不再允许修改。
         					</div>
         		 	</fieldset>
                    
                   <form action="<%=path%>/plat/doAddBox.do" id="frm" name="frm">
                    <fieldset>
         				<legend>基本信息</legend>
	                    <table  cellpadding="2"  cellspacing="1" class="newTab">
	                     <tr>
	                        <td align="right" width="200px;" ><font style="color: red;">*&nbsp;</font>物箱组：</td>
						    <td width="200px;">
						    	<select id="groupId" name="groupId" onchange="getIntactCode(this);">
	                            	<option value="">请选择</option>
	                            	<c:forEach items="${storGroup}" var="g">
	                            		<option value="${g.groupId}">${g.groupAbb}</option>
	                            	</c:forEach>
	                            </select>
	                        </td>
	                        
	                        <td align="right" width="200px;" ><font style="color: red;">*&nbsp;</font>物箱代码：</td>
						    <td width="200px;">
	                        	<input type="text" maxlength="14" disabled="disabled" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);checkSSCode();"  id="ssCode" name="ssCode" />
	                        	
	                        </td>
						  </tr>
	                    <tr>
	                        <td align="right" >数据卡号：</td>
						    <td>
	                        	<input type="text" maxlength="11" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" id="dataCard" name="dataCard" />
	                        </td>
	                         <td align="right" >物箱IP地址：</td>
						    <td>
	                        	<input type="text" maxlength="15" onkeyup="x_IP(this);" onblur="x_IP(this);" id="ipAdd" name="ipAdd" />
	                        	
	                        </td>
						  </tr>
						  
	                       <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>物箱类型：</td>
						    <td>
	                        	<select id="ssType" name="ssType">
	                            	<option value="">请选择</option>
	                            	<c:forEach items="${storageType}" var="stype">
	                            		 <option value="${stype.typeId}">${stype.typeName}</option>
	                            	</c:forEach>                               
	                            </select>
	                        </td>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>IP链接类型：</td>
						    <td>
	                        	<select id="linkType" name="linkType">
	                            	<option value="">请选择</option>
	                            	<c:forEach items="${ipLinkType}" var="link">
		                                <option value="${link.code}">${link.name}</option>	                                
	                                </c:forEach>
	                            </select>
	                        </td>
						  </tr>
						  
						  <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>物箱地址：</td>
						    <td colspan="3">
	                        	<input type="text" maxlength="300" id="boxAddress" name="boxAddress" style="width: 500px;" />
	                        </td>
						  </tr>
						  
						   <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>资产编号：</td>
						    <td colspan="3">
	                        	<input maxlength="50" onkeyup="x_NaNAndLetter(this);" onblur="x_NaNAndLetter(this)" type="text" id="assetSn" name="assetSn" />
	                        </td>
						  </tr>
						  
					</table>
				 </fieldset>
				 
				 <fieldset>
         				<legend>扩展信息</legend>
         				<table  cellpadding="2" cellspacing="1" class="newTab">
         				<tr>
	                        <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>经度：</td>
						    <td width="200px;">
	                        	<input maxlength="10" type="text" onkeyup="x_clear(this);" onblur="x_clear(this);" id="longitude" name="longitude" />
	                        </td>
	                         <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>纬度：</td>
						    <td width="200px;">
	                        	<input maxlength="10" type="text" onkeyup="x_clear(this);" onblur="x_clear(this);" id="latitude" name="latitude" />
	                        </td>
						  </tr>
						 
						  <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>端口：</td>
						    <td>
						    	<input maxlength="7" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);" type="text" id="port" name="port" />
	                        </td>
	                         <td align="right"><font style="color: red;">*&nbsp;</font>百度地图ID：</td>
						    <td >
	                        	<input type="text" id="baiduId" name="baiduId" maxlength="15" onkeyup="x_isNaN(this);" onblur="x_isNaN(this);checkBaiduPid();" />
	                        	<font id="msg" color="red"></font>
	                        </td>
						  </tr>
						  <tr>
	                        
	                          <td align="right" > <font style="color: red;">*&nbsp;</font>维护员：</td>
						    <td >
	                        	<input type="text" readonly="readonly" id="egis" name="egis" style="width:120px;" />
	                        	<input type="hidden" id="egisId" name="egisId" style="width:70px;" />
	                        	<input type="button" class="newButton" style="width:45px;" onclick="showTipsWindown();"  value="添加" />
	                        </td>
	                         <td align="right" >寄件快递员组：</td>
						    <td>
	                        	<input type="text" readonly="readonly" id="sentCouriers" name="sentCouriers" style="width:120px;" />
	                        	<input type="hidden" id="sentCouriersId" name="sentCouriersId" />
	                        	<input type="button" class="newButton" style="width:45px;" onclick="showCouries('1');"  value="添加" />
	                        </td>
						  </tr>
						  
						  <tr>
	                       
	                         <td align="right" >取件快递员组：</td>
						    <td colspan="3">
	                        	<input type="text" readonly="readonly" id="courierPickups" name="courierPickups" style="width:120px;" />
	                        	<input type="hidden" id="courierPickupsId" name="courierPickupsId" />
	                        	<input type="button" class="newButton" style="width:45px;" onclick="showCouries('2');"  value="添加" />	                       	
	                        </td>
						  </tr>
						 
         				 <tr>
	                        <td align="right" colspan="3" ></td>
						    <td>
	                        	<button id="do_search" type="button" class="search" onclick="checkAndSubmit();">添加</button>
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
