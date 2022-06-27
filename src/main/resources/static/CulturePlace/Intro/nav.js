// 스크롤내리면 네비바 색 변경
        $(document).ready(function() {
            $(window).scroll(function() {
                if ($(this).scrollTop() > 0) {
                    $('.common_header').addClass('active_header');
                    $('.common_navbar_menu_p').addClass('active_menu');
                    $('.common_navbar_login_p').addClass('active_menu');
                } else {
                    $('.common_header').removeClass('active_header');
                    $('.common_navbar_menu_p').removeClass('active_menu');
                    $('.common_navbar_login_p').removeClass('active_menu');
                }
            });
            
            
        });
        
        
        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        
//        $(document).ready(function(){
//            $("#Culturedb_hover").hover(function(){
//                $(".common_navbar_menu_hover").css({"background":"black", "display":"block", "text-align":"center"});
//                $(".common_navbar_menu_culturedb_hover").css({"color":"white", "display":"block"});
//            }, function(){
//                $(".common_navbar_menu_hover").css({"background":"white", "display":"none"});
//                $(".common_navbar_menu_culturedb_hover").css("display","none");
//            })
//            
//            $("#Community_hover").hover(function(){
//                $(".common_navbar_menu_hover").css({"background":"black", "display":"block", "text-align":"center"});
//                $(".common_navbar_menu_community_hover").css({"color":"white", "display":"block"});
//            }, function(){
//                $(".common_navbar_menu_hover").css({"background":"white", "display":"none"});
//                $(".common_navbar_menu_community_hover").css("display","none");
//            })
//        });
        
        $(document).ready(function(){
            $("#Culturedb_hover").mouseenter(function(){
                $(".common_navbar_menu_hover").css({"background":"black", "display":"block", "text-align":"center"});
                $(".common_navbar_menu_culturedb_hover").css({"display":"block"});
                $(".common_navbar_menu_culturedb_hover_p").css({"color":"white", "display":"block"});
                $(".common_navbar_menu_community_hover").css("display","none");
                $(".common_navbar_menu_chat_hover").css("display","none");

                $('.common_header').addClass('hover_header');
                $('.common_navbar_menu_p').addClass('hover_menu');
                $('.common_navbar_login_p').addClass('hover_menu');
            });
            
            $(".common_header").mouseleave(function(){
                $(".common_navbar_menu_hover").css({"display":"none"});
                
                $('.common_header').removeClass('hover_header');
                $('.common_navbar_menu_p').removeClass('hover_menu');
                $('.common_navbar_login_p').removeClass('hover_menu');
            });

            
            $("#Community_hover").mouseenter(function(){
                $(".common_navbar_menu_hover").css({"background":"black", "display":"block", "text-align":"center"});
                $(".common_navbar_menu_community_hover").css({"display":"block"});
                $(".common_navbar_menu_community_hover_p").css({"color":"white", "display":"block"});
                $(".common_navbar_menu_culturedb_hover").css("display","none");
                $(".common_navbar_menu_chat_hover").css("display","none");

                $('.common_header').addClass('hover_header');
                $('.common_navbar_menu_p').addClass('hover_menu');
                $('.common_navbar_login_p').addClass('hover_menu');
            });
            
            $(".common_header").mouseleave(function(){
                $(".common_navbar_menu_hover").css({"display":"none"});
                
                $('.common_header').removeClass('hover_header');
                $('.common_navbar_menu_p').removeClass('hover_menu');
                $('.common_navbar_login_p').removeClass('hover_menu');
            });

            $("#Chat_hover").mouseenter(function(){
                $(".common_navbar_menu_hover").css({"background":"black", "display":"block", "text-align":"center"});
                $(".common_navbar_menu_chat_hover").css({"display":"block"});
                $(".common_navbar_menu_chat_hover_p").css({"color":"white", "display":"block"});
                $(".common_navbar_menu_culturedb_hover").css("display","none");
                $(".common_navbar_menu_community_hover").css("display","none");

                $('.common_header').addClass('hover_header');
                $('.common_navbar_menu_p').addClass('hover_menu');
                $('.common_navbar_login_p').addClass('hover_menu');
            });

            $(".common_header").mouseleave(function(){
                $(".common_navbar_menu_hover").css({"display":"none"});

                $('.common_header').removeClass('hover_header');
                $('.common_navbar_menu_p').removeClass('hover_menu');
                $('.common_navbar_login_p').removeClass('hover_menu');
            });
        });

        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        
        //top 버튼 쿼리
        $(document).ready(function() {
            $(window).scroll(function() {
                if ($(this).scrollTop() > 100) {
                    $('.btn_gotop').show();
                } else {
                    $('.btn_gotop').hide();
                }
            });
            $('.btn_gotop').click(function() {
                $('html, body').animate({
                    scrollTop: 0
                }, 50);
                return false;
            });
        });

        //chatbot 쿼리


