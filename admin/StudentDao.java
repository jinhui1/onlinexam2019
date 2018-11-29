package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao {
	
	private DBUtil db = new DBUtil();

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student(sname,school,sex,born,classId) values(?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getSname(),s.getSchool(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "update student set sname = ?,school = ?,sex = ?,born = ?,classId = ? where studentId = ?";
		try {
			db.execute(sql, new Object[]{s.getSname(),s.getSchool(),s.getSex(),s.getBorn(),s.getClassId(),s.getStudentId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "delete from student where studentId =?";
		try {
			db.execute(sql, new Object[]{s.getStudentId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from student where studentId = ?";
		Map<String,Object> stuMap = new HashMap<String,Object>();
		//System.out.println(stuMap);
		try {
			stuMap =  db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public List<Map<String, Object>> findAll(String name) {
		// TODO Auto-generated method stub
		String sql = "select studentId,sname,school,s.classId,sex,born,sc.className from student s,stuclass sc where s.classId = sc.classId";
		if(!"".equals(name))
			sql += " and sname LIKE '%" + name + "%'";
		List stuList = new ArrayList();
		try {
			stuList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/*
			 * 出了异常之后，teaList有可能是null，或者出了异常后，程序执行有问题
			 */
			stuList = new ArrayList();
			e.printStackTrace();
		}
		return stuList;
		
	}
	@Override
	public List<Map<String, Object>> findLinkStudentInfo() {
		// TODO Auto-generated method stub
		String sql = "select s.studentId,s.sname,s.school,s.deptName,s.sex,s.born,s.classId,sc.className as 'classname' from student s,stuclass sc where s.classId = sc.classId;";
		List<Map<String,Object>> stuList = new ArrayList<Map<String,Object>>();
		try {
			stuList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public List<Map<String, Object>> findClassName() {
		// TODO Auto-generated method stub
		String sql = "select classId,className from stuclass";
		List<Map<String,Object>> stuList = new ArrayList<Map<String,Object>>();
		try {
			stuList = db.getQueryList(sql);
			//System.out.println(stuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		return stuList;
	}

}
