package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet {
	
	private ITeacherService ts = new TeacherService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Teacher tea = new Teacher();
		tea.setTeacherId(Integer.valueOf(id));
		ts.deleteTeacher(tea, Integer.valueOf(id));
		resp.sendRedirect(req.getContextPath() + "/teacherQueryServlet");
	}
}
