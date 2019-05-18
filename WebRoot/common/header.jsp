<%@page import="cn.sdcet.shop.domain.Catalog"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="daoC" class="cn.sdcet.shop.dao.jdbc.CatalogDaoJDBCImpl" scope="session"></jsp:useBean>
<jsp:useBean id="daoA" class="cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl" scope="session"></jsp:useBean>
<div class="header">
	<div class="header-top">
		<div class="container">
				<div class="col-sm-4 logo">
					<a href="index.jsp"><img width="150" height="70" src="images/logooo2.jpg" alt=""></a>	
				</div>
				<div class="col-sm-4 world"></div>
			<div class="col-sm-4 header-left">
			<p class="log">
					<%
						String name = (String)request.getSession().getAttribute("username");
						String ids = (String)request.getSession().getAttribute("id");
						if(name==null){
					%>
					<a href="login.jsp"><font color="yellow">登录</font></a>
						<a  href="register.jsp" ><font color="yellow">注册</font></a>
					<%
						}else{
							out.println("用户："+ name + "<a href='session'><font color='yellow'>注销</font></a>");
						}
					%>
			</p>
					<div class="cart box_1">
						<a href="car.jsp" class="simpleCart_empty">
						<img src="images/car.PNG" alt=""/>
						</a>
						
					</div>
					<div class="clearfix"> </div>
			</div>
		</div>
	</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span></span>
		</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="index.jsp">首页</a></li>	
				      <li><a  href="#">类别</a>
				      	<div class="mepanel">
						<div class="row">
						<%
							List<Catalog> catalogs = daoC.findAll(); 
							for(Catalog catalog : catalogs){
						%>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href = "header?id=<%=catalog.getId()%>"><%=catalog.getName()%></a></li>
									</ul>	
								</div>							
							</div>
						<%} %>
						  </div>
						</div>
					</li>
			  </ul> 
			</div>
			<div class="col-sm-2 search">		
			
			<form action="find" method="post">
				<table>
				<tr>
					<td><input type="text" value="" name="text" "></td>
					<td><input type="submit" value="搜索"></td>
				</tr>
				</table>
		    </form>	
			
		</div>

		
		
	<!---->	
		</div>
	</div>
</div>