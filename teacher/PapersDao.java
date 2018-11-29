package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Papers;
import com.hp.onlinexam.util.DBUtil;

public class PapersDao implements IPapersDao {
	
	private DBUtil db = new DBUtil();

	@Override
	public int save(Papers paper) {
		// TODO Auto-generated method stub
		String sql = "insert into papers(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{paper.getTestId(),paper.getCourseId(),paper.getTime(),paper.getScore(),paper.getWrongQueId(),paper.getWrongAns(),paper.getStdudentId(),paper.getCreateDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Map<String,Object> getPastPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		String sql = "select t.testName,p.score,t.questions,p.wrongQueId,p.wrongAns,c.cname from test t,papers p,course c where t.testId = p.testId and p.courseId = c.courseId and studentId = ? and p.testId = ?";
		Map<String,Object> paperMap = new HashMap();
		try {
			paperMap = db.getObject(sql, new Object[]{studentId,testId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			paperMap = new HashMap();
			e.printStackTrace();
		}
		return paperMap;
	}

	@Override
	public List getPaperByStudentId(int studentId,String cname) {
		// TODO Auto-generated method stub
		String sql = "select t.testName,t.testId,p.paperId,p.time,p.score,p.createDate,c.cname from test t,papers p,course c where t.testId = p.testId and p.courseId = c.courseId and studentId = ?";
		if(!"".equals(cname))
			sql += " and c.cname LIKE '%" + cname + "%'";
		List studentList = new ArrayList();
		try {
			studentList = db.getQueryList(sql, new Object[]{studentId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			studentList = new ArrayList();
			e.printStackTrace();
		}
		return studentList;
		
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select t.testName,t.endDate,sc.className,sc.deptName,c.cname,AVG(p.score) as avgScore from test t,stuclass sc,course c, papers p,student s where p.studentId=s.studentId and s.classId = sc.classId and p.courseId=c.courseId and p.testId=t.testId and p.testId in (SELECT t.testId from test as t where t.teacherId = ?) GROUP BY className,testName ORDER BY testName";
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperList;
	}

}
