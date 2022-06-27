<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../main/header/nav.jsp"%> --%>    
<%@ include file="./../Member_Common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   html {
  height: 100%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  /* background: linear-gradient(#141e30, #243b55);  */
  background: white; 
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: #708090;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-box form button {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  background-color: #FFF5EE;
  color: black;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  margin-left: 105px;
  letter-spacing: 4px;
  
}

.login-box button:hover {
  background: black;
  color: white;
  border-radius: 5px;
  box-shadow: 0 0 5px snow,
              0 0 25px snow,
              0 0 50px snow,
              0 0 100px snow;
}

	.findli{
			
			font-size: 13px;
			display: inline-block;
			text-align: center;
			color: #FFF5EE
		}
		
	a{
		color: black;
	}
	

/* .login-box a span {
  position: absolute;
  display: block;
} */

/* .login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
} */

/* @keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
} */

/* .login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
} */

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

/* .login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
} */

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,100% {
    right: 100%;
  }
}

/* .login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
} */

/* @keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,100% {
    bottom: 100%;
  }
} */
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
   <div class="login-box">
  <h2>Login</h2>
  <form role="form" method="post" action="/members/login">
    <div class="user-box ">
      <input type="id" name="email" class="form-control" required="">
      <label th:for=""id"" class="idAddress" >Username</label>
    </div>
    <div class="user-box idpasswordborder">
      <input type="password" name="password" id="password" class="form-control" required="">
      <label th:for="password" id="password01">Password</label>
    </div>
   <p th:if="${loginErrorMsg}" class="error" th:text="${loginErrorMsg}"></p>
        <button class="btn btn-primary" id="join01">로그인</button>
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}">
        
        
		<div>
        <ul id="findul" class="idsearch">
			<li id="findli3" class="findli"><a href="">회원가입</a></li>
		</ul>
		</div>
  </form>
</div>
</body>
</html>


 