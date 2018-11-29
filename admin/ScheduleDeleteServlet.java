package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.vo.TeacherCourseView;

@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String tcId = req.getParameter("info");
		TeacherCourse teachercourse = new TeacherCourse();
		teachercourse.setTeachId(Integer.valueOf(tcId));
		//course.setCourseId(Integer.valueOf(id));
		cs.deleteTeacherCourse(Integer.valueOf(tcId));
		resp.sendRedirect(req.getContextPath() + "/scheduleQueryServlet");
	}
}
