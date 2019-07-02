<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chatting</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<!--  cdn을 사용하는 이유 : 웹 소켓이 탑재 되어 있지 않은 브라우저가 있어 웹 소켓을 구동할 수 없으므로 해당 cdn을 넣어준다/ 범용성 라이브러리 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>

<body>
	<div class="contents"></div>
	<input type=text id=message>
	<button id=send>send</button>


	<script>
		var socket = new SockJS("/webchat");
		var client = Stomp.over(socket); // 연결 이후의 작업에 대한 처리를 해준다 
		/* 받아 오는 부분  */
		client.connect({}, function(resp) { //해더정보, body정보 
			console.log(resp);
			client.subscribe("/response",function(msg){//reponse를 통하여 snedto 되는 모든 메시지를 받아오겠다 
				
				var line=$("<div></div");				
				var result=JSON.parse(msg.body);
			line.append(result.name+":"+result.message);
			$(".contents").append(line);
			}) ;
		});
		
		/*보내는 부분  */
		$("#send").on("click",function(){
			var msg=$("#message").val();
			$("#message").val("");
			client.send("/app/chat",{},JSON.stringify({message:msg})); //보낼 위치 , 해더정보, 보낼 메시지 
			//client는 json형태의 message를 보낸다 
		})
	</script>
	
	
</body>
</html>