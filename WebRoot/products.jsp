<%@page import="cn.sdcet.shop.domain.Item"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品列表</title>
    <jsp:include page="common/head.jsp"/>
  </head>
  
  <body>
  <jsp:include page="common/header.jsp"/>
  <div class="products">
  <div class="container">
  <div class="col-md-9">
			<div class="content-top1">
			<%
				List<Item> items = (List<Item>)request.getAttribute("result"); 
				if(items.size() != 0){
					for(Item item : items){
			%>
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="productInfo.jsp?itemId=<%=item.getId()%>&itemName=<%=item.getName()%>&itemPrice=<%=item.getPrice() %>&itemPref=<%=item.getPref() %>" >
							<img width="180" height="181" "img-responsive" src="images/<%=item.getPref()%>" alt="" />
						</a>
						<h3><%=item.getName() %></h3>
						<div class="price">
								<h5 class="item_price" >售价:<font color="red"><%=item.getPrice() %>元</font></h5>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			<%}} 
				else{
			%>
			<font size="6" color="black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索结果：</font><br><br>
					<center>
					<font size="5" color="black"> 对不起，此商品不存在!!!</font>
					</center>
			
			<%} %>
			</div>	
		</div>
		</div>
		</div>
  <jsp:include page="common/footer.jsp"/>
  </body>
</html>
