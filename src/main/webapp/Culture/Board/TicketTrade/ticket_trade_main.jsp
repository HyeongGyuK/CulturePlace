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
			
			.background-colors{background-color: yellow;}
		</style>
	
	<script th:inline="javascript">
		$(document).ready(function(){
			// 로그인 구현 해야함.
			/*$('#trade_write').click(function(){
				if(${whologin == 0}){
					alert('로그인 하셔야 게시글 작성이 가능합니다.');
					$("#trade_write").attr("href", "meLogin");
				}
			});*/

			$('[value="판매중"]').css({'background-color':'LightBlue','cursor':'default'});
			$('[value="판매완료"]').css({'background-color':'lightgray','color':'black','cursor':'default'});
			$('[value="구매중"]').css({'background-color':'LightCoral','cursor':'default'});
			$('[value="구매완료"]').css({'background-color':'lightgray','color':'black','cursor':'default'});
			
			$('.tradeList').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#trade_write').hover(function(){
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
		#trade{border-collapse: collapse; width:100%;}
		#tradeColumn{
			text-align: center; height: 70px;
			border-bottom: 1px solid gray;
			border-top: 3px solid gray;
		    background-color: lightyellow;
		    font-weight: bold; font-size: 15px;
		}
		.tradeList{
 			height: 50px;
			text-align: center;
			border-bottom: 1px solid gray;
			background-color: #FFFFFF;
		}
		
		.tradeNo{width: 10%;}
		.tradeStatus{width: 10%;}
		.tradeTitle{width: 30%;}
		.tradeWriter{width: 20%;}
		.tradeDate{width: 20%;}
		.tradeReadHit{width: 10%;}
		
		.tradeList :nth-child(3){text-align: left;}
		.tradeList a{color:black;}
		
	</style>
</head>
<body>
	<div id="template">
		<div id="container">
			<div id="title">
				<h2 style="font-weight: bold;">
					티켓 거래 게시판
				</h2>
			</div>
			
			<table id="trade">
				<tr id="tradeColumn">
					<td class="tradeNo">No</td>
					<td class="tradeStatus">상태</td>
					<td class="tradeTitle">제목</td>
					<td class="tradeWriter">작성자</td>
					<td class="tradeDate">작성일자</td>
					<td class="tradeReadHit">조회수</td>
				</tr>
				<c:forEach var="i" begin="1" end="10">
					<tr class="tradeList">
						<td><c:out value="${i}"/>${requestScope.totalCount - ((requestScope.pageInfo.pageNumber - 1) * requestScope.pageInfo.pageSize + status.index) }</td>
						<c:if test="${i == 1}">
							<td>
								<input class="ticketStatus" type="button" style="border: 1px solid black; border-radius: 5px; padding: 2px; vertical-align: middle; width: 60%;" value="판매중"></input>
							</td>
						</c:if>
						<c:if test="${i == 2}">
							<td>
								<input class="ticketStatus" type="button" style="border: 1px solid black; border-radius: 5px; padding: 2px; vertical-align: middle; width: 60%;" value="판매완료"></input>
							</td>
						</c:if>
						<c:if test="${i == 3}">
							<td>
								<input class="ticketStatus" type="button" style="border: 1px solid black; border-radius: 5px; padding: 2px; vertical-align: middle; width: 60%;" value="구매중"></input>
							</td>
						</c:if>
						<c:if test="${i > 3}">
							<td>
								<input class="ticketStatus" type="button" style="border: 1px solid black; border-radius: 5px; padding: 2px; vertical-align: middle; width: 60%;" value="구매완료"></input>
							</td>
						</c:if>
						<td><a href="/TicketTrade/ticket_trade_detail">안녕하세요 재미있네요 하하하</a></td>
						<td>${bean.writer }김두환</td>
						<td>${bean.regDate }2022-05-21</td>
						<td>${bean.viewCnt }100</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10" align="center">
						<form class="form-inline" action="" method="get">
							<div class="form-group">
								<select class="form-control btn-xs" name="mode" id="mode">
									<option value="all">-- 거래전체
									<option value="writer">판매중
									<option value="title">판매완료
									<option value="writer">구매중
									<option value="title">구매완료
								</select>
							</div>
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
							
							<a href="/TicketTrade/ticket_trade_write" class="btn btn-primary pull-right" id="trade_write" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB; box-sizing:border-box; margin-top: 10px;"><b>글쓰기</b></a>
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
