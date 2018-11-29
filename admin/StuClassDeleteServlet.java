package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

@WebServlet("/stuClassDeleteServlet")
public class StuClassDeleteServlet extends HttpServlet {
	private IStuClassService stu = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		StuClass sc = new StuClass();
		sc.setClassId(Integer.valueOf(id));
		//Map<String,Object> stuMap = stu.findStuClassById(Integer.valueOf(id));
		//req.setAttribute("stuClass", stuMap);
		stu.deleteStuClass(sc);
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}

}
