package com.hp.onlinexam.po;

public class Student {
	private int studentId;
	private String sname;
	private String pwd;
	private String school;
	private String deptName;
	private String sex;
	private String born;
	private int classId;
	public Student(){
		
	}
	public Student(String sname, String school, String sex, String born, int classId){
		this.sname = sname;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}
	public Student(String sname,String pwd,String school,String deptName,String sex,String born,int classId){
		
		this.sname = sname;
		this.pwd = pwd;
		this.school = school;
		this.deptName = deptName;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sname=" + sname + ", pwd=" + pwd + ", school=" + school
				+ ", deptName=" + deptName + ", sex=" + sex + ", born=" + born + ", classId=" + classId + "]";
	}
	public static void main(String [] args){
		/*
		 * 构造方法：用来创建对象，可以初始化成员变量
		 * 如果没有提供构造方法，系统提供默认构造方法，无参
		 *构造方法可以重载
		 *构造方法和普通方法有区别，构造方法名和类名完全相同*/
		Student s = new Student();
		s.setSname("李小璐");
		Student s2 = new Student("贾乃亮","123","绿色大学","艺术系","男","1985",1);
	}
}
