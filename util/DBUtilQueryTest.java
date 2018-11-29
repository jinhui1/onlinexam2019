package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Test;

public class DBUtilQueryTest {
	public static void main(String[] args) throws Exception{
		DBUtil db = new DBUtil();
		String sql = "select * from test";
		List<Map<String,Object>> testList = db.getQueryList(sql);
		for(int i = 0;i < testList.size();i ++){
			Map<String,Object> testMap = testList.get(i);
			Iterator<Entry<String,Object>> it = testMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry = (Entry<String,Object>) it.next();
				System.out.println(entry.getKey()+"@@@"+entry.getValue());
			}
		}
		System.out.println();
		
		
		String sql2 = "select * from test where courseId = ? and teacherId = ? ";
		List<Map<String,Object>> testList2 = db.getQueryList(sql2, new Object[]{1,2});
		System.out.println(testList2);
		System.out.println();
		
		/*
		 * 数组是一类相同数据类型的集合
		 * 声明：仅仅是定义数据类型和变量名
		 * 定义：除了声明外，有赋值
		 * 数组声明时，[]可以放变量前也可以放变量后
		 */
		/*
		 * String [] strArray;
		String strArray2 [];
		String [] strArray3 = new String[]{"pgthree","lixiaolu"};
		String [] strArray4 = {"pgthree","lixiaolu"};
		String [] strArray5 = new String[3];
		*/
	
		List testObjectList = db.getQueryList(Test.class, sql2, new Object[]{1,2});
		for(Object o : testObjectList){
			Test t = (Test) o;
			System.out.println(t);
		}
		System.out.println();
		/*
		 * 练习：
		 * 1.查询姓“zhang”的学生的学生成绩，查询结果肯定要包括学生姓名
		 * 2.查询“lisi”这个老师的排课表
		 * 3.查询所有的试题信息
		 */
		/*
		 * SELECT s.name ,p.score from student s,papers p where s.id=p.studentId and s.name like '张%'
		 * select 后跟要查询的字段，多个字段之间用逗号隔开
		 * from后跟查询的表，多个表之间用逗号隔开
		 * 表可以起别名student s 或student as s，as可以省略
		 * 起别名的好处在于多表查询可以表名简写
		 * 字段也可以起别名
		 * where后跟条件，多个条件之间用and连接，不是&&
		 * 模糊查询使用like，以张开头，张%
		 */
		String sql3 = "select * from papers";
		List<Map<String,Object>> testList21 = db.getQueryList(sql3);
		for(int i = 0;i < testList21.size();i ++){
			Map<String,Object> testMap2 = testList21.get(i);
			Iterator<Entry<String,Object>> it = testMap2.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry2 = (Entry<String,Object>) it.next();
				System.out.println(entry2.getKey()+"@@@"+entry2.getValue());
			}
		}
		System.out.println();
		String sql4 = "select papers.score,student.sname from papers,student where papers.studentId = student.studentId and sname LIKE '张%' ";
		List<Map<String,Object>> testList3 = db.getQueryList(sql4);
		for(int i = 0;i < testList3.size();i ++){
			Map<String,Object> testMap3 = testList3.get(i);
			Iterator<Entry<String,Object>> it = testMap3.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry3 = (Entry<String,Object>) it.next();
				System.out.println(entry3.getKey()+"@@@"+entry3.getValue());
			}
		}
		System.out.println();
		String sql5 = "select teacher.tname,teacher.teacherId,teachercourse.teachId,teachercourse.courseId,teachercourse.classId from teacher,teachercourse where tname = '李四' and teacher.teacherId = teachercourse.teacherId";
		List<Map<String,Object>> testList4 = db.getQueryList(sql5);
		for(int i = 0;i < testList4.size();i ++){
			Map<String,Object> testMap4 = testList4.get(i);
			Iterator<Entry<String,Object>> it = testMap4.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry4 = (Entry<String,Object>) it.next();
				System.out.println(entry4.getKey()+"@@@"+entry4.getValue());
			}
		}
	}
}
