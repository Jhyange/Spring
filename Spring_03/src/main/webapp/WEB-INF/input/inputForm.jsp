<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InputForm</title>
</head>
<body>
<form action="inputProc.do" method="post">
<input type=text name="name"><br>
<input type=text name="msg"><br>
<input type="submit" value="send">
<button id="back">back</button>
</form>

<script>
document.getElementById("back").onclick=function(){
	history.back();
	
	
}
</script>
</body>
</html>