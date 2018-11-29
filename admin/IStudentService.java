package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public void deleteStudent(Student s);
	public Map<String, Object> findStudentById(int id);
	public List<Map<String, Object>> findClassName();
	public List<Map<String,Object>> findAll(String sname);
	public List<Map<String,Object>> findLinkStudentInfo();
}
