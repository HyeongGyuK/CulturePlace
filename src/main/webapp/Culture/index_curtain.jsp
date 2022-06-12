<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" >

    <head>
    	<title>1조파이팅</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  		<link rel="stylesheet" href="/CulturePlace/Intro/style_curtain.css">
        <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
        <link
            href="https://fonts.googleapis.com/css?family=Cinzel&display=swap"
            rel="stylesheet"
        />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>
        <!-- AnimeJS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
    	<link href="https://webfontworld.github.io/suseong/SuseongBatang.css" rel="stylesheet">
    </head>
    <body>
        <div class="loader">
        
          <div class="main_p">
			  <div class="main">
		      	<img id="leftdoor" src="/Culture/images/Intro/intro/왼쪽커튼.jpg" width=105%>
			  </div>
			
			  <div class="main" id="main_right">
			  	<img id="rightdoor" src="/Culture/images/Intro/intro/오른쪽커튼.jpg" width=105%>
			  </div>
	      </div>
	      
	      <div class="intro">
                <h1 class="intro-title">CulturePlace</h1>
            </div>
            
        </div>

        <div class="container">
            <div class="logo">
            	<img src="/Culture/images/Intro/intro/logo.png">
            </div>
            
            <div class="figure_p">
	            <figure class="snip1504" id="figure-left">
				  <img src="/Culture/images/Intro/intro/first.png"/>
				  <figcaption>
				    <h3>Culture Place</h3>
				    <h5>바로가기</h5>
				  </figcaption>
				  <a href="/CulturePlaceMain"></a>
				</figure>
				
				<figure class="snip1504" id="figure-right">
				  <img src="/Culture/images/Intro/intro/second.png"/>
				  <figcaption>
				    <h3>Community</h3>
				    <h5>바로가기</h5>
				  </figcaption>
				  <a href="/CommunityMain"></a>
				</figure>
            </div>
				
				
        </div>
    <script type="text/javascript">
    
    var textWrapper = document.querySelector(".intro-title");
    textWrapper.innerHTML = textWrapper.textContent.replace(
        /([^\x00-\x80]|\w)/g,
        "<span class='letter'>$&</span>"
    );

    anime
        .timeline({ loop: false })
        .add({
            targets: ".intro-title .letter",
            translateX: [140, 0],
            translateZ: 0,
            opacity: [0, 1],
            easing: "easeOutExpo",
            duration: 800,
            delay: function(el, i) {
                return 1100 + 50 * i;
            }
        })
        .add({
            targets: ".intro-title .letter",
            translateX: [0, -140],
            opacity: [1, 0],
            easing: "easeInExpo",
            duration: 800,
            delay: function(el, i) {
                return 400 + 50 * i;
            }
        });

    TweenMax.to(".loader", 2.2, {
        delay: 3,
        top: "-100%",
        ease: Expo.easeInOut
    });

    TweenMax.from(".logo", 2, {
        delay: 4.5,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });

    TweenMax.from("#figure-left", 2, {
        delay: 4.8,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });
    
    TweenMax.from("#figure-right", 2, {
        delay: 4.8,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });
    
    TweenMax.from("#img-left", 2, {
        delay: 6,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });
    TweenMax.from("#img-right", 2, {
        delay: 6.7,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });
    TweenMax.from(".left-bottom-text", 2, {
        delay: 6.4,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });


    TweenMax.from(".right-bottom-text", 2, {
        delay: 6.7,
        y: 10,
        opacity: 0,
        ease: Expo.easeInOut
    });
   
    </script>
</body>
</html>