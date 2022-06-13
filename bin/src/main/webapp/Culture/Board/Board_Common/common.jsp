<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
 	// contextPath : 해당 애플리케이션의 이름(=컨덱스트 이름)
 	String contextPath = request.getContextPath();
 
 	// 서블릿 매핑 이름
 	String mapping = "/Culture";
 	// url 패턴
 
 	// 폼 태그에서 사용할 공용 변수
 	String yesForm = contextPath+mapping;

 	// 폼이 없는 <a>,<img> 태그에서 사용할 공용 변수
 	String noForm=contextPath+mapping+"?command=";
%>
<c:set var="whologin" value="0" /> 
<!-- empty 는 값이 있는지 없는지 확인할 때 사용 -->
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.id =='admin'}">
		<c:set var="whologin" value="2"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.id !='admin'}">
		<c:set var="whologin" value="1"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.id ==null}">
		<c:set var="whologin" value="0"/>
	</c:if>
</c:if>
<%
 	int twelve = 12; //for Bootstrap
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		body{margin:0;}
		#headerTop{background-color: #6255f6; hieght: 300px; box-sizing: border-box; display: inline-flex; display: flex;}
		.slide{height: 300px; width: 500px; border: 1px solid red;}
		#headerBottom{
				display: inline-flex; width: 100%; background-color: #6255f6; 
				box-sizing: border-box; display: flex;
			}
		.categorys{list-style: none; display: inline-flex;}
		.categorys div{font-size: 30px; border: 1px solid black;}
		.personalCol{list-style: none; display: inline-flex; align-self: right;}
		.personalCol div{font-size: 30px; border: 1px solid black;}
	</style>
</head>
<body>
	<header>
		<div id="headerBottom">
			<div id="leftDiv">
				<div id="logo">
					<img alt="" src="">
					<span style="font-size: 30px">로고</span>
				</div>
			</div>
			<div id="centerDiv">
				<ul class="categorys">
					<li>
						<a>
							<div></div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
				</ul>
			</div>
			<div id="rightDiv">
				<ul class="personalCol">
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
					<li>
						<a>
							<div>
								
							</div>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>