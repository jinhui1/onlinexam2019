package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStuClassService scs = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.setAttribute("courseList", cs.findCourseNameByCourseId());
		req.setAttribute("teaList", ts.findTeacherNameByTeacherId());
		req.setAttribute("stuclList", scs.findStuClassNameByClassId());
		req.getRequestDispatcher("manager/scheduleadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String course = req.getParameter("course");
		String teacher = req.getParameter("teacher");
		String stuclass = req.getParameter("stuclass");
		TeacherCourse teacourse = new TeacherCourse();
		teacourse.setCourseId(Integer.valueOf(course));
		teacourse.setTeacherId(Integer.valueOf(teacher));
		teacourse.setClassId(Integer.valueOf(stuclass));
		cs.addSchedule(teacourse);
		resp.sendRedirect(req.getContextPath() + "/scheduleQueryServlet");
	}
	
	
}
