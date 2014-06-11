<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>讯宝-修改卡片</title>
    <link href="<%=path%>/css/plat/css.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/css/plat/pager.css" rel="stylesheet" type="text/css" />   
     
    <script src="<%=path%>/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=path%>/js/plat/menu.js" type="text/javascript"></script>
    <script src="<%=path%>/js/x_tools.js" type="text/javascript"></script>    
    <script src="<%=path%>/js/plat/updateCard.js" type="text/javascript"></script>
    <script src="<%=path%>/js/calendar.js" type="text/javascript"></script>
    <script src="<%=path%>/js/tooltips.js" type="text/javascript"></script>
</head>
<body>
        <div class="u-main">
            <div class="ucenter-info mt10">
                <div class="u-tab-wrap">
                    <ul class="u-tab">
                        <li class="current"><a>修改绑定卡片</a></li>
                    </ul>
                    <!-- /.u-tab -->
                </div>                
                <div id="tab-box">
                <div class="u-form-wrap"> 
                
                <div class="demo">
						<ul class="clearfix">
							<li>用户管理<em></em><i></i></li>
							<li>卡片管理<em></em><i></i></li>
							<li class="current">修改绑定卡片<em></em><i></i></li>
						</ul>
					</div> 
                  
                  <fieldset>
         				<legend>页面说明</legend>
         					<div class="smDiv">
         						1、所有带<font style="color: red;">&nbsp;*&nbsp;</font>的为必录项。<br />
         					</div>
         		 	</fieldset>	
                  
              	<form action="<%=path%>/plat/doUpdateCard.do" id="frm" name="frm" method="post">
              	<fieldset>
              		<legend>修改绑定卡片</legend>
              	
					<table border="0" cellpadding="2" cellspacing="1" style="width:80%" align="center" class="newTab">						
					  <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>用户：</td>
					    <td>
                        	${userAccount}
                        	<input type="hidden" id="cardId" name="cardId" value="${card.cardId}" />
                        </td>					  	
					  </tr>	
					  							  
					   <tr>
                        <td align="right"><font style="color: red;">*&nbsp;</font>有效期：</td>
					    <td>
					    	<input type="text" id="cardExpirationDate" name="cardExpirationDate" value="<fmt:formatDate value="${card.expirationDate}" pattern="yyyy-MM-dd"/>" style="border:1px solid #999;" onclick="new Calendar().show(this);" readonly="readonly" />                           
                        </td>            
					  </tr>
					  
					  <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>类型：</td>
					    <td>
                        	<select id="type" name="type">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${cardTypeList}" var="id">
                        			<option value="${id.code}" <c:if test="${card.cardType==id.code}">selected="selected"</c:if> >${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>					  	
					  </tr>
					  
					   <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>卡片状态：</td>
					    <td>
                        	<select id="cardStatus" name="cardStatus">
                        		<option value="" selected="selected">请选择</option>
                        		<c:forEach items="${cardStatusList}" var="id">
                        			<option value="${id.code}" <c:if test="${card.cardStatus==id.code}">selected="selected"</c:if> >${id.name}</option>
                        		</c:forEach>
                        	</select>
                        </td>					  	
					  </tr>
					  
					  <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>卡片代码：</td>
					    <td>
                        	<input type="text" id="cardCode" name="cardCode" maxlength="20" value="${card.cardCode}"  />
                        </td>					  	
					  </tr>
					   <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>卡片密码：</td>
					    <td>
                        	<input type="password" id="cardPassword" name="cardPassword" maxlength="20" value="${card.cardPwd }"  />
                        </td>					  	
					  </tr>
					  
					   <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>确认卡片密码：</td>
					    <td>
                        	<input type="password" id="scardPassword" name="scardPassword" maxlength="20" value="${card.cardPwd }" />
                        </td>					  	
					  </tr>
					  
					    <tr>
					  	<td align="right"><font style="color: red;">*&nbsp;</font>颁发机构：</td>
					    <td>
                        	<select id="issuedAgency" name="issuedAgency" >
                        		<option value="">请选择</option>                        		
                        		<c:forEach items="${issuredAgency}" var="s">
                        			<option value="${s.agencyId}" <c:if test="${card.issuedAgency==s.agencyId}">selected="selected"</c:if> >${s.agencyName}</option>
                        		</c:forEach>
                        	</select>
                        </td>					  	
					  </tr>
					  			  					
                      <tr>
					    <td colspan="2" align="center">
                        	<button type="button" id="do_search" class="search" onclick="toListCard();">返回</button>
                      		<button type="button" id="do_search" class="search" onclick="checkAndSubmit();">修改</button>
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
