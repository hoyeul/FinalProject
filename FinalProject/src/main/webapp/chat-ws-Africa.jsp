<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>채팅</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    
    var wsocket;
    
    function connect() {
        
        wsocket = new WebSocket(
                "ws://192.168.0.95:8090/chat-ws3");
        
        wsocket.onopen = onOpen;
        wsocket.onmessage = onMessage;
        wsocket.onclose = onClose;
    }
    
    function disconnect() {
        wsocket.close();
    }

    function onOpen(evt) {
        appendMessage("연결되었습니다.");
    }
    
    function onMessage(evt) {
        var data = evt.data;
        if (data.substring(0, 4) == "msg:") {
            appendMessage(data.substring(4));
        }
    }
    
    function onClose(evt) {
        appendMessage("연결을 끊었습니다.");
    }
    
    function send() {
        
        var nickname = $("#nickname").val();
        var msg = $("#message").val();
        wsocket.send("msg:<span class='nickname'>"+nickname+"</span><br><span class='others'>"+ msg+"</span></div>");
        $("#message").val("");
        $("#chatMessageArea").append("<div align='right'><span class='mymessage'>"+msg+"</span></div><br>");
  		 var chatAreaHeight = $("#chatArea").height();
        var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
        
        $("#chatArea").scrollTop(maxScroll);
    }

    function appendMessage(msg) {
    	
        $("#chatMessageArea").append("<div align='left'>"+msg+"</div><br>");
        
    
        var chatAreaHeight = $("#chatArea").height();
        
        var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
        
        $("#chatArea").scrollTop(maxScroll);
    }

    $(document).ready(function() {
        
        $('#message').keypress(function(event){
            
var keycode = (event.keyCode ? event.keyCode : event.which);
            
       if(keycode == '13'){
                send(); 
            }
            
            event.stopPropagation();
        });
        $('#sendBtn').click(function() { send(); });
        $('#exitBtn').click(function() { disconnect(); });
    });
</script>
<style>
#chatArea {
    width: 400px; height: 500px; overflow-y: auto; border: 1px solid black;
    background: #ffffff;
}
.mymessage{ 
color:white;
background-color:skyblue;
margin-right: 0px;
border-radius: 15px;
padding:5px;
}
.others{
background-color:#ffff69;
margin-right: 0px;
border-radius: 15px;
padding:5px;
}
.nickname{
font-weight: bold;
padding-bottom:10px;
display: inline-block; 
}
</style>
</head>
<body>
    이름:<input type="text" id="nickname">
    <input type="button" id="enterBtn" value="입장" onclick="connect();this.onclick=null;">
    <input type="button" id="exitBtn" value="나가기">
    
    <h1>아프리카</h1>
    <div id="chatArea"><div id="chatMessageArea"></div></div>
    <br/>
    <input type="text" id="message">
    <input type="button" id="sendBtn" value="전송">
</body>
</html>
