package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

/*
 * dao层用于和数据库交互
 */

public class StuClassDao implements IStuClassDao {
	
	private DBUtil db = new DBUtil();
	
	/*
	 * findAllStuClassInfo()获取表中的所有信息
	 */
	@Override
	public List findAllStuClassInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass";
		List stuclassList = new ArrayList();
		try {
			stuclassList = db.getQueryList(StuClass.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuclassList = new ArrayList();
			e.printStackTrace();
		}
		return stuclassList;
	}
	
	/*
	 * findStuClassById(int classId)获取表中的一行
	 */
	@Override
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass where classId = ?";
		Map<String,Object> stuMap = new HashMap<String,Object>();
		try {
			stuMap =  db.getObject(sql, new Object[]{classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stuclass(className,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[]{sc.getClassName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stuclass set className = ?,deptName = ? where classId = ?";
		try {
			db.execute(sql, new Object[]{sc.getClassName(),sc.getDeptName(),sc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "delete from stuclass where classId =?";
		try {
			db.execute(sql, new Object[]{sc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select className from stuclass where classId in("+ ids +")";
		List<Map<String,Object>> cnameList = new ArrayList();
		try {
			cnameList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			cnameList = new ArrayList();
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < cnameList.size();i ++){
			sb.append(cnameList.get(i).get("className") + " ");
		}
		return sb.toString();
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass where classId in (select classId from teachercourse WHERE teacherId = ?)";
		List stuclassList = new ArrayList();
		try {
			stuclassList = db.getQueryList(StuClass.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuclassList = new ArrayList();
			e.printStackTrace();
		}
		return stuclassList;
	}
	public static void main(String [] args){
		/*
		 * 声明的时候一般会向上转型，有父类和子类之间的关系，有接口和实现类之间的关系
		 * 优点之一：如果IStuClassDao有多个实现，例如StuClassDao2()
		 * 使用向上转型，直接改定义这一行即可
		 */
		IStuClassDao scd = new StuClassDao();
		List scList = scd.findAllStuClassInfo();
	}

	@Override
	public List<Map<String, Object>> findStuClassNameByClassId() {
		// TODO Auto-generated method stub
		String sql = "select classId,className from stuclass";
		List<Map<String,Object>> stuclassList = new ArrayList<Map<String,Object>>();
		try {
			stuclassList = db.getQueryList(sql);
			//System.out.println(stuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuclassList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		return stuclassList;
	}
}
