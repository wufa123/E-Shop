package com.eshop.control;

import com.eshop.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跳转到个人中心
 * author:陈港
 * since：2019/08/06
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/ToMyCenter.pages" })
@WebServlet(asyncSupported = true, urlPatterns = { "/ToMyCenter" })
public class ToMyCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToMyCenter() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		User user = new User();
		user.setUserId(1);
		user.setUserName("无法");
        user.setUserType("用户");
		request.getSession().setAttribute("user",user);
		request.getRequestDispatcher("WEB-INF/pages/myCenter.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
