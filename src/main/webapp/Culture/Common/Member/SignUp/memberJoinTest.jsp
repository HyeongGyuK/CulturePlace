<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../Member_Common/common.jsp" %>
<%@	include file="./addressPopup.jsp" %>
<%
	int offset = 3; // 양식의 label 너비
	int content = twelve - 2*offset; //양식의 입력
%>
<%-- <%@ page import= "bakery.member.bean.Member"%> --%>
<%-- <%@ page import= "bakery.member.dao.MemberDao"%> --%>
<%-- <% --%>
<!--  	Member bean  =new Member(); -->
<!--  	MemberDao mdao = new MemberDao();	 -->
<!--  	String id =""; -->
<%-- %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문화예술제단</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<style type="text/css">
		.inputtitle{text-align: left; margin-bottom: 5px; margin-top:5px;}
		#phonediv, #phoneselectdiv{padding:0px; height:34px;}
		#phoneselect{height:34px; width:100%;}
		#emaildiv, #emailiddiv{padding:0px; height:34px; }
		#emailid, #email,#phone,#phoneselect{height:34px; width:100%;border:#cccccc solid 1px; border-radius: 5px;}
		#golbang{text-align: center; heigth:34px; padding: 0px; padding-top: 5px;}
		.btngender{width:100%; display: inline-block;}
		#logosize{width:100px; height:100px;}
		#logomungusize{width:300px; height:40px;}
		.postaddress{display: inline-block;}
		.findpost{padding-left: -10px; margin-left: 2px;}
		.addressbr{margin-top: 5px;}
		div.panel{border:none; }
		
		#topline{padding-top:56px; padding-left:10px;margin-left:25%;  width:50%; height:105px; color:#666666; font-weight: 600; font-size: 30px;border-bottom: 3px solid #cccccc;}
		.panel-body{width:35%; margin:0 auto; margin-bottom:100px;}
		div{color:#555555;}
		
		input[type=button]:hover, button[type=submit]:hover{background-color:#551527; color:#ffffff;}
		.idform,.nameform, .nicknameform, .passwordform, .emailform, .phoneform{margin-left:15px;list-style: none;}
		.emailform{ padding-top: 35px;}
		.notForm{color:red; }
		.yesForm{color:green;}
		.ok{background-color:#eeeeee;}
		#textEmail{
				display: inline-block;
				margin-left: -10px
		}
		#select01{
			border-radius: 5px;
			height: 34px;
			margin-left: -30px
		}
		
		
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#fakeaddress').attr('disabled',true);// 주소 읽기 전용으로 설정
		$('.radio-inline').addClass('radio-inline'); // 라디오 버튼 스타일 지정
		
		//관리자 선택할 때 이렇게 하면 됨. 또는 위에 스크립트 이용해서 임포트로 끌고 와서 관리자 목록을 바인딩
		var managers = ['yusin','kim9','soon'];
		$.each(managers,function(index,item){
			console.log(item);
			var optvalue=' <option value="'+item+'">'+item+'</option>';
			$('#manager').append(optvalue);
		});
		$('#logosize').addClass('logosize');
		$('.postaddress[type=button]').css({'width':'130px'}).parent().addClass('findpost');
		$('input').focus(function(){
			$(this).addClass('inputback');
		});
		
		
		//아이디
		$('#idli1, #idli2, #idli3').hide().addClass('notForm');
		$('#joinid').focus(function(){
			$('#idli1').show();
			$('#idli3').hide();
			$('#idli2').hide();
		});
		$('#joinid').focusout(function(){
			if($('#joinid').val()){
				$('#idli1').addClass('yesForm');
				$('#idli1').removeClass('notForm');
			}else{
				$('#idli1').addClass('notForm');
				$('#idli1').removeClass('yesForm');
			}
		});
		$('#idcheck').click(function(){
			location.href="<%=noForm%>meIdCheck&joinid="+$('#joinid').val();
			<%--
			alert("<%=noForm%>meIdCheck&joinid="+$('#joinid').val());
			--%>
		});
		if(${requestScope.joinid!=null }){
			$('#idli2').show();
			$('#idli1').hide();
			$('#idli3').hide();
			$('#idli2').addClass('yesForm');
			$('.idform').addClass('ok');
		}
		if(${requestScope.joinid=="~~" }){
			$('#joinid').val(' ').focus();
			$('#idli1').hide();
			$('#idli2').hide();
			$('#idli3').show();
			$('#idli3').addClass('notForm');
			$('.idform').romoveClass('ok');
		}
		
		//이름 
		$('#nameli1').hide().addClass('notForm');
		$('#name').focus(function(){
			$('#nameli1').show();
		});
		$('#name').focusout(function(){
			if($('#name').val()){
				$('#nameli1').addClass('yesForm');
				$('#nameli1').removeClass('notForm');
				$('.nameform').addClass('ok');
			}else{
				$('#nameli1').removeClass('yesForm');
				$('#nameli1').addClass('notForm');
				$('.nameform').removeClass('ok');
			}
		});
		
		// 닉네임
		$('#nicknameli1, #nicknameli2').hide().addClass('notForm');
		$('#nickname').focus(function(){
			$('#nicknameli1').show();
		});
		$('#nickname').focusout(function(){
			if($('#nickname').val()){
				$('#nicknameli1').addClass('yesForm');
				$('#nicknameli1').removeClass('notForm');
				if($('#nickname').val().length>15){
					$('#nicknameli2').show();
					$('#nicknameli2').addClass('notForm');
					$('#nicknameli2').removeClass('yesForm');
					$('.nicknameform').removeClass('ok');
				}else{
					$('#nicknameli2').removeClass('notForm');
					$('#nicknameli2').addClass('yesForm');
					$('.nicknameform').addClass('ok');
				}
			}else{
				$('#nicknameli1').removeClass('yesForm');
				$('#nicknameli1').addClass('notForm');
				$('.nicknameform').removeClass('ok');
			}
		});
		
		// 비밀번호
		$('#passwordli1, #passwordli2,#passwordli3,#passwordli4').hide().addClass('notForm');
		$('#password').focus(function(){
			$('#passwordli2,#passwordli3,#passwordli4').show();
			$('#password').on("propertychange change paste input", function() {
				<%-- 8자 이상 15자 이하입력--%>
				if(!($('#password').val().length>=8&&$('#password').val().length<=15)){
					$('#passwordli2').addClass('notForm');
					$('#passwordli2').removeClass('yesForm');
				}else{
					$('#passwordli2').addClass('yesForm');
					$('#passwordli2').removeClass('notForm');
				}
				<%-- 특수 문자는 1가지 이상 다른 특수문자 안됨 --%>
				
				if($('#password').val().indexOf("@")>=0 ||
				$('#password').val().indexOf("!")>=0 ||
				$('#password').val().indexOf("#")>=0 ||
				$('#password').val().indexOf("$")>=0){
					$('#passwordli3').addClass('yesForm');
					$('#passwordli3').removeClass('notForm');
					
				}else{
					$('#passwordli3').addClass('notForm');
					$('#passwordli3').removeClass('yesForm');
					
				}
				var reg = /[~%^&*()_+|<>?:{}]/;
				var result = reg.test($('#password').val());
				if(result){
					$('#passwordli3').addClass('notForm');
					$('#passwordli3').removeClass('yesForm');
				}
				<%-- 영문/숫자/특수문자(공백제외)만 허용가능, 2개이상 조합  --%>
				var reg1 =/[a-z]{1,}[0-9]{1,}/;
				var result1 = reg1.test($('#password').val());
				var reg2 =/[!@#$]{1,}[0-9]{1,}/;
				var result2 = reg2.test($('#password').val());
				var reg3 =/[a-z]{1,}[!@#$]{1,}/;
				var result3 = reg3.test($('#password').val());
				
				if(result1==true||result2==true||result3==true){
					$('#passwordli4').addClass('yesForm');
					$('#passwordli4').removeClass('notForm');
				}else{
					$('#passwordli4').addClass('notForm');
					$('#passwordli4').removeClass('yesForm');
					
				}
				<%-- 공백문자 들어올시 --%>
				var reg=/\s/;
				if(reg.test($('#password').val())){
					$('#passwordli4').removeClass('yesForm');
					$('#passwordli4').addClass('notForm');
				}
				//var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글체크
				
				
				if($('#password').val()){
					$('#passwordli1').addClass('yesForm');
					$('#passwordli1').removeClass('notForm');
					$('.passwordform').removeClass('ok');
					if($('#passwordli1').hasClass('yesForm')&&
							$('#passwordli2').hasClass('yesForm')&&
							$('#passwordli3').hasClass('yesForm')&&
							$('#passwordli4').hasClass('yesForm')){
						$('.passwordform').addClass('ok');
					}else{
						$('.passwordform').removeClass('ok');
					}
				}else{
					$('#passwordli1').removeClass('yesForm');
					$('#passwordli1').addClass('notForm');
					$('.passwordform').removeClass('ok');
				}
			});
		});
		
		// 이메일
		  $(function() {
        $('#select01').change(function() {
            if ($('#select01').val() == 'directly') {
                $('#textEmail').attr("disabled", false);
                $('#textEmail').val("");
                $('#textEmail').focus();
            } else {
                $('#textEmail').val($('#select01').val());
                $('#textEmail').attr("disabled", true);
            }
      	  })
   		 });
		$('#option01').hide()
		$('#emailli1, #emailli2, #emailli4').hide().addClass('notForm');
		$('#email').focus(function(){
			$('#emailli2,#emailli3').show();
			$('#email').on("propertychange change paste input", function() {
				var regEmail = /^([0-9a-zA-Z_\.-]+)@/;
				var result = regEmail.test($('#email').val());
				if($('#email').val()){
					$('#emailli1').hide();
					if(result==true){
						$('.emailform').addClass('ok');
						$('#emailli2,#emailli3').addClass('yesForm');
						$('#emailli2').removeClass('notForm');
					}else{
						$('#emailli1,#emailli2,#emailli3').removeClass('yesForm');
						$('#emailli3').addClass('yesForm');
					}
				}else{
					$('.emailform').removeClass('ok');
				}
			});
		});
		$('#email').focusout(function(){
			if($('#email').val()){
				$('#emailli1').addClass('yesForm');
				$('#emailli1').removeClass('notForm');
			}else{
				$('#emailli1').show();
				$('#emailli2,#emailli3').hide();
				$('#emailli1,#emailli2,#emailli3').removeClass('yesForm');
				$('#emailli1,#emailli2,#emailli3').addClass('notForm');
				$('.emailform').removeClass('ok');
			}
		});
		// 전화번호
		$('#email').focusout(function(){
			if($('#email').val()){
				$('#emailli1').addClass('yesForm');
				$('#emailli1').removeClass('notForm');
			}else{
				$('#emailli1').show();
				$('#emailli2,#emailli3').hide();
				$('#emailli1,#emailli2,#emailli3').removeClass('yesForm');
				$('#emailli1,#emailli2,#emailli3').addClass('notForm');
				$('.emailform').removeClass('ok');
			}
		});
		
		$('#phoneli1, #phoneli2, #phoneli3').hide();
		$('#phone').focus(function(){
			$('#phoneli2,#phoneli3').show();
			$('#phone').on("propertychange change paste input", function() {
			var patternPhone = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
			var result = patternPhone.test($('#phone').val());
			if($('#phone').val()){
				$('#phoneli1').hide();
				if(result==true){
					$('.phoneform').addClass('ok');
					$('#phoneli2,#phoneli3').addClass('yesForm');
					$('#phoneli2,#phoneli3').removeClass('notForm');
				}else{
					$('#phoneli1,#phoneli2,#phoneli3').removeClass('yesForm');
					$('#phoneli1,#phoneli2,#phoneli3').addClass('notForm');
				}
			}else{
				$('.phoneform').removeClass('ok');
			}
			});
		});
		$('#phone').focusout(function(){
			if($('#phone').val()){
				$('#phoneli1').addClass('yesForm');
				$('#phoneli1').removeClass('notForm');
			}else{
				$('#phoneli1').show();
				$('#phoneli2,#phoneli3').hide();
				$('#phoneli1,#phoneli2,#phoneli3').removeClass('yesForm');
				$('#phoneli1,#phoneli2,#phoneli3').addClass('notForm');
				$('.phoneform').removeClass('ok');
			}
		});
		$('#submit').click(function(){
			if($('.idform').hasClass('ok')==true){
				if(('.nameform').hasClass('ok')==true){
					if(('.passwordform').hasClass('ok')==true){
						if(('.emailform').hasClass('ok')==true){
							if(('.phoneform').hasClass('ok')==true){
								alert('회원 가입이 완료되었습니다. 로그인해주세요.');
							}
						}
					}
				}
			}
		});
	});
		/*
	function joinCheck(){
		var myform = document.myform;
		var joinid = myform.joinid.value;
		if(joinid==''){
			alert('이건 아니지');
			console.log('아이디 없쯤');
			return false;
		}
			return false;
	}
		//onsubmit="return false" 하면 눌러ㅆ을때 서브밋 방ㅈ
		*/
	</script>
</head>
<body>
	<div>
		<div id="topline">회원 가입</div>
	</div>
				<div class="panel-body" class="col-sm-<%=twelve%>">
					<form class="form-horizontal" name="myform" action="<%=yesForm%>" method="post" >
					<input type="hidden" name="command" value="meInsert">

						<div class="form-group">
							<div class="col-sm-<%=twelve %> inputtitle">아이디</div>
							<div class="col-sm-<%=twelve %>">
							<c:if test="${requestScope.joinid==null}">
								<input type="text" class="form-control" id="joinid"
									placeholder="아이디를 입력하세요." name="joinid" required>
							</c:if>
						
							<c:if test="${requestScope.joinid!=null&&requestScope.joinid!=undefined}">
								<input type="text" class="form-control" id="joinid" class="noid"
									value="${requestScope.joinid}" name="joinid" required>
							</c:if>
							</div>
							<div class="idform">
								<ul class="idform">
									<li id="idli1">* 아이디는 필수 입력 사항입니다.</li>
									<li id="idli2">* 사용 가능한 아이디입니다.</li>
									<li id="idli3">* 사용 불가능한 아이디입니다.</li>
								</ul>
							</div>
							<input type="hidden" name="id" value="${requestScope.joinid}">
							<div class="col-sm-<%=twelve %>">
								<input type="button" class="form-control" id="idcheck"
									value="아이디 중복 확인" name="idcheck">
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-sm-<%=twelve %> inputtitle">비밀번호</div>
							<div class="col-sm-<%=twelve %>">
								<input type="password" class="form-control" id="password"
									placeholder="비밀 번호 입력하세요." name="password"required>
							</div>
							<div id="passwordform">
								<ul class="passwordform">
									<li id="passwordli1">* 비밀번호는 필수 입력 사항입니다.</li>
									<li id="passwordli2">* 8자 이상 15자 미만 입력</li>
									<li id="passwordli3">* 특수문자는 1가지 이상(!,@,#,$ 만 가능)</li>
									<li id="passwordli4">* 영문/숫자/특수문자(공백제외)만 허용 가능, 2개이상 조합</li>
								</ul>
							</div>
						</div>

							
						<div class="form-group">
							
							<div class="col-sm-<%=twelve %> inputtitle">이름</div>
							<div class="col-sm-<%=twelve %>">
								<input type="text" class="form-control" id="name"
									placeholder="이름을 입력하세요." name="name"required>
							</div>
							<div class="nameform">
								<ul class="nameform">
									<li id="nameli1">* 이름은 필수 입력 사항입니다.</li>
								</ul>
							</div>
						</div>

<%-- /*<div class="form-group">
	
	<div class="col-sm-<%=twelve %> inputtitle">닉네임</div>
	<div class="col-sm-<%=twelve %>">
		<input type="text" class="form-control" id="nickname"
			placeholder="닉네임을 이름을 입력하세요." name="nickname"required>
	</div>
	<div class="nicknameform">
		<ul class="nicknameform">
			<li id="nicknameli1">* 닉네임은 필수 입력 사항입니다.</li>
			<li id="nicknameli2">* 닉네임은 15글자 이내로 적어주세요.</li>
		</ul>
	</div>
</div> --%>

			<div class="form-group">
				<div class="col-sm-<%=twelve%> inputtitle">이메일</div>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="email"
						placeholder="아이디를 입력해주세요." name="email" required>
				</div>
				<div class="col-sm-5">
					<input id="textEmail" type="text" placeholder="이메일을 선택하세요." value=""
					   name="email" required class="form-control">
				</div>
				<div class="col-sm-2">
					<select id="select01">
						<option value="" id ="option01">E-Mail 선택</option>
						<option value="directly" id="textEmail">직접 입력하기</option>
						<option value="@naver.com" id="naver.com">@naver.com</option>
						<option value="@hanmail.net" id="hanmail.net">@hanmail.net</option>
						<option value="@gmail.com" id="gmail.com">@gmail.com</option>
						<option value="@nate.com" id="nate.com">@nate.com</option>
					</select>

				</div>

				<div class="emailform">
					<ul class="emailform">
						<li id="emailli1">* 이메일은 필수 입력 사항입니다.</li>
						<li id="emailli3">* ex) abc@naver.com</li>
					</ul>
				</div>
			</div>


			<div class="form-group">
							<label class="col-sm-<%=twelve%> inputtitle" for="gender">성별</label>
							<div class="col-sm-<%=content%>" align="left">
								<label class="radio-inline">
										<input type="radio" id="gender1" name="gender" value="남자">남자
								</label>
								<label class="radio-inline">
										<input type="radio" id="gender2" name="gender" value="여자">여자
								</label>
							</div>
						</div>
						
						<div class="form-group">
							<!-- for 는 ~~를 위해서로 해석 -->
							<div class="col-sm-<%=twelve %> inputtitle">전화번호</div>
							<div class="col-sm-<%=twelve %>">
								<input type="text" class="form-control" id="phone"
									placeholder="ex) 010-1234-1234" name="phone"required>
							</div>
							<div class="phoneform">
								<ul class="phoneform">
									<li id="phoneli1">* 전화번호는 필수 입력 사항입니다.</li>
									<li id="phoneli2">* 전화번호는 하이픈(-)을 적어주세요.</li>
									<li id="phoneli3">* ex) 010-1234-1234</li>
								</ul>
							</div>
						</div>
						
						<div class="form-group">
							<!-- for 는 ~~를 위해서로 해석 -->
							<div class="col-sm-<%=twelve %> inputtitle">주소</div>
							<div class="col-sm-6" align="left">
								<input type="text" class="form-control postaddress addressbr" id="sample6_postcode" name="postcode"
									name="sample4_postcode" placeholder="우편주소"required>
							</div>
							<div class="col-sm-5 col-sm-offset-1 addressbr" align="left">
								<input type="button" class="btn btn-default form-control  postaddress" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							</div>
							<br>
							<div class="col-sm-<%=twelve %>  addressbr" align="left">
								<input type="text" class="form-control"  id="sample6_address" name="roadAddress" placeholder="도로명주소">
							</div>
							<br>
							<div class="col-sm-<%=twelve %> addressbr" align="left">
								<input type="text"  class="form-control" id="sample6_detailAddress" name="detailAddress"placeholder="상세주소"required>
							</div>
							<br>
							<div class="col-sm-<%=twelve %> addressbr" align="left">
								<input type="text"  class="form-control"id="sample6_extraAddress" name="extraAddress" placeholder="상세주소">
							</div>
						</div>
				
						
						<div class="btn-group btn-group-justified">
							<div class="btn-group">
								<button type="submit" id="submit" name="submit" onclick="joinCheck();"
									class="btn btn-default">가입하기</button>
							</div>
						</div>
					</form>
				</div>
			
			</div>
		</div>
	</div>
	
</body>
</html>