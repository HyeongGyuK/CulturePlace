<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../layouts/layout1.jsp" %>
<%@	include file="./addressPopup.jsp" %>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

    <style>
.fieldError {
	color: #bd2130;
}

.LogJoinBox {
	
	padding-top : 30px;
	height: 800px;
	margin-left: 550px;
	width: 800px;
	display: block;
	
}


.form-control {
	display: inline-block;
}
#addressBox1{
	width: 590px;
	float: left; 
}
#addressBox2{
	width: 200px;
	float: right;  
}
#idBox1{
	width: 100%;
}



/* #overlappedID{ */
/* 	width: 15%; */
/* 	float: right;   */
/* } */
#passwordBox{
	margin-top: 10px;
}


#box3{
	padding-left : 300px;
	display: inline-block;
}
#box1{
	float: left;
}

#box2{
	margin-left : 10px;
	float: right; 
}


label {
    display: inherit;
    max-width: 100%;
    margin-bottom: 5px;
    font-weight: 700;
}


#myid01{
	
	width: 590px;
	float: left;
	display: inline-block;
}

#myid02{
	width: 200px;
	float: right;  
}

#phoneNum{
	width: 200px;
	height: 25px;
	
}

.phoneMiddle{
	display: inline-block;
	width: 200px;
}

#addressbox{
    font-weight: 700;
}
}
</style>


<!-- 사용자 스크립트 추가 -->

<div class="LogJoinBox">
    <form action="/users/new" role="form" method="post">
    	<h2 align="center">회원가입</h2>
    	
        <div class="form-group"  id="idBox1">
            <label>아이디</label>

            <div id="myid01">
            <input type="text" name="id" class="form-control" placeholder="아이디를 입력해 주세요">
            </div>

			<div id="myid02">
			<button type="button" class="btn btn-default  form-control" id= "overlappedID"
				name="idcheck">중복확인</button>
			</div>            
			<br> <span id="olmessage"></span>
            <p class="fieldError">${errorMsg.id }</p>
		</div>
		
		
		
<!-- 		<div align="left" id="addressBox2"> -->
<!-- 			<input type="button" -->
<!-- 				class="btn btn-default form-control  postaddress" -->
<!-- 				onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br> -->
<!-- 		</div> -->



<!-- 		<div class="form-group" id="overlappedID"> -->
		
<!--            <button type="button"  -->
<!--              class="btn btn-default  form-control" name="idcheck">중복확인</button><br> -->
<!-- 			<span id="olmessage"></span> -->
<!--         </div> -->
        
        <div class="form-group">
            <label id="passwordBox">비밀번호</label>
            <input type="password" name="password" class="form-control" placeholder="비밀번호를 입력해 주세요">
            <p class="fieldError">${errorMsg.password }</p>
        </div>


		<div class="form-group">
			<label>비밀번호 확인</label>
			<input type="password" name="passwordCheck" class="form-control" maxlength="20"
				placeholder="비밀번호를 한번 더 입력해 주세요"> <span class="fieldError">${errorMsg.passwordCheck}</span>
		</div>

		<div class="form-group">
            <label>이름</label>
            <input type="text" name="name" class="form-control" placeholder="이름을 입력해 주세요">
             <span class="fieldError">${errorMsg.name}</span>
        </div>
        
        <div class="form-group">
            <label >이메일</label>
            <input type="text" name="email" class="form-control" placeholder="이메일을 입력해 주세요">
            <p class="fieldError">${errorMsg.email }</p>
        </div>
        
        
        <div class="form-group">
            <label >전화번호</label>
            <input type="text" name="phone" class="form-control"s maxlength="11">
            <p class="fieldError">${errorMsg.phone}</p>
        </div>

		<div class="form-group">
			<!-- for 는 ~~를 위해서로 해석 -->
			<div id="addressbox">주소</div>
			<div align="left" id="addressBox1">
				<input type="text" class="form-control postaddress addressbr"
					id="sample6_postcode" name="postcode"
					placeholder="우편번호" >
			  
			</div>
			<div align="left" id="addressBox2">
				<input type="button"
					class="btn btn-default form-control  postaddress"
					onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<p></p>
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_address"
					name="roadAddress" placeholder="도로명주소">
					<p></p>
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_detailAddress"
					name="address" placeholder="상세주소">
					<p class="fieldError">${errorMsg.address }</p>
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_extraAddress"
					name="extraAddress" placeholder="상세주소">
					<p></p>
			</div>
		</div>
		
		<div id="box3">
		<div style="text-align: center" id="box1">
            <button type="submit" class="btn btn-primary">회원가입</button>
        </div>
        <div style="text-align: center" id="box2">
         <a href="http://localhost:8999/members/new"><button type="button" class="btn btn-primary"> 돌아가기</button></a>
        </div>
		</div>
        
         

   </form>
</div>
</html>