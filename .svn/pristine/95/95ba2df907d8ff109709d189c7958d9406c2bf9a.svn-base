<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改物箱</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/tipswindown.css" rel="stylesheet" type="text/css" />
    
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/updateBox.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/tipswindown.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
  
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                     <ul class="u-tab clearfix"> 
                        <li class="current"><a>修改物箱</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>
                
                <div id="tab-box">
                   <div class="u-form-wrap" >
                   
                    <!--  -->
                    <div class="demo">
						<ul class="clearfix">
							<li>物箱管理<em></em><i></i></li>
							<li>物箱维护<em></em><i></i></li>
							<li class="current">查看物箱信息<em></em><i></i></li>
						</ul>
					</div>
					
					<fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、查看物箱基本信息页面。<br />
         					</div>
         		 	</fieldset>
                   
                   <form action="<%=path%>/plat/doUpdateBox.do" id="frm" name="frm">
                   <input type="hidden" id="ssId" name="ssId" value="${stor.ssId}" />
                   
                   <fieldset>
         				<legend>基本信息</legend>
                   <table cellpadding="2" class="newTab" cellspacing="1">
					 
					  <tr>
                       
                        <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>物箱组：</td>
					    <td width="200px;">
					    	<select id="groupId" name="groupId" disabled="disabled">
                            	<option value="">请选择</option>
                            	<c:forEach items="${storGroup}" var="g">
                            		<option value="${g.groupId}" <c:if test="${stor.groupId eq g.groupId}">selected="selected"</c:if> >${g.groupAbb}</option>
                            	</c:forEach>
                            </select>
                        </td>
                         <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>物箱代码：</td>
					    <td width="200px;">
                        	<input type="text" maxlength="50" readonly="readonly" id="ssCode" name="ssCode" value="${stor.ssCode}" />
                        </td>
					  </tr>
                    <tr>
                        <td align="right" >数据卡号：</td>
					    <td>
                        	<input type="text" maxlength="11" readonly="readonly" id="dataCard" name="dataCard" value="${stor.dataCard}" />
                        </td>
                         <td align="right" >物箱IP地址：</td>
					    <td>
                        	<input type="text" maxlength="15" readonly="readonly" id="ipAdd" name="ipAdd" value="${stor.ipAdd}" />
                        </td>
					  </tr>                    
                      
                       <tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>物箱类型：</td>
					    <td>
                        	<select id="ssType" name="ssType" disabled="disabled">
                            	<option value="">请选择</option>
                            	<c:forEach items="${storageType}" var="stype">
                            		 <option value="${stype.typeId}" <c:if test="${stor.ssType eq stype.typeId}">selected="selected"</c:if> >${stype.typeName}</option>
                            	</c:forEach>                               
                            </select>
                        </td>
                        
                         <td align="right" ><font style="color: red;">*&nbsp;</font>IP链接类型：</td>
					    <td>
                        	<select id="linkType" name="linkType" disabled="disabled">
                            	<option value="">请选择</option>
                            	<c:forEach items="${ipLinkType}" var="link">
	                                <option value="${link.code}" <c:if test="${stor.linkType eq link.code}">selected="selected"</c:if> >${link.name}</option>	                                
                                </c:forEach>
                            </select>
                        </td>
					  </tr>
					  
					  <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>物箱地址：</td>
						    <td colspan="3">
	                        	<input type="text" maxlength="300" id="boxAddress" readonly="readonly" name="boxAddress" value="${stor.ssAddress}" style="width: 500px;" />
	                        </td>
						  </tr>
						  
						   <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>资产编号：</td>
						    <td colspan="3">
	                        	<input maxlength="50" readonly="readonly"  type="text" value="${stor.assetSn }" id="assetSn" name="assetSn" />
	                        </td>
						  </tr>
					  
				</table>
				</fieldset>
				
				 <fieldset>
         				<legend>扩展信息</legend>
                   <table cellpadding="2" class="newTab" cellspacing="1">
                   	
                   	 <tr>
                        <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>经度：</td>
					    <td width="200px;">
                        	<input type="text" maxlength="10" readonly="readonly" id="longitude" name="longitude" value="${stor.longitude}" />
                        </td>
                         <td width="200px;" align="right" ><font style="color: red;">*&nbsp;</font>纬度：</td>
					    <td width="200px;">
                        	<input type="text"  maxlength="10" readonly="readonly" id="latitude" name="latitude" value="${stor.latitude}" />
                        </td>
					  </tr>
					  
					  
                   	
                   	<tr>
                        <td align="right" ><font style="color: red;">*&nbsp;</font>端口：</td>
					    <td>
                        	<input type="text" maxlength="7"  readonly="readonly" id="port" name="port" value="${stor.port}" />
                        </td>
                        
                        <td align="right" >物箱版本：</td>
					    <td>
                        	<select id="model" name="model" disabled="disabled">
                            	<option value="">请选择</option>
                            	<c:forEach items="${model}" var="m">
	                                <option value="${m.modelId}" <c:if test="${stor.modelId eq m.modelId}">selected="selected"</c:if> >${m.modelAbb}</option>	                                
                                </c:forEach>
                            </select>
                        </td>
                         
					  </tr>
					  <tr>
	                        <td align="right" ><font style="color: red;">*&nbsp;</font>维护员：</td>
					    <td>
                        	<input type="text" readonly="readonly" id="egis" name="egis" value="${user.userAccount}" style="width:120px;" />
                        	<input type="hidden" id="egisId" name="egisId" style="width:70px;" value="${user.userId}" />
                        </td>
                         <td align="right"><font style="color: red;">*&nbsp;</font>百度地图ID：</td>
						    <td>
	                        	<input type="text" id="baiduId" name="baiduId" value="${stor.poiId }" readonly="readonly" maxlength="15" />
	                        </td>
					  </tr>
					  
					  	<tr>
                        <td align="right" >收件快递员组：</td>
					    <td>
                        	${pientCourierGoup}
                        </td>
                         <td align="right" >取件快递员组：</td>
					    <td>
                        	${sendCourierGroup}
                        </td>
					  </tr>
					  
					  
                  	 <tr>
                        <td align="right" colspan="3" ></td>
					    <td>
					    	<button id="do_search" type="button" class="search" onclick="toListBox();">返回</button>
                        </td>
					 </tr>
                  </table>
                 </fieldset>
				</form>
                    </div>
                </div>
            </div>            
        </div>
</body>
</html>