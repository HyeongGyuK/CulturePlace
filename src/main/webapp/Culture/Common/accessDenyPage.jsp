<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko" >
    <head>
    	<title>1조파이팅</title>
        <meta charset="UTF-8" />

    </head>

    <body>
        <script>
        	alert('로그인 후 이용 가능합니다.');
        	location.href = "<c:url value='/users/login' />";
        </script>
    </body>
</html>