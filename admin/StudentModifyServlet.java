package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	
	private IStudentService ss = new StudentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Map<String,Object> studentMap = ss.findStudentById(Integer.valueOf(id));
		req.setAttribute("student", studentMap);
		req.setAttribute("classList", ss.findClassName());
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("studentId");
		String sName = req.getParameter("sname");
		String school = req.getParameter("school");
		String classId = req.getParameter("classId");
		String sex = req.getParameter("sex");
		String bornDay = req.getParameter("bornDay");
		Student student = new Student();
		student.setStudentId(Integer.valueOf(id));
		student.setSname(sName);
		student.setSchool(school);
		student.setClassId(Integer.valueOf(classId));
		student.setSex(sex);
		student.setBorn(bornDay);
		ss.updateStudent(student);
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
	}
}
