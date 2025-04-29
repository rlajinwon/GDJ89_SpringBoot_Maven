const websocket = new WebSocket("/ws/chat")



try{

    const memoSend = document.getElementById("memoSend")
    const memoContents = document.getElementById("memoContents")
    const memoReceiver = document.getElementById("memoReceiver")

    memoSend.addEventListener('click',()=>{

        let m = new Message();
        m.body = memoContents.value;
        m.receiver = memoReceiver.value;
        m.status="3"
        m.date=new Date();
        console.log("gggg")

        websocket.send(JSON.stringify(m));
    })


}catch(e){

}













try{


const send = document.getElementById("send")
const message = document.getElementById("message")
const receivername = document.getElementsByClassName("receiver-name");
const rec = document.getElementById("receiver")
const chatBody = document.getElementById("chat-body");
const chat = document.getElementById("chat")

for(let r of receivername){
    r.addEventListener("click", ()=>{
        let receiver=r.getAttribute("data-receiver-name");
        let sender = chat.getAttribute("data-sender-name")
        rec.value=receiver;
        chatBody.innerHTML="";

        fetch(`/chat/room?receiver=${receiver}&sender=${sender}`)
            .then(r=>r.json())
            .then(r=>{
                console.log(r)
                r.forEach(e => {
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

    let start = result.sender(); 

    let end = result.receiver();

    let status = result.status;


    //-------------------메모(쪽지)

    if(status == "3"){
        console.log(data);
        alert(result.body);
        makeMemo(data);
        return;
    }







    //-------------------------1ㄷ1 채팅
    let my = chat.getAttribute("data-sender-name") // 내 정보

    let re = rec.value; // 현재 채팅하고 있는 상대방 정보 
    if(start != my && start != re){
        return;
    }
    


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

}catch(e){}


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



// 쪽지 출력 구조 

function makeMemo(data) {
    const a = document.createElement("a");
    a.classList.add("dropdown-item", "d-flex", "align-items-center");
    a.href = "#";

    const imageDiv = document.createElement("div");
    imageDiv.classList.add("dropdown-list-image", "mr-3");

    const img = document.createElement("img");
    img.classList.add("rounded-circle");
    img.src = "https://source.unsplash.com/Mv9hjnEUHR4/60x60"; // 예시 이미지

    const status = document.createElement("div");
    status.classList.add("status-indicator", "bg-success");

    imageDiv.appendChild(img);
    imageDiv.appendChild(status);

    const textDiv = document.createElement("div");

    const bodyDiv = document.createElement("div");
    bodyDiv.classList.add("text-truncate");
    bodyDiv.innerText = data.body;

    const infoDiv = document.createElement("div");
    infoDiv.classList.add("small", "text-gray-500");
    infoDiv.innerText = `${data.sender} · 지금`;

    textDiv.appendChild(bodyDiv);
    textDiv.appendChild(infoDiv);

    a.appendChild(imageDiv);
    a.appendChild(textDiv);

    document.getElementById("memoAdd").before(a);
}


