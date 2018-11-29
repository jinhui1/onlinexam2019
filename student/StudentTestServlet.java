package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Papers;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/studentTestServlet")
public class StudentTestServlet extends HttpServlet {
	
	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();
	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String testid = req.getParameter("testId");
		Student s = (Student) req.getSession().getAttribute("user");
		
		Map<String, Object> testMap = ts.findStudentTestsById(s.getStudentId(), Integer.valueOf(testid));
		String [] questionId = ((String) testMap.get("questions")).split(",");
		int avg = Integer.parseInt(((String) testMap.get("scores")))/questionId.length;
	
		List<Map<String, Object>> quesList = new ArrayList<Map<String, Object>>();
		for(int i = 0;i < questionId.length;i ++){
			Map<String, Object> quesMap = qs.findQuestionById(Integer.valueOf(questionId[i]));
			quesList.add(quesMap);
		}
		req.getSession().setAttribute("test", testMap);
		req.setAttribute("scoreperques", 1.0*avg);
		req.getSession().setAttribute("quesList", quesList);
		req.getRequestDispatcher("student/exam.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String time = req.getParameter("hidden1");
		Map testMap = (Map) req.getSession().getAttribute("test");
		List quesList = (List) req.getSession().getAttribute("quesList");
		
		if (null == quesList || quesList.size()<1)
			return ;
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		int wrongQueNum = 0;
		
		String [] questionId = ((String) testMap.get("questions")).split(",");
		
		for(int i = 0;i < questionId.length;i ++){
			StringBuffer answer = new StringBuffer("ques_");
			answer.append(questionId[i]);
			String ans = answer.toString();
			String ansValue = req.getParameter(ans);
			
			Map<String, Object> queMap = qs.findQuestionById(Integer.valueOf(questionId[i]));
			String  ansArr = (String) queMap.get("ans");
			if(!ansArr.equals(ansValue)){
				wrongQueId.append(queMap.get("questionsId")).append(",");
				wrongAns.append(ansValue).append(",");
				wrongQueNum++;
			}
			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createDate = ToolUtil.getCurrentTime();
		Date date = new Date();
		try {
			date = sdf.parse(createDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Papers p = new Papers();
		p.setTestId((int) testMap.get("testId"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		p.setCreateDate(date);
		if(wrongQueNum < quesList.size())
			p.setScore(1.0*Integer.parseInt((String) testMap.get("scores"))/quesList.size()*(quesList.size()-wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")){
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
		}
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStdudentId(s.getStudentId());
		ps.save(p);
		resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
	}
}
