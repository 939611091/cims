<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html class="no-js" lang="en">
<head>
    <title>青少年兴趣培训机构</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="/favicon.ico">

    <!--Google Font link-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

    <link rel="stylesheet" href="${contextPath}/resources/assets/css/slick.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/slick-theme.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/animate.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/magnific-popup.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/bootsnav.css">
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/icofont.css">
    <!--Theme custom css -->
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/style.css">
    <!--Theme Responsive css-->
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/responsive.css" />

    <script src="${contextPath}/resources/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">


<!-- 网页加载进度动画 -->
<div id="loading">
    <div id="loading-center">
        <div id="loading-center-absolute">
            <div class="object" id="object_one"></div>
            <div class="object" id="object_two"></div>
            <div class="object" id="object_three"></div>
            <div class="object" id="object_four"></div>
        </div>
    </div>
</div>
<!--End off Preloader -->


<div class="culmn">
    <!--Home page style-->
     <!--Home page style-->
    <nav class="navbar navbar-light navbar-expand-lg  navbar-fixed white no-background bootsnav">
       

        <div class="container">
            <!-- Start Atribute Navigation -->
            
            <!-- End Atribute Navigation -->

            <!-- Start Header Navigation -->
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextPath}/index">
                    <img src="${contextPath}/resources/assets/images/logo2.png" class="logo logo-display m-top-10" alt="">
                    <img src="${contextPath}/resources/assets/images/logo2.png" class="logo logo-scrolled" alt="">
                </a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                    <li><a href="${contextPath}/home/index"><i class="fa fa-user">&nbsp;首页</i></a></li>
                    <li><a href="${contextPath}/course/index"><i>&nbsp;课程中心</i></a></li>
                    <li><a href="${contextPath}/home/teacher/index"><i>&nbsp;师资力量中心</i></a></li>
                    <li><a href="${contextPath}/studentHonor/index"><i>&nbsp;学生荣誉中心</i></a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
    </nav>

    <!--Home Sections-->

     <section id="hello" class="home bg-mega">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="main_home">
                    <div class="home_text">
                        <h2 class="text-white">学生荣誉展示中心 <br />更多学生荣誉在这里！</h2>
                    </div>

                    <div class="home_btns m-top-40">
                        <a href="#contact" target="_blank" class="btn btn-primary m-top-20">报名热线 0771-5985666</a>
                    </div>

                </div>
            </div>
            <!--End off row-->
        </div>
        <!--End off container -->
    </section>
    <!--End off Home Sections-->
    
    

  


    <!--Blog Section-->
    <section id="dance" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>学生荣誉</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的学生学习后获得的荣誉，</h4>
                            <h4>想要你的孩子也如此优秀就联系我们吧！</h4>
                        </div>
                    </div>

                    <div class="row">

                        <c:forEach items="${honorVoList }" var="honorVo">
                            <div class="col-md-4">
                                <div class="blog_item m-top-20">
                                    <div class="blog_item_img">
                                        <img src="http://localhost:8080/${honorVo.hPhoto}" width="200" height="350" />
                                    </div>
                                    <div class="blog_text roomy-40">
                                        <h4>${honorVo.student.name }</h4>
                                        <p style="font-size:16px"><em>指导老师：${honorVo.name }</em></p>
                                        <p style="font-size:16px"><em>获得荣誉：${honorVo.info }</em></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!-- End off Blog section-->
    
    
   

    <!-- scroll up-->
    <div class="scrollup">
        <a href="#"><i class="fa fa-chevron-up"></i></a>
    </div>
    <!-- End off scroll up -->


    <footer id="footer" class="footer bg-black">
        <div class="container">
            <div class="row">
                <div class="main_footer text-center p-top-40 p-bottom-30">
                    <p class="wow fadeInRight" data-wow-duration="1s">
                        <i class="fa fa-heart"></i> by
                        青少年兴趣培训机构 2019. All Rights Reserved
                    </p>
                </div>
            </div>
        </div>
    </footer>

</div>

<!-- JS includes -->

<script src="${contextPath}/resources/assets/js/vendor/jquery-1.11.2.min.js"></script>
<script src="${contextPath}/resources/assets/js/vendor/popper.min.js"></script>
<script src="${contextPath}/resources/assets/js/vendor/bootstrap.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.magnific-popup.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.easing.1.3.js"></script>
<script src="${contextPath}/resources/assets/js/slick.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.collapse.js"></script>
<script src="${contextPath}/resources/assets/js/bootsnav.js"></script>
<script src="${contextPath}/resources/assets/js/gmaps.min.js"></script>
<script src="${contextPath}/resources/assets/js/plugins.js"></script>
<script src="${contextPath}/resources/assets/js/main.js"></script>
<script>

    $(function () { $(".tooltip-options a").tooltip({html : true });});
</script>
</body>
</html>