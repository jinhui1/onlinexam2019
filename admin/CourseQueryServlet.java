package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = req.getParameter("cname");
		if(null == cname)
			cname = "";
		cname = new String(cname.getBytes("ISO-8859-1"),"utf-8");
		List courseList = cs.findAllCourses(cname);
		//System.out.println(courseList);
		req.setAttribute("cList", courseList);
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
