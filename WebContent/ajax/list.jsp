<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery.js"></script>
</head>
<body>

	<select id="province" name="province">
		<option value="">请选择...</option>
	</select >
	<select id="city" name="city">
		<option value="">请选择...</option>
	</select >
	<select id="county" name="county">
		<option value="">请选择...</option>
	</select >
</body>
<script type="text/javascript">
	$(document).ready(function(){
		//启动加载,select id="province"的下拉列表中
		$.post("../listServlet",function(data,textStatus){
			//alert(data);
			var dataObj = eval("("+data+")");
			for(var i=0;i<dataObj.length;i++){
				//alert(dataObj[i].pid+"   "+dataObj[i].pname);
				$option = $("<option></option>");
				$option.attr("value",dataObj[i].pid);
				$option.text(dataObj[i].pname);
				
				$("#province").append($option);
			}
		});
		
		
		//省的变化导致城市的变化
		$("#province").change(function(){
			var pid = this.value;
			$.post("../cityServlet",{pid:pid},function(data,textStatus){
				//alert(data);
				//清空option选项，保留请选择
				$("#city option[value!='']").remove();
				$("#county option[value!='']").remove();
				var dataObj = eval("("+data+")");
				for(var i=0;i<dataObj.length;i++){
					//alert(dataObj[i].pid+"   "+dataObj[i].pname);
					$option = $("<option></option>");
					$option.attr("value",dataObj[i].cid);
					$option.text(dataObj[i].cname);
					
					$("#city").append($option);
				}
			});
		});
		//市的变化导致县的变化
		$("#city").change(function(){
			var cid = this.value;
			$.post("../countyServlet",{cid:cid},function(data,textStatus){
				
				$("#county option[value!='']").remove();
				var dataObj = eval("("+data+")");
				for(var i=0;i<dataObj.length;i++){
					//alert(dataObj[i].pid+"   "+dataObj[i].pname);
					$option = $("<option></option>");
					$option.attr("value",dataObj[i].tid);
					$option.text(dataObj[i].tname);
					
					$("#county").append($option);
				}
			})
		})
		
		
	});
</script>


</html>