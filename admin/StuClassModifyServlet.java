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

/*
 * 用于修改班级信息
 */

@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
	private IStuClassService stu = new StuClassService();
	/*
	 * 用于获取当前对象，把当前对象送到要跳转的页面
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		Map<String,Object> stuMap = stu.findStuClassById(Integer.valueOf(id));
		//System.out.println(stuMap);
		req.setAttribute("stuClass", stuMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassmodify.jsp").forward(req,resp);
	}
	/*
	 * 在页面上修改当前对象的值并提交，页面跳转
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("stuClassId");
		String stuName = req.getParameter("stuname");
		String depInfo = req.getParameter("depInfo");
		StuClass sc = new StuClass();
		sc.setClassId(Integer.valueOf(id));
		sc.setClassName(stuName);
		sc.setDeptName(depInfo);
		stu.updateStuClass(sc);
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
	
}
