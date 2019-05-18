
<%@page import="cn.sdcet.shop.domain.Catalog"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分类管理页面</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	

  </head>
  
  <body>
  <%String message1 = (String)request.getAttribute("message1"); %>
  <jsp:useBean id="dao4" class="cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl" scope="session"></jsp:useBean>
  
   <div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='cate.jsp#add'"><span class="icon-plus-square-o"></span> 添加分类</button>
    <%
							if (message1 != null) {
						%>
						<tr>
							<td colspan="2"><font color="red"><%=message1%></font></td>
						</tr>
						<%
							}
						%>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>
      <th width="15%">分类名称</th>
      <th width="10%">排序</th>
      <th width="10%">操作</th>
    </tr>
<!--     展示分累开始 -->
			<%
				int count=1;
				List<Catalog> catalogs = dao4.findAll();
				for (Catalog catalog : catalogs) {
			%>
			<tr>
				<td><%=catalog.getId()%></td>
				<td><%=catalog.getName()%></td>
				<td><%=count++ %></td>
				<td><div class="button-group">
						<a class="button border-main" href="cateedit.jsp?id=<%=catalog.getId()%>"><span
							class="icon-edit"></span> 修改</a> <a class="button border-red"
							href="<%=request.getContextPath()%>/DelCatalog?id=<%=catalog.getId()%>" onclick="return confirm('你确定要删除吗！！');"><span
							class="icon-trash-o"></span> 删除</a>
					</div></td>
			</tr>
			<%} %>

  </table>
</div>

<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加分类</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/AddCatalog">
    <%String message = (String)request.getAttribute("message"); %>
      
      <div class="form-group">
        <div class="label">
          <label>分类名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="title" />
						<%
							if (message != null) {
						%>
						<tr>
							<td colspan="2"><font color="red"><%=message%></font></td>
						</tr>
						<%
							}
						%>
						<div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
   
   
   
  </body>
</html>
