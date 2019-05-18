<%@page import="cn.sdcet.shop.domain.Item"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>首页</title>
   <jsp:include page="common/head.jsp"/>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
</head>
  
  <body>
  	<jsp:useBean id="dao" class="cn.sdcet.shop.dao.jdbc.ItemDaoJDBCImpl" scope="session"></jsp:useBean>
    <jsp:include page="common/header.jsp"/>
    <div class="banner">
	<div class="content-top">
			<h2><u>全部商品</u></h2>
			<div class="content-top1">
			<%
				List<Item> items = dao.findAll();
				for(Item item : items){
			%>
				<div class="col-md-3 col-md2">
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
			<%} %>
			</div>	
		</div>
	<div class="clearfix"> </div>
	</div>
	<br><br><br>
	<div class="content">
	<div class="container">
	<h1>宠物展示</h1><br><br><br>
<!-- 		<div class="col-sm-3 banner-mat"> -->
<!-- 		<img class="img-responsive"	src="images/baozhen.PNG" alt=""> -->
<!-- 	</div> -->
	<div class="col-sm-6 matter-banner">
	 	<div class="slider">
	    	<div class="callbacks_container">
	      		<ul class="rslides" id="slider">
	        		<li>
	          			<img src="images/hashiqi (1).PNG"  height="100%" alt="">
	       			 </li>
			 		 <li>
	          			<img src="images/bage.jpg"  height="100%" alt="" >   
	       			 </li>
					 <li>
	          			<img src="images/keji.PNG" height="100%" alt="">
	        		</li>	
	      		</ul>
	 	 	</div>
		</div>
	</div>
	<div class="col-sm-3 banner-mat">
		<img class="img-responsive" src="images/gouliang.PNG" alt="">
		<img class="img-responsive" src="images/gouliang.PNG" alt="">
		<img class="img-responsive" src="images/gouliang.PNG" alt="">
	</div>
	</div>
</div>
    <jsp:include page="common/footer.jsp"/>
  </body>
</html>
