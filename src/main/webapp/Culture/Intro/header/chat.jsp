<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>


    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            box-sizing: content-box;
        }

        .chat_container {
            display: flex;
            border: 1px solid black;
            height: 500px;
            width: 700px;  /* 채팅 영역 크기 */ 
            flex-direction: row;
           
        }

        .category_box {
            width: 250px;
            display: flex;
            flex-direction: column;
            background:white;
        }

        .chat_category {
            height: 83.33px;
            width: 100%;
            display: flex;
            justify-content: center;
            border-bottom: 1px solid #eee;
            align-items: center;
        }
        
        
        
        .category_box a {
            text-decoration: none;
            width: 100%;
            color:black;
        }
        
        .category_box a:hover{
            transition:0.3s;
            background-color: black;
            color:white;
        }

        .chat_space { /* 채팅공간 */
            width: 70%;
            background: black;
        }
        
        
    </style>
    <script type="text/javascript">
      
    </script>
</head>

<body>
    <div class="chat_container">
        <div class="category_box" id="box">
            <a href="#">
                <div class="chat_category">
                    <h3>뮤지컬(0/10)</h3>
                </div>
            </a>
            <a href="#">
                <div class="chat_category">
                    <h3>연극(0/10)</h3>
                </div>
            </a>
            <a href="#">
                <div class="chat_category">
                    <h3>콘서트(0/10)</h3>
                </div>
            </a>
            <a href="#">
                <div class="chat_category">
                    <h3>무용(0/10)</h3>
                </div>
            </a>
            <a href="#">
                <div class="chat_category">
                    <h3>클래식/오페라(0/10)</h3>
                </div>
            </a>
            <a href="#">
                <div class="chat_category">
                    <h3>국악(0/10)</h3>
                </div>
            </a>
        </div>
        <div class="chat_space">
            
        </div>
        
    </div>
   
</body>

</html>
