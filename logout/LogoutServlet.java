package com.hp.onlinexam.servlet.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 把当前的session直接失效（session中保存的教师信息和Test信息）
		 */
		req.getSession().invalidate();
		/*
		 * 当前页面在teacher文件夹下，而login.jsp是和teacher文件夹同一级
		 */
		resp.sendRedirect("./login.jsp");
	}	
}
