<%@ page import="com.eshop.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--个人中心界面一 -->
<head>
    <title>menuOne</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <style>
        .divline{
            line-height: 60px;
        }
        span{
            font-size: 22px;
        }
    </style>
</head>
<body>
    <h4>个人资料：</h4>
    <div style="vertical-align: 50%;margin-left: 100px">

        <img src="images/b1.png" />&emsp;&emsp;
        <span style="vertical-align: -50%">
        用户名：&emsp;&emsp;
            <%
            User user= (User) request.getSession().getAttribute("user");
            if (user.getUserName()!=null){
                out.print(user.getUserName());
            }else{
                out.print("暂无信息");
            }

        %>
        </span>

        <a href="#" class="btn btn-primary" data-toggle="modal"
           data-target="#infoEditDialog" style="position: relative;float: right;background: orange">修改信息</a>

        <div class="divline">
        <span >会员等级：&emsp;&emsp;
            <%
                if (user.getUserLevel()!=null){
                    out.print(user.getUserLevel());
                }else{
                    out.print("暂无信息");
                }
            %></span>
        </div>
        <div class="divline">
        <span >积&emsp;&emsp;分：&emsp;&emsp;
            <%
                if (user.getUseExp()!=0){
                    out.print(user.getUserTrueName());
                }else{
                    out.print("暂无信息");
                }
            %></span>
        </div>
        <div class="divline">
        <span >电&emsp;&emsp;话：&emsp;&emsp;
            <%
                if (user.getUserPhone()!=0){
                    out.print(user.getUserPhone());
                }else{
                    out.print("暂无信息");
                }
            %></span>
        </div >
        <div class="divline">
        <span >真实姓名：&emsp;&emsp;
            <%
                if (user.getUserTrueName()!=null){
                    out.print(user.getUserTrueName());
                }else{
                    out.print("暂无信息");
                }
            %></span>
        </div>
        <div class="divline">
        <span >地&emsp;&emsp;址：&emsp;&emsp;
            <%
                if (user.getUserAddress()!=null){
                    out.print(user.getUserAddress());
                }else{
                    out.print("暂无信息");
                }
            %></span>
        </div>



    </div>

    <div>
        <a href=""></a>
    </div>

<!--修改信息-->
    <div class="modal fade" id="infoEditDialog" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header" style="background: orange">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">修改个人信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="edit_form">
                        <input type="hidden" id="edit_cust_Id" name="cust_id"/>
                        <div class="form-group">
                            <label for="edit_userName" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edit_userName" placeholder="用户名" name="userName" value="${user.userName}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit_userTrueName" class="col-sm-2 control-label">真实姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edit_userTrueName" placeholder="真实姓名" name="userTrueName" value="${user.userTrueName}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit_userPhone" class="col-sm-2 control-label">移动电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edit_userPhone" placeholder="移动电话" name="userPhone" value="${user.userPhone}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit_userAddress" class="col-sm-2 control-label">收货地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edit_userAddress" placeholder="收货地址" name="userAddress" value="${user.userAddress}">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" style="background: orange" class="btn btn-primary" onclick="updateUser()">保存修改</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
        function updateUser(){
            console.log("updateuser is run");
           $.post("UpdateUser",$("#edit_form").serialize(),function (data) {
               alert("修改成功");
               window.location.reload();
           });
        }


        // $post("Recommend",function (data) {
        //
        // });

</script>
</html>
