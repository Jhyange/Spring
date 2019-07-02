<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<button id="toInput">Input</button>
<button id="toOutput">Output</button>
</div>
<script>
document.getElementById("toInput").onclick=function(){
		location.href="inputForm.do";
}
document.getElementById("toOutput").onclick=function(){
	location.href="outForm.do";
}
</script>
<img src="/img/download.jpg">

</body>
</html>