<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../Intro/header/nav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
		
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
		<style type="text/css">
			a{text-decoration: none; color: black;}
			
			.pagination .active a{background-color:#551527; border:1px solid #500020;}
			.pagination .active a:hover{background-color:#773849; border:1px solid #500020;}
			
		</style>
	
	<script th:inline="javascript">
		$(document).ready(function(){
			// 로그인 구현 해야함.
			/*$('#board_write').click(function(){
				if(${whologin == 0}){
					alert('로그인 하셔야 게시글 작성이 가능합니다.');
					$("#board_write").attr("href", "meLogin");
				}
			});*/
			
			$('.boardList').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#board_write').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
		});
	</script>
	<!-- flex-direction: column; 나중에 div 내부에 추가 할 수 있으니 남겨둠 -->
	<style type="text/css">
		#template{
			display: flex; width: 100%;
			justify-content: center; margin: 150px 0px 150px 0px;
		}
		#container{
			 width: 60%;
		}
		#title{
			border-bottom: 4px solid gray;
			width:100%;
		}
		#board{border-collapse: collapse; width:100%;}
		#boardColumn{
			text-align: center; height: 70px;
			border-bottom: 1px solid gray;
			border-top: 3px solid gray;
		    background-color: lightyellow;
		    font-weight: bold; font-size: 15px;
		}
		.boardList{
 			height: 50px;
			text-align: center;
			border-bottom: 1px solid gray;
			background-color: #FFFFFF;
		}
		
		.boardNo{width: 10%;}
		.boardTitle{width: 40%;}
		.boardWriter{width: 20%;}
		.boardDate{width: 20%;}
		.boardReadHit{width: 10%;}
		
		#notice{
			width: 98%; border-radius: 7px;
			margin: 1px; margin: 5px auto;
		}
		
		#noticeTitle{
			text-align: center; font-weight: bold;
			margin: 0; inline-height: 28px; padding: 2px;
			border-bottom: 2px solid gray; font-size: 20px;
		}
		
		#noticeColumn{
			font-size: 15px; font-weight: bold;
			border-bottom: 2px solid gray; text-align: center;
		}
		
		.noticeList{
			width:50%; height: 20px;
			text-align: center; margin-top: 2px;
			border-bottom: 1px solid gray; font-size: 14px;
		}
		
		.boardList :nth-child(2), .noticeList :nth-child(2){text-align: left;}
		.boardList a, .noticeList a{color:black;}
		
	</style>
</head>
<body>
	<div id="template">
		<div id="container">
			<div id="title">
				<h2 style="font-weight: bold;">
					자유 게시판
				</h2>
			</div>
			
			<div id="notice">
				<div id="noticeTitle">공지사항</div>
				<table style="width:100%;">
					<tr id="noticeColumn">
						<td width: 10%;>No</td>
						<td width: 40%;>제목</td>
						<td width: 20%;>작성자</td>
						<td width: 20%;>작성 일자</td>
						<td width: 10%;>조회수</td>
					</tr>
					<c:forEach var="i" begin="1" end="3">
						<tr class="noticeList">
							<td><c:out value="${i}"/>${requestScope.totalCount - ((requestScope.pageInfo.pageNumber - 1) * requestScope.pageInfo.pageSize + status.index) }</td>
							<td><a href="/BoardFree/board_notice_detail">공지사항</a></td>
							<td>${bean.writer }관리자</td>
							<td>${bean.regDate }2022-05-21</td>
							<td>${bean.viewCnt }100</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<table id="board">
				<tr id="boardColumn">
					<td class="boardNo">No</td>
					<td class="boardTitle">제목</td>
					<td class="boardWriter">작성자</td>
					<td class="boardDate">작성일자</td>
					<td class="boardReadHit">조회수</td>
				</tr>
				<c:forEach var="i" begin="1" end="10">
					<tr class="boardList">
						<td><c:out value="${i}"/>${requestScope.totalCount - ((requestScope.pageInfo.pageNumber - 1) * requestScope.pageInfo.pageSize + status.index) }</td>
						<td><a href="/BoardFree/board_free_detail">안녕하세요 재미있네요 하하하</a></td>
						<td>${bean.writer }김두환</td>
						<td>${bean.regDate }2022-05-21</td>
						<td>${bean.viewCnt }100</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10" align="center">
						<form class="form-inline" action="" method="get">
							<input type="hidden" name="command" value="expatationMain">
							<input type="hidden" name="pageNumber1" value="${requestScope.pageInfo.pageNumber }">
							<input type="hidden" name="pageSize1" value="${requestScope.pageInfo.pageSize }">
							<div class="form-group">
								<select class="form-control btn-xs" name="mode" id="mode">
									<option value="all">-- 검색할 항목을 선택하세요.
									<option value="writer">작성자
									<option value="title">제목
								</select>
							</div>
							
							<div class="form-group">
								<input type="text" class="form-control btn-xs" id="keyword"
									name="keyword" placeholder="검색 키워드 입력">
							</div>
							<button class="btn btn-default" type="submit" onclick="return search();">검색</button>
							
							<button class="btn btn-default" type="button" onclick="searchAll();">전체 검색</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<p class="form-control-static"></p>
							
							<a href="/BoardFree/board_free_write" class="btn btn-primary pull-right" id="board_write" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB; box-sizing:border-box; margin-top: 10px;"><b>글쓰기</b></a>
						</form>
					</td>
				<tr>
				<tr>
					<td colspan="10" align="center">
						<div align="center">
							${requestScope.pageInfo.pagingHtml }
						</div>
					</td>
				</tr>
			</table>
			<script type="text/javascript">
			$('#mode option').each(function(){
				if($(this).val() == '${requestScope.pageInfo.mode}'){
					$(this).attr('selected', 'selected');
				}
			});
			
			$('#keyword').val('${requestScope.pageInfo.keyword}');
		</script>
		</div>
	</div>
</body>
</html>