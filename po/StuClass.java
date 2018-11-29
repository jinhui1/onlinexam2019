package com.hp.onlinexam.po;

public class StuClass {
	private int classId;
	private String className;
	private String deptName;
//	public StuClass(){
//		
//	}
//	public StuClass(int classId, String className, String deptName) {
//		super();
//		this.classId = classId;
//		this.className = className;
//		this.deptName = deptName;
//	}
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
