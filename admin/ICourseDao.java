package com.hp.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public interface ICourseDao {
	/**
	 * 修改为返回一个map
	 * @return
	 */
	public List<TeacherCourseView> findAllTeaCourInfo(String cname);
	/*
	 * 此方法用来根据课程编号找课程名称，用于在页面显示课程的下拉列表（课程名称不能随表添加，只能选择时）
	 */
	public List<Map<String, Object>> findCourseNameByCourseId();

	/**
	 * 根据课程名称查询是否课程存在，如果存在则返回课程，不存在返回null
	 * 
	 * @param name
	 * @return
	 */
	public Course findCourseByName(String name);
	public TeacherCourse findTeacherCourseById(int id);
	public void addCourse(String name);
	
	public void updateCourse(Course course);
	
	public Map<String,Object> findCourseById(int id);
	
	public void addTeacherCourse(TeacherCourse tc);
	

	/**
	 * 修改为map
	 * @param teaCourId
	 * @return
	 */
	public TeacherCourseView findTeaCourInfoById(int id) ;
	

	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCourses() ;
	
	/**
	 * 查找所有的课程
	 * 
	 * @return
	 */
	public List<Course> findAllCoursesByName(String name) ;
	/**
	 * 根据提供的TeacherCourse对象信息查询是否存在
	 * @param courseId
	 * @param teaId
	 * @param stuClassId
	 * @return true表示存在，false表示不存在
	 */
	public boolean isExitByAllIds(TeacherCourse tc) ;

	

	public void updateTeacherCourse(TeacherCourse tc) ;

	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) ;

	public void deleteTourse(int tcId);
	
	public void deleteCourse(Course course);

	/**
	 * 根据当前的教师id查询属于这个教师的课程
	 * @param teaId
	 * @return
	 */
	public List<Course> findCoursesByTeacherId(int teaId);
	
	public List<Course> findOneCourseNameByCourseId(int courseId);

}
