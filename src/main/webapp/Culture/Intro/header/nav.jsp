<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link href="https://webfontworld.github.io/suseong/SuseongBatang.css" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <!-- <iframe class="chat-bot" width="500" height="600" allow="microphone;" src="https://console.dialogflow.com/api-client/demo/embedded/c65ff504-e4cb-47e8-9743-18c5d9c4bb2d"></iframe> -->

    <script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
    <df-messenger
      intent="WELCOME"
      chat-title="Culture Place"
      agent-id="c65ff504-e4cb-47e8-9743-18c5d9c4bb2d"
      language-code="ko"
      wait-open=""
    ></df-messenger>

    <link rel="stylesheet" type="text/css" href="/CulturePlace/Intro/nav.css"> <!-- 스타일시트 -->
    <script src="/CulturePlace/Intro/nav.js"></script> <!-- 자바스크립트 -->

   

    <style type="text/css">


    </style>

    <script type="text/javascript">

    </script>
   
</head>

<body>
    <div class="common_header">
        <div class="common_navbar_logo"> <!-- 로고 -->
            <ul>
                <li class="common_logo"><a href="/CulturePlaceMain"><img id="common_logo_image" src="/Culture/images/Intro/header/logo.png"></a></li>
            </ul>
        </div>
        <div class="common_navbar_menu"> <!-- 최상위메뉴 -->
            <ul>
                <li>
                    <a href="/move/CulturePlace?playNum=0">
                        <p class="common_navbar_menu_p" id="Culturedb_hover">Culture DB</p>
                    </a>
                    
                </li>
                <li>
                    <a href="/CommunityMain">
                        <p class="common_navbar_menu_p" id="Community_hover">Community</p>
                    </a>
                </li>
                <li>
                    <a href="/chat/go">
                        <p class="common_navbar_menu_p" id="Chat_hover">Chat</p>
                    </a>
                </li>
            </ul>
        </div>
        <div class="common_navbar_login"> <!-- 로그인 회원가입  // 로그아웃 회원정보수정(or MyPage) -->
            <ul>
                <s:authorize access="isAnonymous()">
                    <li>
                        <a href="/users/login"><p class="common_navbar_login_p">로그인</p></a>
                    </li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <li>
                        <a href="/logout"><p class="common_navbar_login_p">로그아웃</p></a>
                    </li>
                </s:authorize>
                <s:authorize access="isAnonymous()">
                    <li>
                        <a href="/users/new"><p class="common_navbar_login_p">회원가입</p></a>
                    </li>
                </s:authorize>
            </ul>
        </div>
        <div class="common_navbar_menu_hover"> <!-- 하위메뉴 -->
            <ul class="common_navbar_menu_culturedb_hover">
                <li>
                    <a href="/move/CulturePlace?playNum=1"><p class="common_navbar_menu_culturedb_hover_p">뮤지컬</p></a>
                </li>
                <li>
                    <a href="/move/CulturePlace?playNum=0"><p class="common_navbar_menu_culturedb_hover_p">연극</p></a>
                </li>
                <li>
                    <a href="/move/CulturePlace?playNum=2"><p class="common_navbar_menu_culturedb_hover_p">콘서트</p></a>
                </li>
                <li>
                    <a href="/move/CulturePlace?playNum=3"><p class="common_navbar_menu_culturedb_hover_p">무용</p></a>
                </li>
                <li>
                    <a href="/move/CulturePlace?playNum=4"><p class="common_navbar_menu_culturedb_hover_p">클래식/오페라</p></a>
                </li>
                <li>
                    <a href="/move/CulturePlace?playNum=5"><p class="common_navbar_menu_culturedb_hover_p">국악</p></a>
                </li>
            </ul>
            <ul class="common_navbar_menu_community_hover">
                <li>
                <a href="/CommunityMain"><p class="common_navbar_menu_community_hover_p">자유게시판</p></a>
            </li>
            <li>
                <a href="/board/main"><p class="common_navbar_menu_community_hover_p">리뷰게시판</p></a>
            </li>
            <li>
                <a href="/TicketTradeMain"><p class="common_navbar_menu_community_hover_p">거래게시판</p></a>
            </li>
            </ul>
            <!--
            <ul class="common_navbar_menu_chat_hover">
                <li>
                    <a href="/chat/musical"><p class="common_navbar_menu_chat_hover_p">뮤지컬</p></a>
                </li>
                <li>
                    <a href="/chat/go"><p class="common_navbar_menu_chat_hover_p">연극</p></a>
                </li>
                <li>
                    <a href="/chat/go"><p class="common_navbar_menu_chat_hover_p">콘서트</p></a>
                </li>
                <li>
                    <a href="/chat/go"><p class="common_navbar_menu_chat_hover_p">무용</p></a>
                </li>
                <li>
                    <a href="/chat/go"><p class="common_navbar_menu_chat_hover_p">클래식/오페라</p></a>
                </li>
                <li>
                    <a href="/chat/go"><p class="common_navbar_menu_chat_hover_p">국악</p></a>
                </li>
            </ul>
            -->
        </div>
    </div>

    <!---------------------------------- 컨테이너 영역 ---------------------------------->

    <!---------------------------------- 컨테이너 영역 끝-------------------------------->

    <div class="common_footer"> <!-- 푸터 영역 -->
        <p class="footer_text">made by <span style="color: red">1조</span> 주병훈 김한나 권순헌 최근혁 김형규 민유성</p>
    </div>




    <!-- top 버튼-->
    <a href="#" class="btn_gotop btn-lg"><span class="glyphicon glyphicon-chevron-up"></span></a>


</body></html>