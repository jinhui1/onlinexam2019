package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StudentService;

@WebServlet("/studentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	
	private IStudentService ss = new StudentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);String id = req.getParameter("id");
		String id = req.getParameter("id");
		Student student = new Student();
		student.setStudentId(Integer.valueOf(id));
		//course.setCourseId(Integer.valueOf(id));
		ss.deleteStudent(student);
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
		
	}
	
	
}
