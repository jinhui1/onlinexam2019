package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id = req.getParameter("id");
		Map<String,Object> teaMap = ts.findTeacherInfo(Integer.valueOf(id));
		//System.out.println(teaMap);
		req.setAttribute("teacher", teaMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teachermodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("teacherId");
		String stuName = req.getParameter("teaname");
		String pwd = req.getParameter("password");
		String depInfo = req.getParameter("depInfo");
		Teacher tea = new Teacher();
		tea.setTeacherId(Integer.valueOf(id));
		tea.setTname(stuName);
		tea.setPwd(pwd);
		tea.setDeptName(depInfo);
		ts.updateTeacher(tea, Integer.valueOf(id));
		resp.sendRedirect(req.getContextPath() + "/teacherQueryServlet");
	}
}
