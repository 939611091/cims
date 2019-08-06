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
    <nav class="navbar navbar-light navbar-expand-lg  navbar-fixed white no-background bootsnav">
        <!-- Start Top 搜索 -->
<!--
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
-->
        <!-- End Top 搜索 -->

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
                    <li><a href="#classroom">教学环境</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我们的课程 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#dance">舞蹈</a></li>
                            <li><a href="#music">音乐</a></li>
                            <li><a href="#pe">体育运动</a></li>
                            <li><a href="#other">其他兴趣</a></li>
                            <li><a href="${contextPath}/course/index">更多课程</a></li>
                        </ul>
                    </li>
                    <%--<li><a href="#dance">舞蹈</a></li>--%>
                    <%--<li><a href="#music">音乐</a></li>--%>
                    <%--<li><a href="#pe">体育运动</a></li>--%>
                    <li><a href="${contextPath}/course/index">课程中心</a></li>
                    <li><a href="#teacher">师资力量</a></li>
                    <li><a href="#honor">学生荣誉</a></li>
                    <li><a href="#contact">联系我们</a></li>&nbsp;
                    <%--<div class="navbar-custom-menu">--%>
                        <%--<ul class="nav navbar-nav">--%>
                            <%--<li class="dropdown">--%>
                                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">课程信息管理系统<span--%>
                                        <%--class="caret"></span></a>--%>
                                <%--<ul class="dropdown-menu" role="menu">--%>
                                    <%--<li><a href="#"><i class="fa fa-user">学生入口</i></a></li><br/>--%>
                                    <%--<li><a href="#"><i class="icofont-ui-add">老师入口</i></a></li><br/>--%>
                                    <%--<li><a href="${contextPath}/admin/login"><i class="fa fa-user">&nbsp;管理员入口</i></a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                    <li><a href="${contextPath}/student/login"><i class="fa fa-user">&nbsp;学生入口</i></a></li>
                    <li><a href="${contextPath}/teacher/login"><i class="icofont-ui-add">&nbsp;老师入口</i></a></li>
                    <li><a href="${contextPath}/admin/login"><i class="fa fa-user">&nbsp;管理员入口</i></a></li>
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
                        <h3 class="text-white">任何一种兴趣都包含着天性中有倾向性的呼声， <br /> 也许还包含着一种处在原始状态中的天才的闪光。</h3>
                    </div>

                    <div class="home_btns m-top-40">
                        <h4 class="text-white">&nbsp;&nbsp;快来报名参加青少年兴趣培训~</h4>
                        <h4 class="text-white">&nbsp;&nbsp;让你的孩子成为那一道闪光！</h4>
                        <a href="#contact" target="_blank" class="btn btn-primary m-top-20">报名热线 0771-5985666</a>
                    </div>

                </div>
            </div>
            <!--End off row-->
        </div>
        <!--End off container -->
    </section>
    <!--End off Home Sections-->
    

    <section id="classroom" class="blog">
    <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                        <h2>教学环境</h2>
                        <div class="separator_auto"></div>
                        <h4>请欣赏我们的教室~</h4>
                            <h4>还有更多欢迎到实地考察！</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="featured_slider">
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/calligraphy.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/calligraphy.jpg" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/dance.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/dance.jpg" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/drawing.png" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/drawing.png" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/music.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/music.jpg" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/pingpong.png" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/pingpong.png" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/dance2.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/dance2.jpg" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/basketball.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/basketball.jpg" class="popup-img"></a>
            </div>
        </div>
        <div>
            <div class="featured_img">
                <img src="${contextPath}/resources/assets/images/classroom/guitar.jpg" alt="" />
                <a href="${contextPath}/resources/assets/images/classroom/guitar.jpg" class="popup-img"></a>
            </div>
        </div>
    </div>
    <!-- End off featured slider -->
    </section>


    <!--Blog Section-->
    <section id="dance" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>舞蹈</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的舞蹈课程，</h4>
                            <h4>喜欢就联系我们吧~</h4>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${courseVoList1 }" var="courseVo">
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                <div class="blog_item_img">
                                    <img src="http://localhost:8080/${courseVo.cPhoto}" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h6>课程名：${courseVo.cName }</h6>
                                    <p><em>课程简介：${courseVo.cDescription }</em></p>
                                    <p>课程类别：${courseVo.course_category.categoryName}&nbsp;&nbsp;&nbsp;&nbsp; 课程时长：${courseVo.period}</p>
                                    <p><em>价格：${courseVo.price}&nbsp;&nbsp;&nbsp;&nbsp; 人数：${courseVo.number}&nbsp;&nbsp;&nbsp;&nbsp;剩余名额：${courseVo.surplusNumber}</em></p>
                                    <p><em>开始时间：<fmt:formatDate value="${courseVo.beginTime}" pattern="yyyy年MM月dd日"/></em></p>
                                    <p><em>结束时间：<fmt:formatDate value="${courseVo.overTime}" pattern="yyyy年MM月dd日"/></em></p>
                                    <p><em>上课老师：${courseVo.teacher.name}&nbsp;&nbsp;&nbsp;&nbsp; 上课时间：${courseVo.schoolTime}</em></p>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                <div class="blog_item_img">
                                    <img src="${contextPath}/resources/assets/images/more.jpg" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h3>点击--><a href="${contextPath}/course/index">查看更多课程</a></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!-- End off Blog section-->
    
    
    <!--Blog Section-->
    <section id="music" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>音乐</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的音乐类课程，</h4>
                            <h4>喜欢就联系我们吧~</h4>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${courseVoList2 }" var="courseVo">
                            <div class="col-md-4">
                                <div class="blog_item m-top-20">
                                    <div class="blog_item_img">
                                        <img src="http://localhost:8080/${courseVo.cPhoto}" width="200" height="350" />
                                    </div>
                                    <div class="blog_text roomy-40">
                                        <h6>课程名：${courseVo.cName }</h6>
                                        <p><em>课程简介：${courseVo.cDescription }</em></p>
                                        <p>课程类别：${courseVo.course_category.categoryName}&nbsp;&nbsp;&nbsp;&nbsp; 课程时长：${courseVo.period}</p>
                                        <p><em>价格：${courseVo.price}&nbsp;&nbsp;&nbsp;&nbsp; 人数：${courseVo.number}&nbsp;&nbsp;&nbsp;&nbsp;剩余名额：${courseVo.surplusNumber}</em></p>
                                        <p><em>开始时间：<fmt:formatDate value="${courseVo.beginTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>结束时间：<fmt:formatDate value="${courseVo.overTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>上课老师：${courseVo.teacher.name}&nbsp&nbsp&nbsp&nbsp 上课时间：${courseVo.schoolTime}</em></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                <div class="blog_item_img">
                                    <img src="${contextPath}/resources/assets/images/more.jpg" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h3>点击--><a href="${contextPath}/course/index">查看更多课程</a></h3>
                                </div>
                            </div>
                        </div>
                        

                    </div>
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!-- End off Blog section-->
    
    
    <!--Blog Section-->
    <section id="pe" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>体育运动</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的体育运动课程，</h4>
                            <h4>喜欢就联系我们吧~</h4>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${courseVoList3 }" var="courseVo">
                            <div class="col-md-4">
                                <div class="blog_item m-top-20">
                                    <div class="blog_item_img">
                                        <img src="http://localhost:8080/${courseVo.cPhoto}" width="200" height="350" />
                                    </div>
                                    <div class="blog_text roomy-40">
                                        <h6>课程名：${courseVo.cName }</h6>
                                        <p><em>课程简介：${courseVo.cDescription }</em></p>
                                        <p>课程类别：${courseVo.course_category.categoryName}&nbsp;&nbsp;&nbsp;&nbsp; 课程时长：${courseVo.period}</p>
                                        <p><em>价格：${courseVo.price}&nbsp;&nbsp;&nbsp;&nbsp; 人数：${courseVo.number}&nbsp;&nbsp;&nbsp;&nbsp;剩余名额：${courseVo.surplusNumber}</em></p>
                                        <p><em>开始时间：<fmt:formatDate value="${courseVo.beginTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>结束时间：<fmt:formatDate value="${courseVo.overTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>上课老师：${courseVo.teacher.name}&nbsp&nbsp&nbsp&nbsp 上课时间：${courseVo.schoolTime}</em></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                <div class="blog_item_img">
                                    <img src="${contextPath}/resources/assets/images/more.jpg" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h3>点击--><a href="${contextPath}/course/index">查看更多课程</a></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!-- End off Blog section-->
    
    
    <!--Blog Section-->
    <section id="other" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>其他兴趣</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的其他兴趣的课程，</h4>
                            <h4>喜欢就联系我们吧~</h4>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${courseVoList4 }" var="courseVo">
                            <div class="col-md-4">
                                <div class="blog_item m-top-20">
                                    <div class="blog_item_img">
                                        <img src="http://localhost:8080/${courseVo.cPhoto}" width="200" height="350" />
                                    </div>
                                    <div class="blog_text roomy-40">
                                        <h6>课程名：${courseVo.cName }</h6>
                                        <p><em>课程简介：${courseVo.cDescription }</em></p>
                                        <p>课程类别：${courseVo.course_category.categoryName}&nbsp;&nbsp;&nbsp;&nbsp; 课程时长：${courseVo.period}</p>
                                        <p><em>价格：${courseVo.price}&nbsp;&nbsp;&nbsp;&nbsp; 人数：${courseVo.number}&nbsp;&nbsp;&nbsp;&nbsp;剩余名额：${courseVo.surplusNumber}</em></p>
                                        <p><em>开始时间：<fmt:formatDate value="${courseVo.beginTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>结束时间：<fmt:formatDate value="${courseVo.overTime}" pattern="yyyy年MM月dd日"/></em></p>
                                        <p><em>上课老师：${courseVo.teacher.name}&nbsp&nbsp&nbsp&nbsp 上课时间：${courseVo.schoolTime}</em></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                <div class="blog_item_img">
                                    <img src="${contextPath}/resources/assets/images/more.jpg" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h3>点击--><a href="${contextPath}/course/index">查看更多课程</a></h3>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!-- End off Blog section-->

    <!--Blog Section-->
    <section id="teacher" class="blog">
        <div class="container">
            <div class="row">
                <div class="main_blog text-center roomy-100">
                    <div class="col-sm-8 mr-sm-auto ml-sm-auto">
                        <div class="head_title text-center">
                            <h2>师资力量</h2>
                            <div class="separator_auto"></div>
                            <h4>下面是我们的教学老师，</h4>
                            <h4>很友好很负责很有优秀~</h4>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${teacherList }" var="teacher">
                        <div class="col-md-4">
                            <div class="blog_item m-top-20">
                                 <div class="blog_item_img">
                                    <img src="http://localhost:8080/${teacher.tPhoto}" width="200" height="350" />
                                </div>
                                <div class="blog_text roomy-40">
                                    <h4>${teacher.name }&nbsp;&nbsp;老师</h4>
                                    <p style="font-size:16px"><em>${teacher.tDescription }</em></p>
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

    <!--Blog Section-->
    <section id="honor" class="blog">
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

    <!--Contact Us Section-->
    <section id="contact" class="contact bg-mega fix">
        <div class="container">
            <div class="row">
                <div class="main_contact roomy-100 text-white">
                    <div class="col-md-12">
                        <div class="rage_widget">
                            <div class="widget_head">
                                <h3 class="text-white">联系我们</h3>
                                <div class="separator_small"></div>
                            </div>
                            <p>培养兴趣爱好。从小抓起！ 赶紧报名参加吧！</p>
                            <p>地址：南宁市西乡塘区青少年兴趣培训机构 </p>   
                            <p>报名热线：0771-5985666</p>
                            <p>QQ，微信，线下都可报名</p>
                            <div class="widget_socail m-top-30">
                                <ul class="list-inline-item">
                                    <li class="tooltip-options"><a href="#" data-toggle="tooltip" title="QQ:939611091"><i class="fa fa-qq"></i></a></li>
                                    <li class="tooltip-options"><a href="#" data-toggle="tooltip" title="jia"><i class="fa fa-weixin"></i></a></li>
                                    <li class="tooltip-options"><a href="#"  data-toggle="tooltip" title="0771-5985666"><i class="fa fa-phone"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!--End off row -->
        </div>
        <!--End off container -->
    </section>
    <!--End off Contact Section-->


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