package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		String teaName = req.getParameter("teaname");
		String depInfo = req.getParameter("depInfo");
		String pwd = req.getParameter("password");
		Teacher tea = new Teacher();
		tea.setTname(teaName);
		tea.setDeptName(depInfo);
		tea.setPwd(pwd);
		ts.addTeacher(tea);
		resp.sendRedirect(req.getContextPath() + "/teacherQueryServlet");
	}
	
}
