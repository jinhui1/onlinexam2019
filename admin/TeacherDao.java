package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher";
		if(!"".equals(name))
			sql += " where tname LIKE '%" + name + "%'";
		List teaList = new ArrayList();
		try {
			teaList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/*
			 * 出了异常之后，teaList有可能是null，或者出了异常后，程序执行有问题
			 */
			teaList = new ArrayList();
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher(tname,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[]{teacher.getTname(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		// TODO Auto-generated method stub
		String sql = "update teacher set tName = ?,deptName = ?,pwd = ? where teacherId = ?";
		try {
			db.execute(sql, new Object[]{teacher.getTname(),teacher.getDeptName(),teacher.getPwd(),teacher.getTeacherId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTeacher(Teacher teacher, int oldid) {
		// TODO Auto-generated method stub
		String sql = "delete from teacher where teacherId =?";
		try {
			db.execute(sql, new Object[]{teacher.getTeacherId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where teacherId = ?";
		Map<String,Object> teaMap = new HashMap<String,Object>();
		try {
			teaMap =  db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			teaMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return teaMap;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
//		String sql = "select * from teacher where teacherId = ?";
//		List teaList = new ArrayList();
//		try {
//			teaList = db.getQueryList(sql, new Object[]{teacherId});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			teaList = new ArrayList();
//			e.printStackTrace();
//		}
//		return teaList;
		return null;
	}

	@Override
	public List<Map<String, Object>> findTeacherNameByTeacherId() {
		// TODO Auto-generated method stub
		String sql = "select teacherId,tname from teacher";
		List<Map<String,Object>> teacherList = new ArrayList<Map<String,Object>>();
		try {
			teacherList = db.getQueryList(sql);
			//System.out.println(stuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			teacherList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		return teacherList;
	}
}
