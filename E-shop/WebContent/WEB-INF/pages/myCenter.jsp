<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ page import="com.eshop.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- 个人中心界面   
     author：陈港   
     time：2019/08/06 -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="soubg">

        <div class="fr top_right">
            <div class="fl">
                <span><%
                    User user= (User) request.getSession().getAttribute("user");
                    out.print(user.getUserName());
                %>${user.userName}</span>

            </div>
            <ul class="ss">
                <li class="ss_list">
                    <a href="#">首页</a>
                </li>
                <li class="ss_list">
                    <a href="#">客户服务</a>

                    <div class="ss_list_bg" style="line-height: 60px;text-align: center">
                        <div class="ss_list_c">
                            <ul>
                                <li><a href="#">包裹跟踪</a></li>
                                <li><a href="#">创建问题</a></li>
                                <li><a href="#">在线退换货</a></li>
                                <li><a href="#">在线投诉</a></li>
                                <li><a href="#">配送范围</a></li>
                            </ul>
                        </div>
                    </div>
                </li>               
            </ul>
    
                <span class="fr">|&nbsp;
                    <a href="#" id="getOut">退出登陆 </a>
                </span>
        </div>
    </div>
    
    <div class="jumbotron" style="margin-left:100px;margin-right:100px;margin-top:30px;border: 1px solid orangered;background: orange;height: 150px">

         <div class="top" style="margin-top: -60px">

         <div class="logo">
             <a href="#">
                 <img src="images/logo.png"/>
             </a>
         </div>

          <div class="i_car" >
                 <div class="car_t" >购物车</div>
          </div>
             <h2 style="line-height: 150px;margin-left: 50%">个人中心</h2>
         </div>
    </div>



   <!--左侧导航栏-->
  <div>
      <ul class="nav nav-pills nav-stacked .nav-justified" style="background: orange;margin-top: 230px;margin-left: 100px">
          <li style="line-height: 40px;text-align: center;font-size: larger">
              <a href="MyCenterOne" target="showFrame">个人信息</a>
              <a href="MyCenterOne" target="showFrame">我的订单</a>
              <a href="MyCenterOne" target="showFrame">我的购物车</a>
              <a href="MyCenterOne" target="showFrame">我的钱包</a>
              <a href="MyCenterOne" target="showFrame">我的评价</a>
              <a href="MyCenterOne" target="showFrame">修改登陆密码</a>
              <% if(user.getUserType().equals("用户")){
                  out.print("<a href=\"MyCenterOne\" target=\"showFrame\">申请开店</a>");
              }
              else {
                  out.print("<a href=\"MyCenterOne\" target=\"showFrame\">管理店铺</a>");
              }%>

          </li>
      </ul>
  </div>

<iframe id="showFrame" name="showFrame" style="width:1090px;height: 500px;margin-left: 330px;margin-top: -15px;border:medium none">
    <div>
        <img src="images/b1.png" style="margin-left: 200px"/>
        <span>用户名：</span>
    </div>
</iframe>

</body>
 <script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

<script>
    $(function () {
        $("#getOut").click(function () {
            if (confirm('确认退出账户？')) {
                window.location.href="index.jsp";
            }
        })
    })
</script>

<script>
    $(function () {

        function updateUser(){
            console.log("updateuser is run");
            $post("UpdateUser",$("edit_form").serialize(),function (data) {

            });
        }


        // $post("Recommend",function (data) {
        //
        // });
    })
</script>
</html>