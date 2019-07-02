<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>
</head>
<body>
<form action="upload2.do" method="post" enctype="multipart/form-data">
<!--request보낼때 너무길고 복잡하면 서버가 구분짓기 어려우므로 부분을 나누어서 보내겠다  -->
<!--mutipart/from-data는 기본적인 타입과 달리 parameter로 값을 꺼내올 수 없다  -->
<input type="text" name=name><br>
<input type ="file" name=image><br>
<input type="submit" value="send"><br>
</form>
</body>
</html>