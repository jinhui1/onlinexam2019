package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStudentDao;
import com.hp.onlinexam.dao.admin.StudentDao;
import com.hp.onlinexam.po.Student;

public class StudentService implements IStudentService {

	private IStudentDao sd = new StudentDao();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		sd.updateStudent(s);
	}

	@Override
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		sd.deleteStudent(s);
	}

	@Override
	public Map<String, Object> findStudentById(int id) {
		// TODO Auto-generated method stub
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll(String sname) {
		// TODO Auto-generated method stub
		return sd.findAll(sname);
	}

	@Override
	public List<Map<String, Object>> findLinkStudentInfo() {
		// TODO Auto-generated method stub
		return sd.findLinkStudentInfo();
	}

	@Override
	public List<Map<String, Object>> findClassName() {
		// TODO Auto-generated method stub
		return sd.findClassName();
	}

	

}
