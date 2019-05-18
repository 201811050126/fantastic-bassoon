<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adv.jsp' starting page</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	

  </head>
  
  <body>
  <div class="panel admin-panel">
  <div class="panel-head"><strong></strong></div>
  <div class="body-content">
  <center>
     <img src="admin/images/welcome.PNG">
  </center>

   
  </div>
</div>
   
   
   
  </body>
</html>
