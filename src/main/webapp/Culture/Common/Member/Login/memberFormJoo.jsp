<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../layouts/layout1.jsp" %>
<%@	include file="./addressPopup.jsp" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{layouts/layout1}">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<th:block layout:fragment="css">
    <style>
.fieldError {
	color: #bd2130;
}

.LogJoinBox {
	
	border: 1px solid black;
	height: 800px;
	margin-left: 250px;
	width: 800px;
	
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
</style>
</th:block>

<%
int wid = 8;
%>
<!-- 사용자 스크립트 추가 -->


<th:block layout:fragment="script">

    <script th:inline="javascript">
        $(document).ready(function(){
            var errorMessage = [[${errorMessage}]];
            if(errorMessage != null){
                alert(errorMessage);
            }
        });
    </script> 

</th:block>

<div layout:fragment="content" class="LogJoinBox">
    <form action="/members/new" role="form" method="post" th:object="${memberFormDto}">
    	<h2 align="center">회원가입</h2>
        <div class="form-group">
            <label th:for="id">아이디</label>
            <input type="text" th:field="*{id}" class="form-control" placeholder="아이디를 입력해 주세요">
            <p  th:errors="*{id}" class="fieldError"></p>
        </div>
        
        <div class="form-group">
            <label th:for="password">비밀번호</label>
            <input type="password" th:field="*{password}" class="form-control" placeholder="비밀번호를 입력해 주세요">
            <p th:errors="*{password}" class="fieldError"></p>
        </div>
        
        <div class="form-group">
            <label th:for="name">이름</label>
            <input type="text" th:field="*{name}" class="form-control" placeholder="이름을 입력해 주세요">
            <p th:errors="*{name}" class="fieldError"></p>
        </div>
        
        <div class="form-group">
            <label th:for="email">이메일</label>
            <input type="text" th:field="*{email}" class="form-control" placeholder="이메일을 입력해 주세요">
            <p th:errors="*{email}" class="fieldError"></p>
        </div>

		<div class="form-group">
			<!-- for 는 ~~를 위해서로 해석 -->
			<div>주소</div>
			<div align="left" id="addressBox1">
				<input type="text" class="form-control postaddress addressbr"
					id="sample6_postcode" name="postcode" name="sample4_postcode"
					placeholder="우편번호" required>
			  
			</div>
			<div align="left" id="addressBox2">
				<input type="button"
					class="btn btn-default form-control  postaddress"
					onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_address"
					name="roadAddress" placeholder="도로명주소">
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_detailAddress"
					name="detailAddress" placeholder="상세주소" required>
			</div>
			
			<div align="left">
				<input type="text" class="form-control" id="sample6_extraAddress"
					name="extraAddress" placeholder="상세주소">
			</div>
		</div>

		<div style="text-align: center">
            <button type="submit" class="btn btn-primary">회원가입</button>
        </div>
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}">

   </form>
</div>
</html>