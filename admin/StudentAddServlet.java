package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {
	
	private IStudentService ss = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String,Object>> stuList = ss.findClassName();
		req.setAttribute("classList",stuList);
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sname = req.getParameter("sname");
		String school = req.getParameter("school");
		String classId = req.getParameter("classId");
		String sex = req.getParameter("sex");
		String bornDay = req.getParameter("bornDay");
		Student student = new Student();
		student.setSname(sname);
		student.setSchool(school);
		student.setClassId(Integer.valueOf(classId));
		student.setSex(sex);
		student.setBorn(bornDay);
		//System.out.println(stu);
		ss.addStudent(student);
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
	}
}
