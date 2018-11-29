package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {
	
	DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo(String name) {
		// TODO Auto-generated method stub
		String sql = "select tc.teachId as tcId,tc.teacherId,t.tname as teacherName,tc.courseId,c.cname as courseName,tc.classId,sc.className as stuclassName from teachercourse as tc,teacher t,course c,stuclass sc where tc.teacherId = t.teacherId and tc.courseId = c.courseId and tc.classId = sc.classId";
		if(!"".equals(name))
			sql += " and cname LIKE '%" + name + "%'";
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(TeacherCourseView.class, sql, new Object[]{});
			//System.out.println(tcList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(cname) values(?)";
		try {
			db.execute(sql, new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set cName = ? where courseId = ?";
		try {
			db.execute(sql, new Object[]{course.getCname(),course.getCourseId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from course where courseId = ?";
		Map<String, Object> courseMap = new HashMap<String,Object>();
		try {
			courseMap =  db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return courseMap;
	}
	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "insert into teachercourse(courseId,teacherId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[]{tc.getCourseId(),tc.getTeacherId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from teachercourse where teachId = ?";
		TeacherCourseView cv = new TeacherCourseView();
		try {
			cv = (TeacherCourseView) db.getObject(TeacherCourseView.class, sql, new Object[]{id});
			//System.out.println(cv.getTcId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			cv = new TeacherCourseView();
			e.printStackTrace();
		}
		return cv;
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		if(!"".equals(name))
			sql += " where cname LIKE '%" + name + "%'";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/*
			 * 出了异常之后，teaList有可能是null，或者出了异常后，程序执行有问题
			 */
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "update teachercourse set teacherId = ?,courseId = ?,classId = ? where teachId = ?";
		try {
			db.execute(sql, new Object[]{tc.getTeacherId(),tc.getCourseId(),tc.getClassId(),tc.getTeachId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		// TODO Auto-generated method stub
		String sql = "delete from teachercourse where teachId =?";
		try {
			db.execute(sql, new Object[]{tcId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "delete from course where courseId =?";
		try {
			db.execute(sql, new Object[]{course.getCourseId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from course where courseId in (select courseId from teachercourse where teacherId = ?)";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Map<String, Object>> findCourseNameByCourseId() {
		// TODO Auto-generated method stub
		String sql = "select courseId,cname from course";
		List<Map<String,Object>> courseList = new ArrayList<Map<String,Object>>();
		try {
			courseList = db.getQueryList(sql);
			//System.out.println(stuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findOneCourseNameByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select cname from course where courseId = ?";
		return null;
	}
}
