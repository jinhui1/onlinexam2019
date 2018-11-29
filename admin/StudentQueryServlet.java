package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;

@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet {
	
	private IStudentService ss = new StudentService();
	private IStuClassService scs = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String sname = req.getParameter("sname");
		if(null == sname)
			sname = "";
		sname = new String(sname.getBytes("ISO-8859-1"),"utf-8");
		//List stuclassList = scs.findStuClassNameByClassId();
		List stuList = ss.findAll(sname);
		//System.out.println(courseList);
		req.setAttribute("sList", stuList);
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
