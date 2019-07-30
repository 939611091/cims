<%--
  Created by IntelliJ IDEA.
  User: wangk
  Date: 2019/6/5
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- jQuery 3 -->
<script src="${contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- jquery-slimscroll -->
<script src="${contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath}/resources/dist/js/adminlte.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var path_array = window.location.pathname.split('/');
        var scheme_less_url = window.location.pathname;
        console.log(scheme_less_url);
        // if (path_array[1] == 'dashboard') {
        //     scheme_less_url = /*window.location.protocol + '//' + window.location.host +*/ '/' + path_array[1];
        // } else {
        //     scheme_less_url = /*window.location.protocol + '//' + window.location.host + */'/' + path_array[1] + '/' + path_array[2] + '/' + path_array[3];
        // }
        $('ul.treeview-menu>li').find('a[href="' + scheme_less_url + '"]').closest('li').addClass('active');  //二级链接高亮
        $('ul.treeview-menu>li').find('a[href="' + scheme_less_url + '"]').closest('li.treeview').addClass('active');  //一级栏目[含二级链接]高亮
        $('.sidebar-menu>li').find('a[href="' + scheme_less_url + '"]').closest('li').addClass('active');  //一级栏目[不含二级链接]高亮
    });
</script>
<script>
    "use strict";
    ;(function($){
        $.fn.CommonAjaxSubmit = function(options){
            // 默认配置
            var defaults = {
                beforeSuccess : function(){

                },
                // 默认请求成功处理
                success : function (resp) {
                    console.log(resp);
                    if (resp.success) {
                        if(resp.msg !== null && resp.msg !== undefined){
                            alert(resp.msg);
                        }
                        // 需要重定向
                    } else if(resp.code === 302){
                        if(resp.msg !== null && resp.msg !== undefined){
                            alert(resp.msg);
                        }
                        if(resp.data.redirectUrl !== undefined && resp.data.redirectUrl != null){
                            window.location.href=resp.data.redirectUrl;
                        }
                        // 其他错误
                    }  else {
                        alert(resp.msg);
                        if (resp.data != null) {
                            // 对所有错误字段添加错误信息
                            Object.keys(resp.data).forEach(function (key) {
                                console.log(key);
                                addErrorMsg(key, resp.data[key]);
                            });
                        }
                    }
                },
                afterSuccess : function(){
                    
                },
                error : function (xhr) {
                    alert("修改失败");
                }
            };
            var option = $.extend(defaults,options);
            // 根据id添加错误提示
            var addErrorMsg = function (elemId, msg) {
                $('#' + elemId)
                    .append("<span class='help-block'>" + msg + "</span>") // 添加错误消息
                    .addClass("has-error");                                // 添加红色错误框

            };
            // 移除所有错误提示
            var removeAllErrorMsg = function removeAllErrorMsg() {
                $('.form-group').each(function () {
                    $(this).removeClass('has-error')
                });
                $(".help-block").remove();
            };
            this.each(function(){

                var _this = $(this);
                console.log(_this);
                _this.submit(function (e) {
                    removeAllErrorMsg();
                    _this.ajaxSubmit({
                        success: function (resp) {
                            option.beforeSuccess();
                            option.success(resp);
                            option.afterSuccess();
                        },
                        error: option.error
                    });
                    return false;
                })
            });

            return this;
        }

    })(jQuery);
</script>