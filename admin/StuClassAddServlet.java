package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;
/*
 * 用于增加班级
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {
	
	private IStuClassService stu = new StuClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute()把数据传送到页面
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 1.获取请求参数
		 * 
		 */
		req.setCharacterEncoding("UTF-8");
		String stuName = req.getParameter("stuname");
		String depInfo = req.getParameter("depInfo");
		/*
		 * 2.把请求参数封装成对象
		 * 封装的目的就是为了调用业务层的方法
		 */
		StuClass sc = new StuClass();
		sc.setClassName(stuName);
		sc.setDeptName(depInfo);
		stu.addstuClass(sc);
		/*
		 * req.getRequestDispatcher可以跳转请求路径
		 * /stuClassQueryServlet
		 * 带着request和response跳转的，有时候不需要继续保留这两个包含的信息，则用resp.sendRedirect()
		 */
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
}
