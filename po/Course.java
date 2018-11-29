package com.hp.onlinexam.po;
/*
 * 课程类，描述课程实体
 */
public class Course {
	/*
	 * java的数据类型有哪些？
	 * 基本数据类型和引用数据类型
	 * 基本数据类型有八种：byte,short,int,long,float,double,char,boolean
	 * 引用数据类型：类，接口，数组
	 * */
	private int courseId;
	/*
	 * java访问权限有几种：private,public,protected
	 * */
	private String cname;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
