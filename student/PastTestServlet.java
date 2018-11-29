package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.PaperService;

@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet {
	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Student s = (Student) req.getSession().getAttribute("user");
		String cname = req.getParameter("courseSearch");
		if(null == cname)
			cname = "";
		cname = new String(cname.getBytes("ISO-8859-1"),"utf-8");
		List paperList = ps.getPaperByStudentId(s.getStudentId(),cname);
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
