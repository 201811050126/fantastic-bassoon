<%@page import="cn.sdcet.shop.domain.ShopCarItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="shopcaritemdao" class="cn.sdcet.shop.dao.jdbc.ShopCarItemDaoJDBCImpl" scope="session"/>
<jsp:useBean id="adminsdao" class="cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl" scope="session"/>
<jsp:useBean id="cardao" class="cn.sdcet.shop.dao.jdbc.CarDaoJDBCImpl" scope="session"/>
<%
	String id = (String)request.getSession().getAttribute("id");
	id = id == null ? "0" : id;
	int adminsId = Integer.parseInt(id);
%>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<jsp:include page="common/head.jsp"/>
    <title>购物车</title>
  </head>
  
  <body>
    <jsp:include page="common/header.jsp"/>
    
    <div class="container">
	<div class="check-out">
		<h1 align="center">购物车</h1><hr/><br/>
    <form action="updateshopcaritem" method="post">
    <table border="1" align="center" width="90%">
    	<tr>
    		<th>商品</th><th>单价</th><th>数量</th>
   			<th>总价</th><th>操作</th>
    	</tr>
    	<%
    		List<ShopCarItem> shopCarItems = shopcaritemdao.findAll(adminsId);
    		for(ShopCarItem shopCarItem : shopCarItems){
    			int pirce = shopCarItem.getItem().getPrice();
    			int quantity = shopCarItem.getQuantity();
    			int itemId = shopCarItem.getItem().getId();
    	%>
    	<tr>
    		<td><%=shopCarItem.getItem().getName() %></td>
    		<td><%=pirce%>元</td>
    		<td>
    			<input type="text" name="quantity" value="<%=quantity%>">
    			<input type="hidden" name="itemId" value="<%=itemId%>">
    		</td>
    		<td><%=pirce*quantity %>元</td>
   			<td><a href="delshopcaritem?itemId=<%=itemId%>">删除</a></td>
    	</tr>
    	<%} %>

    	<tr>
   				<td colspan="5" align="right">合计：&nbsp;&nbsp;<%=cardao.getPayment(adminsId)%>元</td>
   		</tr>
    </table>
    <br/>
    
    <table width="90%" align="center">
    	<tr>
    		<td align="left">
    			<div class="col-md-6 login-right"><input type = "submit" value="确认数量修改"></div>
    		</td>
    		<td align="center">
    			
    		</td>
    		<td align="right">
    			<a href="clear">清空购物车</a>
    		</td>
    	</tr>
    </table>
    <input type="hidden" name="itemNum" value=" ">
    </form>
    </div>
</div>
    
    <jsp:include page="common/footer.jsp"/>
  </body>
</html>
