<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.com.xb.domain.base.ResponseText"%>
<%@page import="cn.com.xb.http.comet.TomcatHttpServlet"%>
<%@page import="cn.com.xb.util.Global"%>
<%
	String tranNo = request.getParameter("tranNo");	
	TomcatHttpServlet.removeResultMaps(tranNo);
	//System.out.println("tranNo=================>"+tranNo);
	//TomcatHttpServlet.put(resText);
	response.sendRedirect("t.jsp");
%>
