<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
<head>
<base href="<%=basePath%>">

<title>修改商品信息</title>

<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改商品信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${basePath}/shop/goods?type=doUpdate">
			<input type="hidden" name="gNo" value="${goods.gNo }" >
				<div class="form-group">
					<div class="label">
						<label>商品代号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="gId"
							data-validate="required:请输入商品代号"  placeholder=" ${goods.gId }" >
						<div class="tips">

							<font color="red">${ message}</font>

						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="gType"
							data-validate="required:请输入名称" placeholder=" ${goods.gType }">
						<div class="tips">
						</div>
					</div>
				</div>
				
<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="gSize"
							data-validate="required:请输入名称" placeholder=" ${goods.gSize }">
						<div class="tips">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>商品颜色：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="gColor"
							data-validate="required:请输入名称" placeholder=" ${goods.gColor }">
						<div class="tips">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""  name="gNum"
							data-validate="required:请输入名称" placeholder=" ${goods.gNum }">
						<div class="tips">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gPrice_input"
							data-validate="required:请输入价格" placeholder=" ${goods.gPrice_input }">
						<div class="tips"></div>
					</div>
				</div>

			<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gPrice"
							data-validate="required:请输入价格" placeholder=" ${goods.gPrice }">
						<div class="tips"></div>
					</div>
				</div>
<div class="form-group">
					<div class="label">
						<label>商品价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="gSale"
							data-validate="required:请输入价格" placeholder=" ${goods.gSale }">
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							修改</button>
						<!--        onclick="disp_confirm()" -->
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
	</html> </i>