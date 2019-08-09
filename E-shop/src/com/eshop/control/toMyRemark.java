package com.eshop.control;

import com.eshop.entity.Remark;
import com.eshop.entity.User;
import com.eshop.service.RemarkImpl.RemarkImpl;
import com.eshop.service.RemarkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "toMyRemark",urlPatterns = { "/toMyRemark" })
public class toMyRemark extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          User user = (User) request.getSession().getAttribute("user");
          int userId = user.getUserId();
          RemarkService remarkService = new RemarkImpl();
          List<Remark> relist = remarkService.queryMyRemark(userId);

        String p = request.getParameter("page");
        int page;
        try {
            //当前页数
            page = Integer.valueOf(p);
        } catch (NumberFormatException e) {
            page = 1;
        }
        //用户总数
        int totalUsers = relist.size();
        //每页用户数
        int usersPerPage = 3;
        //总页数
        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
        //本页起始用户序号
        int beginIndex = (page - 1) * usersPerPage;
        //本页末尾用户序号的下一个
        int endIndex = beginIndex + usersPerPage;
        if (endIndex > totalUsers)
            endIndex = totalUsers;
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("usersPerPage", usersPerPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("beginIndex", beginIndex);
        request.setAttribute("endIndex", endIndex);
        request.setAttribute("page", page);
        request.setAttribute("relist", relist);
        request.getRequestDispatcher("WEB-INF/pages/myCenter/menufive.jsp").forward(request, response);






          /*ArrayList pageNum = new ArrayList();

          for (int i=1;i<=list.size()/3;i++){
              pageNum.add(i);
          }
          if (list.size()<3){
              pageNum.add(1);
          }
          request.setAttribute("pageNum",pageNum);
          request.setAttribute("myRemark",list);
          request.getRequestDispatcher("WEB-INF/pages/myCenter/menufive.jsp").forward(request,response);*/
    }
}
