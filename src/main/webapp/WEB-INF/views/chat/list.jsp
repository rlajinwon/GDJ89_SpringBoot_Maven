<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>

<title>Insert title here</title>
</head>
<body id="page-top">

   <!-- Page Wrapper -->
   <div id="wrapper">   

      <c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
            

         <!-- Main Content -->
         <div id="content">
         
            <c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>

            <!-- Begin Page Content -->
            <div class="container-fluid">
               
               <!-- 본문 들어갈 contents 내용 -->
               
            
            <h2>chat list</h2>
            
            <div>
            	<input type="text" id="message">
            	<button id="send">SEND</button>
            </div>
            
            
        
        
            <div id="chat-box" style="border:1px solid #ccc; height:300px; overflow-y:auto; padding:10px; margin-bottom:10px;"></div>
            
            
            
            
            </div>
            <!-- /.container-fluid -->

         </div>
         <!-- End of Main Content -->         
		<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>
         
   
      </div>
      <!-- End of Content Wrapper -->

      
   </div>
   <!-- End of Page Wrapper -->
   
   <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
    
    
    
    <c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
	
	
	
    <script type="text/javascript">
      const websocket = new WebSocket("/ws/chat");
      const send = document.getElementById("send");
      const message = document.getElementById("message");
      const chatBox = document.getElementById("chat-box");
    
      // 연결되면 서버에 환영 메시지 전송
      websocket.onopen = () => {
        websocket.send("환영합니다!");
      };
    
      // 서버로부터 메시지 수신하면 화면에 출력
      websocket.onmessage = (m) => {
        console.log("받은 메시지:", m.data);
    
        const newMsg = document.createElement("div");
        newMsg.textContent = m.data;
        chatBox.appendChild(newMsg);
        chatBox.scrollTop = chatBox.scrollHeight; // 스크롤 아래로
      };
    
      // 전송 버튼 클릭 시 메시지 보내기
      send.addEventListener("click", () => {
        sendMessage();
      });
    
      // Enter 키로도 전송
      message.addEventListener("keydown", (e) => {
        if (e.key === "Enter") {
          e.preventDefault();
          sendMessage();
        }
      });
    
      // 메시지 전송 함수
      function sendMessage() {
        const msg = message.value.trim();
        if (msg !== "") {
          websocket.send(msg);
          message.value = "";
        }
      }
    
      // 연결 종료 시
      websocket.onclose = () => {
        console.log("웹소켓 연결 종료됨");
      };
    </script>
    
</body>
</html>