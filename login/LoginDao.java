package com.hp.onlinexam.dao.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao {
	private DBUtil db = new DBUtil();

	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where tname = ? and pwd = ?";
		Teacher t2 = new Teacher();
		try {
			t2 = (Teacher) db.getObject(Teacher.class, sql, new Object[]{t.getTname(),t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t2 = null;
			e.printStackTrace();
		}
		return t2;
	}

	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		String sql = "select * from student where sname = ? and pwd = ?";
		Student stu = new Student();
		try {
			stu = (Student) db.getObject(Student.class, sql, new Object[]{s.getSname(),s.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stu = null;
			e.printStackTrace();
		}
		return stu;
	}

}
