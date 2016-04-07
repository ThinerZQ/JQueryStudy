<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
</head>
<body>
	<form action="get1.jsp">
		<input type="text" name="username"/>
		<input type="password" name="password"/>
		<input type="button" value="登陆" id="ok"/>
	</form>
	<div id="one">
		
	</div>

</body>
<script type="text/javascript">
	$("#ok").click(function(){
		var xmlReq = $.get("get1.jsp",function(data,textStatus){
			//alert(data);
			//alert(textStatus);
			
			$("#one").text(data);
		});
		//alert(xmlReq.readyState);
		alert(xmlReq.status);
		
	});
	//post一样
	
</script>
</html>