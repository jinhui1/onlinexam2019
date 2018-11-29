package com.hp.onlinexam.po;

import java.util.Date;

public class Test {
	private int testId;
	private String testName;
	private int courseId;
	private Date endDate;
	private int testTime;
	private String questions;
	private int teacherId;
	private String classIds;
	private String scores;
	public Test(){
		
	}
	public Test(String testName,int courseId,Date endDate,int testTime,String questions,String classIds,String scores){
		this.testName = testName;
		this.courseId = courseId;
		this.endDate = endDate;
		this.testTime = testTime;
		this.questions = questions;
		this.classIds = classIds;
		this.scores = scores;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "[testId=" + testId + ", testName=" + testName + ", courseId=" + courseId + ", endDate=" + endDate
				+ ", testTime=" + testTime + ", questions=" + questions + ", teacherId=" + teacherId + ", classIds="
				+ classIds + ", scores=" + scores + "]";
	}
	
}
