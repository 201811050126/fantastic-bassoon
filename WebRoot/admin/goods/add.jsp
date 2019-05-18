<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'add.jsp' starting page</title>

<link rel="stylesheet" href="${basePath}/shop/css/pintuer.css">
<link rel="stylesheet" href="${basePath}/shop/css/admin.css">
<script src="${basePath}/shop/js/jquery.js"></script>
<script src="${basePath}/shop/js/pintuer.js"></script>

</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="${basePath}/shop/goods?type=doAdd" accept-charset="utf-8">
				<div class="form-group">
					<div class="label">
						<label>商品代号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gId"
							data-validate="required:请输入商品代号">
						<div class="tips">

							<font color="red">${ message}</font>

						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品类别：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gType"
							data-validate="required:请输入类别">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品颜色：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gColor"
							data-validate="required:请输入颜色">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品尺码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gSize"
							data-validate="required:请输入尺码">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品库存：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gNum"
							data-validate="required:请输入库存">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品进价：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gPrice_input"
							data-validate="required:请输入进价">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gPrice"
							data-validate="required:请输入价格">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品折扣：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gSale"
							data-validate="required:请输入折扣">
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
			</form>
		</div>
	</div>

</body>
</html>