<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Culture/Intro/header/nav.jsp"%>
<!DOCTYPE html>
<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Document</title>

<style type="text/css">
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: content-box;
	}

	html{
	    padding-top: 0px;
	    padding-bottom:0px;
	}

	.chat_container {
	    display: flex;
	    width: 100%;
        justify-content: center;
        margin-top: 147px;
	}
	
	.category_box {
	    width: 250px;
	    display: flex;
	    flex-direction: column;
	    background:white;
	    float: left;
	    border: 1px solid black;
	}

	.chat_category {
	    height: 101.1px;
	    width: 100%;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    border-bottom: 1px solid #ddd;
	    box-sizing: border-box;
	}
	
	.category_box a {
	    text-decoration: none;
	    width: 100%;
	    color:black;
	}
	
	.category_box a:hover{
	    transition:0.3s;
	    background-color: black;
	    color:white;
	}

    #last_category{
        border:none;
    }

	.chat_space { /* 채팅공간 */
		width: 910px;
		height: 100%;
		padding-left: 10px;
		float: right;
		background: black;
	}
      
	.chat_space h1{
      	margin: 0;
      	margin-top: 5px;
      	margin-bottom: 10px;
      	padding: 5px 5px 5px 15px;
      	text-align: left;
      	color: #FFBB00;
		border-left: 3px solid #FFBB00;
	}
      
	.roomContainer{
      	background-color: #F6F6F6;
      	width: 900px;
		height: 500px;
		overflow: auto;
	}
      
	.roomList{
		border: none;
		border-spacing: 2px;
  		border-collapse: separate;
	}
	
	.roomList th{
		border: 1px solid #FFBB00;
		background-color: #fff;
		color: #FFBB00;
	}
	
	.roomList td{
		border: 1px solid #FFBB00;
		background-color: #fff;
		text-align: left;
		color: #FFBB00;
	}
	
	.roomList .num{
		width: 75px;
		text-align: center;
	}
	
	.roomList .room{
		width: 350px;
	}
	
	.roomList .go{
		width: 71px;
		text-align: center;
		color: #000;
	}
	
	button{
		background-color: #FFBB00;
		font-size: 14px;
		color: #000;
		border: 1px solid #000;
		border-radius: 5px;
		padding: 3px;
		margin: 3px;
	}
	
	.inputTable{
		padding-bottom: 3px;
	}
	
	.inputTable th{
		padding: 5px;
	}
	
	.inputTable input{
		width: 763px;
		height: 25px;
	}
	
	.inputTable th:nth-child(1){
		color: white;
	}
</style>
    
<script type="text/javascript">
	var ws;
	window.onload = function(){
		getRoom();
		createRoom();
	}
	
	function getRoom(){
		commonAjax('/getRoom', "", 'post', function(result){
			createChatingRoom(result);
		});
	}
	
	function createRoom(){
		$("#createRoom").click(function(){
			var msg = {	roomName : $('#roomName').val()	};
	
			commonAjax('/createRoom', msg, 'post', function(result){
				createChatingRoom(result);
			});
	
			$("#roomName").val("");
		});
	}
	
	function goRoom(number, name){
		var result = "";
// 		location.href="/moveChating?roomName="+name+"&"+"roomNumber="+number;
		$.ajax({
			type: "POST",
			url: "/moveChating?roomName=" + name + "&" + "rommNumber=" + number,
			dataType: "text",
			data: {
				"roomName": name,
				"roomNumber": number
			},
			async: false,
			success: function(data){
				alert("성공 : " + data);
				result = data;
				$("#chat_area").append(result);
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
	
	function createChatingRoom(res){
		if(res != null){
			var tag = "<tr><th class='num'>순서</th><th class='room'>방 이름</th><th class='go'></th></tr>";
			res.forEach(function(d, idx){
				var rn = d.roomName.trim();
				var roomNumber = d.roomNumber;
				tag += "<tr>"+
							"<td class='num'>"+(idx+1)+"</td>"+
							"<td class='room'>"+ rn +"</td>"+
							"<td class='go'><button type='button' onclick='goRoom(\""+roomNumber+"\", \""+rn+"\")'>참여</button></td>" +
						"</tr>";	
			});
			$("#roomList").empty().append(tag);
		}
	}
	
	function commonAjax(url, parameter, type, calbak, contentType){
		$.ajax({
			url: url,
			data: parameter,
			type: type,
			contentType : contentType!=null?contentType:'application/x-www-form-urlencoded; charset=UTF-8',
			success: function (res) {
				calbak(res);
			},
			error : function(err){
				console.log('error');
				calbak(err);
			}
		});
	}
</script>
</head>

<body>
    <div class="chat_wrap">
        <div class="chat_container">
            <div class="category_box" id="box">
                <a href="#">
                    <div class="chat_category">
                        <h3>뮤지컬</h3>
                    </div>
                </a>
                <a href="#">
                    <div class="chat_category">
                        <h3>연극</h3>
                    </div>
                </a>
                <a href="#">
                    <div class="chat_category">
                        <h3>콘서트</h3>
                    </div>
                </a>
                <a href="#">
                    <div class="chat_category">
                        <h3>무용</h3>
                    </div>
                </a>
                <a href="#">
                    <div class="chat_category">
                        <h3>클래식/오페라</h3>
                    </div>
                </a>
                <a href="#">
                    <div class="chat_category" id="last_category">
                        <h3>국악</h3>
                    </div>
                </a>
            </div>
            <div class="chat_space">
               <h1>채팅방</h1>
                <div id="roomContainer" class="roomContainer">
                    <table id="roomList" class="roomList"></table>
                </div>
                <div>
                    <table class="inputTable">
                        <tr>
                            <th>방 제목</th>
                            <th><input type="text" name="roomName" id="roomName"></th>
                            <th><button id="createRoom">방 만들기</button></th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
