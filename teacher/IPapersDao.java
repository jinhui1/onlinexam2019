package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Papers;

public interface IPapersDao {
	
	public int save(Papers  paper);
	
	public Map<String,Object> getPastPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId,String cname);
	
	//所有的班级平级成绩。
	public List getPaperCompare(int teaId);
}
