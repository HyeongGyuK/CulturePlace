<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../Board_Common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#board_submit').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			
			$('#boardBackBtn').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			$('#board_content').val().replace(/\n/g, "<br>");
		});
		
		function checkForm(){
			var b_title = document.join.b_name.value;
			if(b_title == ""){
				alert('제목을 입력해주세요.');
				document.join.b_name.focus();
				return false;
			}
			
			var b_category = document.join.b_name.value;
			if(b_category == ""){
				alert('카테고리를 선택해주세요.');
				document.join.b_name.focus();
				return false;
			}
			
			var b_image = document.join.b_image.value;
			if(b_image == ""){
				alert('이미지를 첨부해 주세요.');
				document.join.b_image.focus();
				return false;
			}
			
			function category_change()(){
				var target = document.getElementById("categoryBox");
				document.reviewForm.className.value = target.options[target.selectedIndex].value;//?
			}
		}
	</script>

	<style type="text/css">
		#title{padding-top:56px; padding-left:10px;margin-left:25%;  width:60%; height:105px; color:#666666; font-weight: 600; font-size: 30px;border-bottom: 3px solid #cccccc;}
		
	</style>
</head>
<body>
	<div>
		<h2 id=title>게시글 수정</h2>
	</div>
	
	<div style="width: 60%; margin-left: 25%; padding-left: 10px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<td width="10%" id="thTitle">제목</td>
					<td width="60%" colspan="3" width="100%"><input type="text"
						class="form-control" name="title"
						value="${requestScope.boardInfo.title }"></td>
					<td width="10%">카테고리</td>
					<td width="20%"><input type="hidden" name="b_category"
						id="b_category" value="${requestScope.boardInfo.b_category }"
						readonly> <select id="categoryBox" name="categoryBox"
						onchange="category_change()">
							<option>선택</option>
							<c:forEach var="lists" items="${requestScope.classLists }"
								varStatus="status">
								<c:if test="${lists == requestScope.boardInfo.className }">
									<option value="${requestScope.boardInfo.className }"
										selected="selected">
										<c:out value="${lists }" />
									</option>
								</c:if>
								<option value="${lists }">
									<c:out value="${lists }" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td width="10%">작성자</td>
					<td width="50%">${requestScope.boardInfo.writer } <input
						type="hidden" name="writer"
						value="${requestScope.boardInfo.writer }">
					</td>
					<td width="10%">작성 일자</td>
					<td width="10%">${requestScope.boardInfo.regDate }</td>
					<td width="10%">조회수</td>
					<td width="10%">${requestScope.boardInfo.viewCnt } <input
						type="hidden" name="viewCnt"
						value="${requestScope.boardInfo.viewCnt }">
					</td>
				</tr>
			</thead>
		</table>

		<table class="table table-striped" id="content_table">
			<tbody>
				<tr>
					<%
						pageContext.setAttribute("crcn", "\r\n");
						pageContext.setAttribute("br", "<br/>");
					%>
					<td colspan="6"><p id="text"></p>완전 재밌어요~~
						${fn:replace(bean.content, crcn, br )}</td>
				</tr>
				<tr>
					<%
						String fileName = (String)request.getAttribute("fileName");
					%>
					<td colspan="6">
						<img alt=""
						src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"
						style="width: 500px; height: 500px;">
					</td>
				</tr>
			</tbody>
		</table>

		<table class="table table-striped" id="comment_table">
			<c:choose>
				<c:when test="${empty requestScope.commentLists }">
					<tr>
						<td colspan="3"><p>댓글이 없습니다.</p></td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach var="comment_bean"
						items="${requestScope.commentLists }">
						<tr>
							<td width="10%">${comment_bean.nickname }</td>
							<td width="75%"><p id="comment_p">${comment_bean.fComment }</p></td>
							<td width="10%">${comment_bean.regDate }</td>
							<c:if
								test="${sessionScope.loginfo.nickname == comment_bean.nickname }">
								<td width="5%"><a href="#" id="deleteComment"
									style="display: block"
									onclick="deleteCommentFunction(${comment_bean.commentNum})">삭제</a></td>
							</c:if>
							<c:if
								test="${sessionScope.loginfo.nickname != comment_bean.nickname }">
								<td width="5%"><a href="#" id="deleteComment"
									style="display: none">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

		<form action="<%=noForm %>boardReviewComment" method="post"
			id="commentForm" onsubmit="return false">
			<p>댓글작성</p>
			<div class="form-group">
				<textarea style="width: 92%" rows="2" id="comment_area"
					name="member_comment" placeholder="댓글을 작성해주세요"></textarea>
				<input type="hidden" id="board_nickname" name="nickname"
					value=${sessionScope.loginfo.nickname }> <input
					type="hidden" id="board_num" name="boardNum"
					value=${bean.boardNum }>
				<button type="submit" class="btn btn-primary pull-right"
					id="comment_submit"
					style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; font-weight:bold" >댓글달기</button>
			</div>
		</form>

		<div id="boardDetailBtn" align="right">
			<a href="./../board_Review/boardReview_main.jsp"
				class="btn btn-primary pull-right" id="boardDeleteBtn"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>삭제</b></a>
			<a href="./../board_Review/boardReview_update.jsp"
				class="btn btn-primary pull-right" id="boardUpdateBtn"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>수정</b></a>
			<a href="./../board_Review/boardReview_main.jsp"
				class="btn btn-primary pull-right" id="goToBoardPage"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>돌아가기</b></a>
		</div>
	</div><br><br><br><br><br>
	
</body>
</html>