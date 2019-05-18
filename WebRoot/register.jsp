<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录界面</title>
	<jsp:include page="common/head.jsp"/>
</head>
  
  <body>
    <jsp:include page="common/header.jsp"/>
    <div class="container">
	<div class="register">
		<h1>用户注册</h1>
		<%
			String message = (String)request.getAttribute("message");
			String name = (String)request.getAttribute("name");
			String email = (String)request.getAttribute("email");
			if(name==null){
				name="";
			}
			if(email==null){
				email="";
			}
			
			
			
		%>
	  	  <form action="register" method="post">
		   <table style="margin:0 auto; width:450px; height:50px;">
					<%
						if (message != null) {
					%>
					<tr>
						<td colspan="2"><font color="red"><%=message%></font></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td><span>用户名：</span></td>
						<td><input type="text" name="username" value="<%=name%>"></td>
					</tr>
					<tr>
		   			<td><span>密码：</span></td>
		   			<td><input type = "password" name="password" value=""></td>
		   		</tr>
		   		<tr>
		   			<td><span>确认密码：</span></td>
		   			<td><input type = "password" name="passwordT" value=""></td>
		   		</tr>
		   		<tr>
		   			<td><span>邮箱：</span></td>
		   			<td><input type = "text" name="email" value="<%=email%>"></td>
		   		</tr>
		   		<tr>
		   			<td colspan="2" align="center"><div class="col-md-6 login-right"><input type = "submit" value="注册"></div></td>
		   		</tr>
		   </table>
		</form>
		</div>
	</div>
    <jsp:include page="common/footer.jsp"/>
  </body>
</html>
