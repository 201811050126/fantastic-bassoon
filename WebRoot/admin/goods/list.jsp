<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理页面</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	

  </head>
  
  <body>
   <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> </div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>      
        <th>商品代号</th>    
        <th>商品类别</th>
        <th>商品颜色</th>
        <th>商品尺码</th>
        <th>商品库存
</th>
        <th>商品进价</th>
        <th>商品价格
</th>
<th>商品折扣
</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
      
      
      <c:forEach items="${goodsList}" var="goods">
      
    
<!--       开始 -->
        <tr>
          <td style="text-align:left; padding-left:20px;">${goods.gNo} </td>
				<td>${goods.gId}</td>
				<td>${goods.gType}</td>
				<td>${goods.gColor}</td>
				<td>${goods.gSize}</td>
				<td>${goods.gNum}</td>
				<td>${goods.gPrice_input}</td>
				
				<td>${goods.gPrice}</td>
				<td>${goods.gSale}</td>
					<td><div class="button-group">
							<a class="button border-main"href="${basePath}/shop/goods?type=toFrom&gNo=${goods.gNo}"><span class="icon-edit"></span> 修改</a> 
							<a class="button border-red"
								href="${basePath}/shop/goods?type=doDelete&gNo=${goods.gNo}"
								onclick="return confirm('你确定要删除吗！！');"><span
								class="icon-trash-o"></span> 删除</a>
						</div></td>
				</tr>
<!--         结束 -->
  </c:forEach>


   		
<!--       <tr> -->
<!--         <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>全选 </td> -->
<!--         <td colspan="7" style="text-align:left;padding-left:20px;"> -->
<!--         <a href="" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>  -->

<!--       </tr> -->
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">


//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}



</script>
   
   
   
  </body>
</html>
