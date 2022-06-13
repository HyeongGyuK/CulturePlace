<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "./common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
		.sidevartop{border-top-left-radius: 5px; border-top-right-radius:5px; }
		.sidevarbottom{border-bottom-left-radius: 5px; border-bottom-right-radius:20px; }
		.sidevar input { width: 150px; border:1px solid #f2f2f2; height:40px; background-color:#ffffff; }
		.sidevar input {border-bottom:1px solid #f2f2f2; text-decoration: none;}
		.sidevar input {color:#666666;}
		.sidevar input:hover{background-color:#fafaf7; color:#57002b; font-weight:bold; }
		.varvar{height:400px;display: inline-block; float: left; width:230px; padding-left:0;}
		.sticky_box{
			width:152px;
			position:sticky;
			top:0px;
			height:500px;
			padding-top:100px;
			margin-top:0;
			margin-left:10%;
			margin-right:3%;
			display: inline-block;
			}
		.sidevar input.thisPage{background-color:#57002b; color:#ffffff;}
		#topline{padding-top:56px; padding-left:10px;margin-left:25%;  width:60%; height:105px; color:#666666; font-weight: 600; font-size: 30px;border-bottom: 3px solid #cccccc;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('.sidevar').children(':first').addClass('sidevartop');
		$('.sidevar').children('7').addClass('sidevarbottom');
	
		$('#memberUpdate').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/memberUpdate.jsp";
		});
		$('#classOrderList').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/classOrderList.jsp";
		});
		$('#place').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/place.jsp";
		});
		$('#QnA').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/QnA.jsp";
		});
		$('#review').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/review.jsp";
		});
		$('#likeIt').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/likeIt.jsp";
		});
		$('#productOrderList').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/productOrderList.jsp";
		});
		$('#mycart').click(function(){
			location.href="<%=contextPath%>/bakery/myPage/mycart.jsp";
		});
		
	});
</script>
</head>
<body>
				<div class="varvar sticky_box">
					<form class="sidevar" action="<%=yesForm%>" method="post">
						<%--상품 주문내역 : 회원 id, 구매 상품 pnum(구매한 내역은 session에 바인딩) --%>
						<input type="button" class="thisPage" id="productOrderList" name="productOrderList" value="상품 주문 내역">
						<%--클래스 신청 내역 : 주문자, 클래스 신청 내역(클래스 신청 내역도 session에 바인딩 --%>
						<input type="button" id="classOrderList" name="classOrderList" value="클래스 신청 내역">
						<input type="button"  id="mycart" name="mycart" value="장바구니">
						<%--찜한 상품 : 주문자, 주문자가 하트찜꽁 해놓은 걸 session에 바인딩--%>
						<input type="button" id="likeIt" name="likeIt" value="찜한 상품">
						<%--배송지 관리 : 주문자, 주문자의 배송지(회원id_session) --%>
						<input type="button" id="place" name="place" value="배송지 관리">
						<%--상품 후기 : 주문자가 작성한 상품후기만! 회원(id), 구매 상품(pnum) --%>
						<input type="button" id="review" name="review" value="상품 후기">
						<%-- 상품 문의 : 회원(id), 상품 번호(pnum) --%>
						<input type="button" id="QnA" name="QnA" value="상품 문의">
						
						<input type="button" id="memberUpdate" name="memberUpdate" value="회원 정보 수정">
					
						<input type="hidden" name="id" value="${sessionScope.loginfo.id}">
						<input type="hidden" id="gotopage" name="command" value="">
						<%--
						<input type="hidden" name="pnum" value="${sessionScope.loginfo.id}">
						
						 --%>
					
					</form>
				</div>
				<div>
					<div  id="topline">
						회원 리스트
					</div>
				</div>

</body>
</html>