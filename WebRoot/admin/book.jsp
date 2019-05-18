<%@page import="cn.sdcet.shop.domain.Pinglun"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>留言管理页面</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>


</head>

<body>
	<jsp:useBean id="dao3" class="cn.sdcet.shop.dao.jdbc.pinglunDaoJDBCImpl" scope="session"></jsp:useBean>
	 <jsp:useBean id="dao2" class="cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl" scope="session"></jsp:useBean>
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 留言管理</strong>
			</div>
			<div class="padding border-bottom">
<!-- 				<ul class="search"> -->
<!-- 					<li> -->
<!-- 						<button type="button" class="button border-green" id="checkall"> -->
<!-- 							<span class="icon-check"></span> 全选 -->
<!-- 						</button> -->
<!-- 						<button type="submit" class="button border-red" onclick="return DelSelect()> -->
<!-- 							<span class="icon-trash-o"></span> 批量删除 -->
<!-- 						</button> -->
<!-- 					</li> -->
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>用户名</th>
					<th>邮箱</th>
					<th width="25%">内容</th>
					<th width="120">留言时间</th>
					<th>操作</th>
				</tr>
				<!-- 留言展示 -->
				<%
					List<Pinglun> pingluns = dao3.findAllPinglun();
					for(Pinglun pinglun : pingluns){
						String adminName =dao2.getAdminsIdById(pinglun.getAdminId());
						String email=dao2.getAdminsemailById(pinglun.getAdminId());
				%>
				<tr>
					<td><%=pinglun.getId() %></td>
					<td><%=adminName %></td>
					<td><%=email %></td>
					<td><%=pinglun.getContent() %></td>
					<td><%=pinglun.getTime() %></td>
					<td><div class="button-group">
							<a class="button border-red" href="DelPinglun?id=<%=pinglun.getId() %>"
								onclick="return confirm('你确定要删除吗！！');"><span class="icon-trash-o"></span>
								删除</a>
						</div></td>
				</tr>
				<%} %>
				
				<tr>
					<td colspan="8"><div class="pagelist">
<!-- 							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a -->
<!-- 								href="">3</a><a href="">下一页</a><a href="">尾页</a> -->
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">


</script>



</body>
</html>
