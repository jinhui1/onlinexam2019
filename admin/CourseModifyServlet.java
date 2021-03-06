package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id = req.getParameter("id");
		Map<String,Object> courseMap =  cs.findCourseById(Integer.valueOf(id)); 
		req.setAttribute("course", courseMap);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("courseId");
		String cName = req.getParameter("cname");
		Course course = new Course();
		course.setCourseId(Integer.valueOf(id));
		course.setCname(cName);
		cs.updateCourse(course);
		resp.sendRedirect(req.getContextPath() + "/courseQueryServlet");
	}
	
	

}
