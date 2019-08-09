<%@ page import="java.util.List" %>
<%@ page import="com.eshop.entity.Remark" %><%--
  Created by IntelliJ IDEA.
  User: f
  Date: 2019-08-09
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 在页面引入JSTL核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <title></title>
</head>
<body>
<c:forEach var="p" items="${myRemark}">

    <div>
            <img src="images/b1.png"/>&emsp;&emsp;
        <span style="font-size:20px;color:gray;font-family: 微软雅黑">${user.userName}</span>
        <div>
        <div style="position: absolute;left:100px;width:800px;height:100px;font-family: 宋体;font-size: 18px">
            <c:out value="${p.remark}"></c:out>彼此阿德iu白色彼此阿布iu次啊彼此阿巴斯i彼此彼此比iu赤壁彼此吧iu赤壁吧i阿巴斯</div>
    </div><br/>
        <span style="margin-bottom: 10px;margin-left:100px;font-size: 14px;color: red"><c:out value="${p.remarkLevel}"></c:out></span>
        <span style="margin-left: 120px;font-size: 12px"><c:out value="${p.remarTime}"></c:out></span>
        <span style="position: absolute;left:360px;font-size: 12px"> 订单号：<c:out value="${p.orderId}"></c:out></span>
        <span style="position: absolute;left:500px;font-size: 12px"><c:out value="${p.goodsName}"></c:out></span>
        <span style="position: absolute;left:650px;font-size: 12px"><c:out value="${p.storeName}"></c:out></span>
    </div>


<hr/>
</c:forEach>

<c:set var="totalUsers" value="${requestScope.totalUsers}"/>
<c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
<c:set var="totalPages" value="${requestScope.totalPages}"/>
<c:set var="beginIndex" value="${requestScope.beginIndex}"/>
<c:set var="endIndex" value="${requestScope.endIndex}"/>
<c:set var="page" value="${requestScope.page}"/>
<c:set var="currentPageUsers" value="${requestScope.relist.subList(beginIndex,endIndex)}"/>


<c:forEach var="p" items="${currentPageUsers}">

    <div>
        <img src="images/b1.png"/>&emsp;&emsp;
        <span style="font-size:20px;color:gray;font-family: 微软雅黑">${user.userName}</span>
        <span style="position: absolute;left:200px;width:800px;font-family: 宋体;font-size: 18px"><c:out value="${p.remark}"></c:out></span>
        <br/>
        <span class="spancolor" style="margin-bottom: 10px;margin-left:100px;font-size: 14px;color: red"><c:out value="${p.remarkLevel}"></c:out></span>
        <span style="margin-left: 120px;font-size: 12px"><c:out value="${p.remarTime}"></c:out></span>
        <span style="position: absolute;left:360px;font-size: 12px"> 订单号：<c:out value="${p.orderId}"></c:out></span>
        <span style="position: absolute;left:500px;font-size: 12px"><c:out value="${p.goodsName}"></c:out></span>
        <span style="position: absolute;left:650px;font-size: 12px"><c:out value="${p.storeName}"></c:out></span>
        <button style="position: absolute;left:750px;" data-toggle="modal" data-target="#updateRemark" onclick="getRemarkId(${p.remarkId},'${p.remark}')">修改</button>
        &emsp;
        <button style="position: absolute;left:800px;" onclick="deleteRemark(${p.remarkId})">删除</button>
    </div>


    <hr/>
</c:forEach>


<div class="text-center">
    <nav>
        <ul class="pagination">
            <li><a href="<c:url value="/toMyRemark?page=1"/>">首页</a></li>
            <li><a href="<c:url value="/toMyRemark?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

            <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                <c:set var="active" value="${loop.index==page?'active':''}"/>
                <li class="${active}"><a
                        href="<c:url value="/toMyRemark?page=${loop.index}"/>">${loop.index}</a>
                </li>
            </c:forEach>
            <li>
                <a href="<c:url value="/toMyRemark?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
            </li>
            <li><a href="<c:url value="/toMyRemark?page=${totalPages}"/>">尾页</a></li>
        </ul>
    </nav>
</div>


<div class="modal fade" id="updateRemark" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改评论</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="remarkForm" >
                    <input type="hidden" class="form-control" id="remarkId"  name="remarkId">
                    <div class="form-group">
                        <label for="remarkLevel" style="float:left;padding:7px 15px 0 27px;">评论级别</label>
                        <div class="col-sm-10">
                            <select	class="form-control" id="remarkLevel" name="remarkLevel">
                                <option value="">--请选择--</option>
                                    <option value="好评">好评</option>
                                    <option value="中评" >中评</option>
                                    <option value="差评" >差评</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">评论</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="remark" placeholder="评论" name="remark">
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="tosummit()">保存</button>
            </div>
        </div>
    </div>
</div>

<%--<nav aria-label="Page navigation">--%>
    <%--<ul class="pagination">--%>
        <%--<li>--%>
            <%--<a href="#" aria-label="Previous" class="clickpage">--%>
                <%--<span aria-hidden="true">&laquo;</span>--%>
            <%--</a>--%>
        <%--</li>--%>

        <%--<c:forEach var="i" items="${pageNum}" varStatus="status">--%>
            <%--<li><a href="#" class="clickpage">${status.index+1}</a></li>--%>
        <%--</c:forEach>--%>
        <%--<li>--%>
            <%--<a href="#" aria-label="Next" class="clickpage">--%>
                <%--<span aria-hidden="true">&raquo;</span>--%>
            <%--</a>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</nav>--%>

</body>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">

    function tosummit() {
        $.post("updateRemark",$("#remarkForm").serialize(),function (data) {
            alert("修改成功");
            window.location.reload();
        });
    }

    function deleteRemark(remarkId) {
        if (confirm("确认删除该评论？")) {
        $.get("updateRemark",{"remarkId":remarkId},function (data) {
            alert("删除成功");
            window.location.reload();
        });
        }
    }


    function getRemarkId(remarkId,remark,remarkLevel) {
        $("#remarkId").val(remarkId);
        $("#remark").val(remark);
    }

    var spancolor=$(".spancolor");
    for (var i=0;i<spancolor.length;i++){
        if (spancolor[i].innerText=="好评"){
            spancolor[i].style="color:green;margin-bottom: 10px;margin-left:100px";
        } else if (spancolor[i].innerText=="中评"){
            spancolor[i].style="margin-bottom: 10px;margin-left:100px;color:orange";
        }else{
            spancolor[i].style="margin-bottom: 10px;margin-left:100px;color:red";
        }
    }
</script>
</html>
