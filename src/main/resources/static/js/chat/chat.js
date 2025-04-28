
const websocket = new WebSocket("/ws/chat")
const send = document.getElementById("send")
const message = document.getElementById("message")
const receivername = document.getElementsByClassName("receiver-name");
const rec = document.getElementById("receiver")
const chatBody = document.getElementById("chat-body");
const chat = document.getElementById("chat");

for(let r of receivername){
    r.addEventListener("click", ()=>{
        let receiver=r.getAttribute("data-receiver-name");
        let sender = chat.getAttribute("data-sender-name");

        rec.value=receiver;
        chatBody.innerHTML="";

        fetch(`/chat/room?receiver=${receiver}&sender=${sender}`)
        .then(r=>r.json())
        .then(r=>{
          console.log(r);
          r.array.forEach(e => {
            let d = makeData(e);
            chatBody.append(d);
          });
        })
        .catch(e=>{
          console.log(e)
        })

        


        
    })
}


//webSocket 연결이 되었을 때
websocket.onopen=()=>{
    let m = new Message()
    m.body="님이 입장했습니다"
    //websocket.send(JSON.stringify(m))
}

//websocket으로 메세지를 수신 했을 때
websocket.onmessage=(m)=>{
    //
    let result =JSON.parse(m.data)
    let r = makeData(result);
    chatBody.append(r)
}

//webSocket연결이 종료 되었을 때
websocket.onclose=()=>{
    websocket.send("님이 나갔습니다다")
}

//개발자가 메세시 송신 할 때
send.addEventListener("click", ()=>{
    let m = message.value

    let mes = new Message();
    mes.body=m;
    mes.receiver=rec.value;
    mes.date=new Date();
    mes.status="1";
    
    
    websocket.send(JSON.stringify(mes))
    message.value="";

})

//websocke error 발생시
// websocket.onerror=()=>{

// }

websocket.onerror=webSocketError;

function webSocketError(){

}


//------------------------------------
class Message {
    roomNum="";
    sender="";
    body="";
    receiver="";
    date="";
    status="0"  //0전체 1:1:1
}


function makeData(data){

    const div = document.createElement("div");
    div.innerHTML=data.body

    return div;

}