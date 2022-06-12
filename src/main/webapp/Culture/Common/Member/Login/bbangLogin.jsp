<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../layouts/layout1.jsp" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.container{margin-top: 70px; margin-bottom: 100px;}
		.idinline{display: inline-block;}
		#id,#password{border: none; box-shadow: none; width:100%;}
		.idpasswordborder{border: #dadada solid 1px; border-radius: 5px;  margin-top:15px;}
		form{padding-left: 15px; padding-right: 15px;}
		#navtab li{background:none; width:100%;}
		#navtab li a{ width:100%; text-align: center;}
		.margin-top{margin-top:10px;}
		#navtab{border-left:#dadada solid 1px; border-right:#dadada solid 1px; border-radius: 10px;  padding-right: 0px;}
		#id, #password{width:400px;}
		.buttonwidth{width:100%;}
		.findli{
			list-style: none; display: inline-block; 
			padding-left: 10px; padding-right: 10px; 
			border-left:#888888 solid 1px; font-size: 12px;
			}
		#findli1{border:none;}
		
		#findul div{margin:0 auto; width:260px; padding-top:20px; color:#888888;}
		.loginli ,.loginli a{color:#555555;}
		.nopadding{padding:0;}
		button.buttonwidth:hover{background-color:#57002b; color:#ffffff;}
		input[type=text], button{height:40px; }
	</style>
	
	<script type="text/javascript">
		$('.idpasswordborder').addClass('idpasswordborder');
		if(${requestScope.messagelogin=="아이디 또는 패스워드가 틀렸습니다."}){
			alert('${requestScope.messagelogin}');
			console.log('${requestScope.messagelogin}');
		}else{
			console.log('로그인 페이지 이동');
		}
		if(${requestScope.joinmessage!=null}){
			alert('${requestScope.joinmessage}');
		}
	</script>
</head>
<body>
	<br><br>
	<div class="container">
		<ul id="navtab" class="nav nav-tabs col-sm-offset-3 col-sm-6 ">
			<!-- 현재 페이지에 관한 주소 href 에 넣기 -->
			<li class="active loginli"><a href="./memberLogin.jsp"> </a></li>
			<form class="form-horizontal idpasswordform" action="<%=yesForm%>" method="post">
				<input type="hidden" name="command" value="meLogin">
				<div class="form-group">
					<div id="margin-top"
						class="col-sm-offset-1 col-sm-10 idpasswordborder">
						<div class="idinline">
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<div class="idinline">
							<input type="text" class="form-control" id="id" placeholder=" 아이디"
								name="id">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-10 idpasswordborder">
						<div class="idinline">
							<span class="glyphicon glyphicon-off"></span>
						</div>
						<div class="idinline">
							<input type="password" class="form-control" id="password"
								placeholder=" 비밀번호" name="password">
						</div>
					</div>
				</div>
			
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-10 nopadding">
						<button type="submit" class="buttonwidth btn btn-default">로그인</button>
					</div>
				</div>
			</form>
		</ul>
		<div>
			<ul id="findul" class="col-sm-offset-3 col-sm-6">
				<div>
					<li id="findli1" class="findli"><a href="<%=noForm%>meFindPassword">비밀번호 찾기</a></li>
					<li id="findli2"class="findli"><a href="<%=noForm%>meFindId">아이디 찾기</a></li>
					<li id="findli3" class="findli"><a href="<%=noForm%>meInsert">회원가입</a></li>
				</div>
			</ul>
		</div>
	</div>
</body>
</html>