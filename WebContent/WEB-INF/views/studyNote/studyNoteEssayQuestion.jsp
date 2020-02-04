<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>온스터디</title>

    <style>
        /* .outer {
            position: relative;
        } */

        .study-gage {

            float: left;
        }

        .study-gage2 {

            float: left;
        }
        .btn-answer{
            background-color:#f15a25 ;
            color: white;
        }
        .btn-answer:hover{
            background-color:white ;
            color: #f15a25;

        }
    </style>
</head>

<body>
<%@ include file="../common/loginedHeader.jsp" %>
    <!-- 헤더 시작 -->
 
    <!-- content 시작 -->
    <div id="container" style="margin:240px auto; text-align:center; font-size:50px; color:#333333; ">
        <div class="container">
            <div class="row" style="margin-left: 3%;">





                <div class="col-3" style="border-right: double; ">
                    <div class="col-12 row" style="margin:0,auto; font-size: 20px;">
                        주관식

                    </div>
                    <br>

                    <div class="progress">
                        <div class="progress-bar" style="width:50%"></div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <p style="font-size: 40%;">진행률</p>

                        </div>
                        <div class="col-6">
                            <div class="row">

                                <p style="font-size: 40%; text-align: right;">30</p>
                                <p style="font-size: 40%; text-align: right;">/</p>
                                <p style="font-size: 40%; text-align: right;">60</p>

                            </div>
                        </div>
                    </div>


                    <div class="progress">
                        <div class="progress-bar" style="width:33%"></div>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <p style="font-size: 40%;">정답률</p>

                        </div>
                        <div class="col-6">
                            <div class="row">

                                <p style="font-size: 40%; text-align: right;">20</p>
                                <p style="font-size: 40%; text-align: right;">/</p>
                                <p style="font-size: 40%; text-align: right;">60</p>

                            </div>
                        </div>
                    </div>

                    <div class="progress">
                        <div class="progress-bar" style="width:10%"></div>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <p style="font-size: 40%;">오답률</p>

                        </div>
                        <div class="col-6">
                            <div class="row">

                                <p style="font-size: 40%; text-align: right;">6</p>
                                <p style="font-size: 40%; text-align: right;">/</p>
                                <p style="font-size: 40%; text-align: right;">60</p>

                            </div>
                        </div>
                    </div>

                    <!-- 진행률 시작 -->

                    <!-- 진행률 종료 3 -->
                </div>
                <div class="col-8" style="margin-left: 20px;">

                    <div class="row">
                        <div class="text-area">
                            문제
                        </div>
                    </div>
                    <br>
                    <!-- 정답 입력 -->
                    <div class="row" style="font-size: 20px;">

                        <input type="text" placeholder="정답입력" id="answer" style="width:80%">

                        &nbsp;
                        &nbsp;
                        <button class="rounded btn-answer" >정답</button>

                    </div>
                    <br>
                    <div class="row" style="text-align: right; margin-left: 80%;">
                    <button style="background-color: white; border: none; box-shadow: none; font-size: 40%; "> SKIP >></button>
                        
                    </div>
                </div>









            </div>
        </div>
    </div>
    <!-- content 종료 -->







    <!-- footer 시작 -->
    <%@ include file="../common/footer.jsp" %>


    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>