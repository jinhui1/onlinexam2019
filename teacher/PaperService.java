package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IPapersDao;
import com.hp.onlinexam.dao.teacher.PapersDao;
import com.hp.onlinexam.po.Papers;

public class PaperService implements IPaperService {
	
	private IPapersDao pd = new PapersDao();

	@Override
	public int save(Papers paper) {
		// TODO Auto-generated method stub
		pd.save(paper);
		return 0;
	}

	@Override
	public Map<String,Object> getPastPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return pd.getPastPaperByStudentId(studentId, testId);
	}

	@Override
	public List getPaperByStudentId(int studentId,String cname) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId,cname);
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return pd.getPaperCompare(teaId);
	}

}
