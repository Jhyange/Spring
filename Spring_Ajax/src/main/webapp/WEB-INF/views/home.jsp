<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<title>home</title>
</head>
<body>
<input type="text" id="val">

<input type=text id=data1>

<input type=text id=data2>

<button id=asJson>asJson</button>

<script>

$("#asJson").on("click",function(){

$.ajax({

url:"asJson",

data:{data1:$("#data1").val(), 
	data2:$("#data2").val()
	 },
dataType:"json",
success:function(resp){
	console.log(resp.data1 + " : " + resp.data2);

 	/* var result=JSON.parse(resp);
	console.log(result);
	console.log(result.data1 + " : " + result.data2); */  

}

})

})

</script>

<form action="input" method="get">

<input type=text name=name>

<input type=text name=message>

<input type=submit>

</form>
</body>
</html>