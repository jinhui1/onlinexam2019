package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {
	
	private DBUtil db = new DBUtil();
	
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = "select q.questionsId,q.courseId,q.queType,q.queTitle,q.choiceA,q.choiceB,q.choiceC,q.choiceD,q.ans,c.cname from questions q,course c WHERE q.courseId = c.courseId";
		if(null != key&& !"".equals(key)&& null != value){
			sql += " and " + key + " like '%" + value +"%'";
//			if("cname".equals(key))
//				sql += " and cname like '%" + value +"%'";
//			else if("queTitle".equals(key)){
//				sql += " and queTitle like '%" + value +"%'";
//			}
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Questions q) {
		// TODO Auto-generated method stub
		String sql = "insert into questions(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where questionsId = ?";
		Map<String,Object> quesMap = new HashMap<String,Object>();
		//System.out.println(stuMap);
		try {
			quesMap =  db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			quesMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return quesMap;
	}

	@Override
	public List<Questions> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where FIND_IN_SET(questionsId,?)";
		List questionList = new ArrayList();
		try {
			questionList = db.getQueryList(Questions.class, sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			questionList = new ArrayList();
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public void updateQuestionInfo(Questions q) {
		// TODO Auto-generated method stub
		String sql = "update questions set courseId = ?,queType = ?,queTitle = ?,choiceA = ?,choiceB = ?,choiceC = ?,choiceD = ?,ans = ? where questionsId = ?";
		try {
			db.execute(sql, new Object[]{q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getQuestionsId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where courseId = ?";
		List<Map<String, Object>> queList = new ArrayList();
		try {
			queList = db.getQueryList(sql, new Object[]{courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queList = new ArrayList();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from questions where questionsId =?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
