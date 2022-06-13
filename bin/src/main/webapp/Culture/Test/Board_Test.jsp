<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function() {
		
		});
		
		  function search(){
	        	if($('#mode').val() == 'all'){
	        		alert('검색 항목을 선택해 주세요.');
	        		return false;
	        	}
	        }
	        
	        function searchAll(){
	        	location.href='<%=noForm%>boList';
	        }
	        
	        function writeForm(){
	        	location.href='<%=noForm%>boInsert';
	        }
	</script>
</head>
<body id="bootstrap-overrides">
	<div class="prinsert-main">
		<h1>연극 상세저</h1>
		<div class="pri-header-point"></div>
		<div id="point-btn">
			<c:if test="${whologin != 0}">
			<a href="<%=noForm%>boInsert"><button class="btn btn-default btn-info" type="button" >글쓰기</button></a>
			</c:if>
		</div>
	</div>
	
	<%-- 게시판 페이지 시작 --%>
	<div class="prinsert-header">
		<c:forEach var="bean" items="${requestScope.lists}">
			<div class="pri-00">
				<div class="pri-01"> 
					<c:choose>
						<c:when test="${bean.bcategory == 'Milk'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/bomilk.jpg" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Egg'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/boegg.png" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Chicken'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/bochicken.jpg" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Pork'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/bopork.jpg" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Beef'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/bobeef.jpg" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Seafood'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/boseafood.jpg" width="100%" height="100%"></c:when>
						<c:when test="${bean.bcategory == 'Mealkit'}"><img class="pri01-img" alt="" src="<%=contextPath%>/images/bomealkit.jpg" width="100%" height="100%"></c:when>
						<c:otherwise><img class="pri01-img" alt="" src="<%=contextPath%>/images/bobaby.jpg" width="100%" height="100%"></c:otherwise>
					</c:choose>
				</div>
				<div class="pri-01-wrihu"><p id="wri-p">${bean.writer}</p></div>
				<div class="pri-01-come">
					<div class="pri-01-subject">
						<p id="sub-h">${bean.subject}</p></div>
					<div class="pri-01-cont">
						<p id="cont-p">${bean.content}</p>
					</div>
				</div>
				<div class="rehit"><h2>${bean.readhit}</h2></div>
				<div class="bolist-bnt1">
					<c:if test="${sessionScope.loginfo.cId == bean.writer }">
						<a href="<%=noForm%>boUpdate&no=${bean.no}"><button class="bolist-bnt" type="button" name="" value="">수정</button></a>
					</c:if>
					<c:if test="${sessionScope.loginfo.cId != bean.writer }">수정</c:if>	
				</div>
				<div class="bolist-bnt2">
					<c:if test="${sessionScope.loginfo.cId == bean.writer }">
						<a href="<%=noForm%>boDelete&no=${bean.no}"><button class="bolist-bnt" type="button" name="" value="">삭제</button></a>
					</c:if>
	        		<c:if test="${sessionScope.loginfo.cId != bean.writer }">삭제</c:if>
				</div>
			</div>	
		</c:forEach>
		<div class=pagenum>
			<%--페이징 --%>
			<div class="boform-in">
				<form class="form-inline" action="<%=yesForm %>" method="get">
			    		<input type="hidden" name="command" value="boList">
			    		<input type="hidden" name="pageNumber1" value="${requestScope.pageInfo.pageNumber}">
			    		<input type="hidden" name="pageSize1" value="${requestScope.pageInfo.pageSize}">
			    		
			    		<div class="form-group">
			    			<select class="form-control btn-xs" name="mode" id="mode">
			    				<option value="all">---검색할 항목을 선택하세요.
			    				<option value="writer">작성자
			    				<option value="subject">글제목
			    				<option value="content">글내용
			    			</select>
			    		</div>
			    		
			    		
			    		<div class="form-group">
			    			<input type="text" class="form-control btn-xs" id="keyword"
				    					   name="keyword" placeholder="검색 키워드 입력">
				    		</div>
				    		<button class="btn btn-default" type="submit"  onclick="return search();">검색</button>
			    			<button class="btn btn-default" type="button" onclick="searchAll();">전체 검색</button>
				    		<p class="form-control-static">${requestScope.pageInfo.pagingStatus}</p>
					</form>
				</div>
	
	  		<div class="pagenum-01" >${requestScope.pageInfo.pagingHtml}</div>
	  	</div>	
	</div>
	<footer></footer>
	
	<script type="text/javascript">
		/*사용자가 검색하기 위해서 선택한 항목을 그대로 보여 주기*/
		$('#mode option').each(function(){
			if($(this).val() == '${requestScope.pageInfo.mode}'){
				$(this).attr('selected', 'selected')
			}
		});
		$('#keyword').val('${requestScope.pageInfo.keyword}');
	</script>
	
</body>
</html>