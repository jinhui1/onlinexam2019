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

@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet {
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String courseSearch = req.getParameter("courseSearch");
		if(null == courseSearch)
			courseSearch = "";
		courseSearch = new String(courseSearch.getBytes("ISO-8859-1"),"utf-8");
		List tcList = cs.findAll(courseSearch);
		//System.out.println(tcList);
		req.setAttribute("tcList", tcList);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
