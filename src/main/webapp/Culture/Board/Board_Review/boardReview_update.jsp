<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../Board_Common/common.jsp" %>
<%
	int offset = 1; // 양식의 label 너비
	int content = twelve - 1*offset; //양식의 입력
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		#submit:hover {
			color: white;			
			background-color: #6255f6;
				}
	</style>
	<script type="text/javascript">
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
		}
	</script>
</head>
<body>
<br><br>
	<div class="container" align="center">
		<div class="col-sm-offset-<%=offset %> col-sm-<%=content%>">
			<div class="panel">
				<div class="panel-heading">
				<br><br>
					<h2>후기인증</h2>
				</div>
				<div class="panel-body" class="col-sm-<%=twelve%>">
					<form name= "join" class="form-horizontal" action="<%=yesForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="boardReview">

			
						<div class="form-group">
							<div class="col-sm-<%=twelve %>">
								<select class="form-control" id="b_category" name="b_category" >
									<option value="">----카테고리를 선택해주세요----</option>		
								    <option value="play">연극</option>								    
								    <option value="musical">뮤지컬</option>	
								    <option value="movie">영화</option>							    
								    <option value="concert">콘서트</option>
								    <option value="classic">클래식/오페라</option>	
								    <option value="gugak">국악</option>	
								    <option value="dance">무용</option>							    
							  	</select>
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-sm-<%=twelve %>">
								<input type="text" class="form-control" id="b_title"
									placeholder="제목을 입력해주세요." name="b_title" value="">
							</div>
						</div>
						<!-- ^[0-9]*$ --> 
						
						
						<div class="form-group" >
							<div class="col-sm-<%=twelve %>">
								<textarea class="form-control" rows="10" id="board_content" name="board_content" placeholder="내용을 입력해주세요" required></textarea>
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-sm-<%=twelve%>">
								<input type="file" class="form-control" id="b_image" name="b_image">	
							</div>
						</div>
						
						
						<div class="btn-group btn-group-justified">
							<div class="btn-group">
								<button type="submit" id="submit" name="submit"
									class="btn btn-default" onclick="return checkForm();">수정하기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>









