<%@page import="cn.sdcet.shop.domain.Item"%>
<%@page import="cn.sdcet.shop.domain.Pinglun"%>
<%@page import="cn.sdcet.shop.domain.Admins"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品详细页面</title>
<jsp:include page="common/head.jsp" />
<style type="text/css">

.content-top-left {
	width: 50%; 
	background-color:#f0f0f0;
	float: left;
}
.content-top-right {
	width: 50%; 
	background-color:#f0f0f0;
	float: right;
	height: 100%; 
}

.pinglun{
width:80%;
position:absolute;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 500px;

}
.pinglun h2{
	color:#000;
	font-size: 2em;
	font-family: 'OleoScript-Regular';
	text-align:left;
	margin: 0 0 0em;
	border-bottom:3px solid black;
}
</style>
</head>

<body>
    <jsp:useBean id="dao" class="cn.sdcet.shop.dao.jdbc.ItemDaoJDBCImpl" scope="session"></jsp:useBean>
    <jsp:useBean id="dao1" class="cn.sdcet.shop.dao.jdbc.pinglunDaoJDBCImpl" scope="session"></jsp:useBean>
    <jsp:useBean id="dao2" class="cn.sdcet.shop.dao.jdbc.AdminsDaoJDBCImpl" scope="session"></jsp:useBean>
	<jsp:include page="common/header.jsp" />
	<%
		String idStr = request.getParameter("itemId");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("itemName");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String price = request.getParameter("itemPrice");
		String pref = request.getParameter("itemPref");
		List<Pinglun> pingluns = dao1.findPinglunByItemId(id);
	%>
	<div class="banner">
		<div class="content-top">
			</center>
			<h2>
				<center>
					<u>商品详情</u>
				</center>
			</h2>
			</center>

		</div>
		<div class="content-top-left">
			<img alt="" src="images/<%=pref %>" width="500" height="400">
		</div>
		<div class="content-top-right">
			<table border="0" align="right" cellspacing="25" cellpadding="0"
				width="450px" height="436px">
				<tr>
					<td>狗狗名字：<font color="#EC660B" face="幼圆"><%=name%></font><br>
					</td>
				</tr>
				<tr>
					<td>性别：<font color="#EC660B" face="幼圆">公</font><br>
					</td>
					<td>狗狗品种：<font color="#EC660B" face="幼圆">拉布拉多</font><br>
					</td>
				</tr>
				<tr>
					<td>卖家身份：<font color="#EC660B" face="幼圆">狗狗联盟店铺</font><br>
					</td>
					<td>附加服务：<font color="#EC660B" face="幼圆">送狗链</font><br>
					</td>
				</tr>
				<tr>
					<td>运费：<font color="#EC660B" face="幼圆">10元</font><br>
					</td>
				</tr>
				<tr>
					<td>商家电话：<font color="#EC660B" face="幼圆">123456</font>
					<br></td>
					<td>商家QQ：<font color="#EC660B" face="幼圆">123456</font>
					</td>
				</tr>
				<tr>
					<td colspan="2"><font size="3" face="幼圆"><b>联盟优惠价：</b></font>
						<font size="5" face="幼圆" color="#FF1700"><b><%=price%>元</b></font></td>
				</tr>
				<%
					String userId = (String) request.getSession().getAttribute("id");
				    userId = userId == null ? "0" : userId;
					int adminsId = Integer.parseInt(userId);
					if(adminsId!=0){
				%>
				<tr>
					<td colspan="2" align="center"><a href="addshopcaritem?itemId=<%=id%>"><img alt="" src="images/carbuttom.PNG" ></a></td>
				</tr>
				<%} else{%>
					<tr>
					<td colspan="2" align="center"><a href="login.jsp" onclick="return confirm('请先进行登录操作！！');"><img alt="" src="images/carbuttom.PNG" ></a></td>
				</tr>
				<% }%>
			</table>
		</div>
		<div class="pinglun">

				<div class="comment">
				<div class="hd"><h2>最新评论</h2></div>
				<br><br>
				
				<!--[if !IE]>评论列表 开始<![endif]-->
				<ol style="list-style:none;" class="com-list">
				<%
				int count=1;
				for(Pinglun pinglun : pingluns) {
						String adminName =dao2.getAdminsIdById(pinglun.getAdminId());
					%>
					<li>
						<p class="title wrapfix"><span class="num"><%=count++ %>.</span><span class="name"><%=adminName %></span><span class="time"><%=pinglun.getTime() %></span></p>
						<div class="com-body">
							<%=pinglun.getContent() %>
						</div>
					</li>
					<%} %>
					
				</ol>
				<!--[if !IE]>评论列表 结束<![endif]-->
				<!--[if !IE]>填写评论 开始<![endif]-->
				<div class="com-form">
				<hr class="double" />
					<div class="hd"><h3>发表评论</h3></div>
					<p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>
					<%if(adminsId!=0){ %>
					<form id="form1" method="post" action="AddPinglun?itemID=<%=id%>&itemName=<%=name%>&itemPrice=<%=price%>&itemPref=<%=pref %>">
						<p><textarea name="textarea" id="textarea" rows="5" class="textarea"></textarea></p>
						<p>
							<input type="submit" name="Submit" class="btn" value="发表评论" />
						</p>
					</form>
					<%}else{ %>
					<form id="form1" method="post" action="login.jsp">
						<p><textarea name="textarea" id="textarea" rows="5" class="textarea"></textarea></p>
						<p>
							<input type="submit" name="Submit" class="btn"  style="background-color:aqua;" value="发表评论" onclick="return confirm('请先进行登录操作！！');" />
						</p>
					</form>
					
					<%} %>
				</div>
				<!--[if !IE]>填写评论 开始<![endif]-->
			</div>

				<br>&nbsp;
			
		</div>

	</div>
	
	
	





</body>
</html>
