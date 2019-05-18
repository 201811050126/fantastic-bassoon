<i><%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<title>adminLogin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates">
<link href="css/styleadmin.css" rel="stylesheet" type="text/css">


</head>
<body>

	<!--SIGN UP-->
	<h1>管理员登陆</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png">
		</div>
		<form action="rootlogincheck" method="post">
			<%
				String name = request.getParameter("rootname");
				String message = (String) request.getAttribute("message");
				if (name == null) {
					name = "";
				}
			%>
			<input type="text" class="text" name="rootname" value=<%=name%> >
			<div class="key">
				<input type="password" name="rootpsword" value="">
			</div>
			<div>
				<%

					if (message != null) {
				%>

				<font color="red"><%=message%></font>


				<%
					}
				%>
			</div>

			<div class="signin">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
	<div class="copy-rights">
		<jsp:include page="common/footer.jsp" />
	</div>

</body>
	</html>