package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class TestDao implements ITestDao {
	
	private DBUtil db = new DBUtil();

	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "insert into test(courseId,teacherId,testName,endDate,scores,testTime,classIds,questions) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{t.getCourseId(),t.getTeacherId(),t.getTestName(),t.getEndDate(),t.getScores(),t.getTestTime(),t.getClassIds(),t.getQuestions()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		/*
		 * SELECT t.*,c.name courseName, GROUP_CONCAT(sc.name) as classNames from test t, course c,stuclass as sc where t.courseId=c.id and t.endDate > ? and FIND_IN_SET(sc.id,t.classIds) and t.teacherId = ? GROUP BY t.id
		 */
		String currentTime = ToolUtil.getCurrentTime();
		String sql = "select t.testId,t.testName,t.endDate,c.cname,t.testTime,t.questions,t.teacherId,t.classIds,t.scores from test t, course c where t.courseId = c.courseId and endDate > ? and teacherId = ?";
		List<Map<String, Object>> testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[]{currentTime,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		// TODO Auto-generated method stub
		String sql = "select t.testId,t.courseId,t.testName,t.endDate,c.cname,t.testTime,t.questions,t.teacherId,t.classIds,t.scores from test t, course c where t.courseId = c.courseId and testId = ? and teacherId = ?";
		Map<String, Object> testMap = new HashMap();
		try {
			testMap = (Map<String, Object>) db.getObject(sql, new Object[]{id,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testMap = new HashMap();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		String sql = "select t.testId,t.testName,t.courseId,t.scores,t.questions,c.cname,sc.className,sc.classId,s.studentId,s.classId from test t,course c, student s,stuclass sc where t.courseId = c.courseId and sc.classId = s.classId and s.studentId = ? and t.testId = ?";
		Map<String, Object> testMap = new HashMap();
		try {
			testMap = db.getObject(sql, new Object[]{studentid,testid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testMap = new HashMap();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		//String sql = "SELECT t.testId,t.testName,t.courseId,t.endDate,t.teacherId,t.classIds,c.cname courseName, GROUP_CONCAT(sc.className) as classNames from test t, course c,student stu,stuclass as sc where t.courseId=c.courseId and stu.studentId = 4 and t.endDate > '2018-01-16 10:10:10' and FIND_IN_SET(stu.classId,t.classIds) GROUP BY t.testId;";
		String sql = "SELECT DISTINCT t.testId,c.cname as courseName ,t.testName,t.endDate from test t,student s , course c , papers p WHERE t.courseId = c.courseId and FIND_IN_SET(s.classId,t.classIds) and s.studentId = ? and t.endDate > ? and t.testId not in (SELECT papers.testId from papers where papers.studentId = ? ) ORDER BY s.studentId";
		List<Map<String, Object>> testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[]{id,currData,id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public String findClassIdsByTestId(int testId) {
		// TODO Auto-generated method stub
//		String sql = "select classIds from test where testId = ?";
//		Map<String,Object> classIdsMap = new HashMap();
//		try {
//			classIdsMap = db.getObject(sql, new Object[]{testId});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			classIdsMap = new HashMap();
//			e.printStackTrace();
//		}
//		StringBuffer sb = new StringBuffer();
////		for(int i = 0;i < classIdsMap.size();i ++){
//			sb.append(classIdsMap.get("classIds") + ",");
////		}
//		return sb.toString();
		return null;
	}

	@Override
	public void deleteTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "delete from test where testId =?";
		try {
			db.execute(sql, new Object[]{t.getTestId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
