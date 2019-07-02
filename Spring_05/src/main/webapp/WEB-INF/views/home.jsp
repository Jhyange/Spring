<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body>
<button id="input">Input</button>
<button id="output">Output</button>

<script>
$("#input").on("click",function(){
	$(location).attr("href","inputform");
})
$("#output").on("click",function(){
	$(location).attr("href","outputform");
})
</script>
</body>
</html>