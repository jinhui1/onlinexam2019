package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/studentPastTestServlet")
public class StudentPastTestServlet extends HttpServlet {
	
	private IPaperService ps = new PaperService();
	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		Student s = (Student) req.getSession().getAttribute("user");
		String testId = req.getParameter("testId");
		Map<String,Object> paperMap = ps.getPastPaperByStudentId(s.getStudentId(), Integer.valueOf(testId));
		String [] questionId = ((String) paperMap.get("questions")).split(",");
		String [] wrongQueId = ((String) paperMap.get("wrongQueId")).split(",");
		String [] wrongAns = ((String) paperMap.get("wrongAns")).split(",");
		List queList = new ArrayList();
		for(int i = 0;i < questionId.length;i ++){
			Map<String, Object> queMap = qs.findQuestionById(Integer.valueOf(questionId[i]));
			String ans = (String) queMap.get("ans");
			int flag = 0;
			for(int j = 0;j < wrongAns.length;j ++){
				if(wrongQueId[j].equals( questionId[i])){					
					queMap.put("reply", wrongAns[j]);
					flag = 1;
					break;
				}
			}
			if(flag == 0){
				queMap.put("reply", ans);
	
			}
			queList.add(queMap);
		}
		req.setAttribute("test", paperMap);
		req.setAttribute("quesList", queList);
		req.getRequestDispatcher("student/pasttest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.getRequestDispatcher(req.getContextPath() +"/pastTestServlet").forward(req, resp);
	}
}
