package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet{

	private ITeacherService ts = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teaName = req.getParameter("teaname");
		if(null == teaName)
			teaName = "";
		teaName = new String(teaName.getBytes("ISO-8859-1"),"utf-8");
		List teaList = ts.findTeachers(teaName);
		req.setAttribute("teaList", teaList);
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
