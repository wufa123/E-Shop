package com.eshop.control;

import com.eshop.entity.User;
import com.eshop.service.UpdateUserImpl.UpdateUserInfo;
import com.eshop.service.UpdateUserService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 更新用户密码
 */
@WebServlet(name = "UpdatePwd",urlPatterns = { "/UpdatePwd" })
public class UpdatePwd extends HttpServlet {
    Logger log = Logger.getLogger(UpdatePwd.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String oldPwd = request.getParameter("oldpwd");
        String newPwd = request.getParameter("newpwd");
        int msg;
        log.debug(user.getUserPassword());
        if (oldPwd.equals(user.getUserPassword())){
            UpdateUserService uus =new UpdateUserInfo();
            uus.updateUserPwd(newPwd,user.getUserId());
            user.setUserPassword(newPwd);
            request.getSession().setAttribute("user",user);
            msg=1;
        }else{
            msg=0;
        }

        Gson gson = new Gson();
        String json = gson.toJson(msg);
        PrintWriter writer = response.getWriter();
        writer.append(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
