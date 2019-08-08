package com.eshop.control;

import com.eshop.entity.User;
import com.eshop.service.UpdateUserImpl.UpdateUserInfo;
import com.eshop.service.UpdateUserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户信息
 * @author 陈港
 * @since 2019/08/08
 */

@WebServlet(name = "UpdateUser",urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    Logger log = Logger.getLogger(UpdateUser.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         User user = (User) request.getSession().getAttribute("user");
         int userPhone = Integer.parseInt(request.getParameter("userPhone"));
         String userTrueName = request.getParameter("userTrueName");
         String userName = request.getParameter("userName");
         String userAddress = request.getParameter("userAddress");
         int userId=user.getUserId();
         log.debug(userId);
         user.setUserName(userName);
         user.setUserAddress(userAddress);
         user.setUserPhone(userPhone);
         user.setUserTrueName(userTrueName);
         UpdateUserService uus = new UpdateUserInfo();
         uus.updateUserInfo(user);
         request.getSession().setAttribute("user",user);
         log.debug("control执行完毕");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
