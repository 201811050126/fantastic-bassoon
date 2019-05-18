<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=gb2312"%>
<%@page import="cn.sdcet.shop.domain.Catalog"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'add.jsp' starting page</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
	<jsp:useBean id="dao7"
		class="cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl" scope="session"></jsp:useBean>
	<%
			String message = (String)request.getAttribute("message");	
		%>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="<%=request.getContextPath() %>/rootAddItem" enctype="multipart/form-data" accept-charset="utf-8">
				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="name"
							data-validate="required:请输入名称">
						<div class="tips">
							<%
						if (message != null) {
					%>

							<font color="red"><%=message%></font>

							<%
						}
					%>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>图片：</label>
					</div>
					<div class="field">
						
							<input type="file"
							class="button bg-blue margin-left" id="image1" name="upfile" value="+ 浏览上传"
							style="float:left;">
						<div class="tipss"></div>
					</div>
				</div>

				<if condition="$iscid eq 1">
				<div class="form-group">
					<div class="label">
						<label>分类标题：</label>
					</div>
					<div class="field">
						<select name="catalogid" class="input w50">
							<option value="">请选择分类</option>
							<%
    			        //String c= request.getParameter("catalog");
    			    	List<Catalog> catalogs = dao7.findAll();
    			    	for(Catalog catalog : catalogs) {
    			    		//String selected = (c!=null && c.equals(catalog)) ? "selected" : "";
    			    %>
							<option value="<%=catalog.getId()%>"><%=catalog.getName()%></option>
							<%
    			    	}
    				%>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="price"
							data-validate="required:请输入价格">
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
						<!--        onclick="disp_confirm()" -->
					</div>
				</div>
				</if>
			</form>
		</div>
	</div>

</body>
	</html> </i>