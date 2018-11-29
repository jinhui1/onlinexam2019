package com.hp.onlinexam.util;
/*
 * 用于execute方法的练习
 */
public class DBUtilExeTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		/*
		 * insert into +表名
		 * 如果是插入所有的列，则加values（值1，值2，...）
		 * 如果插入部分字段，在表名后，（字段1，字段2，...）
		 */
		String sql = "INSERT INTO course (cname) VALUES('java')";
		db.execute(sql);
		
		
		/*
		 * execute方法用于执行增加，删除和修改
		 */
		String sql2 = "insert into course (cname) values(?)";
		db.execute(sql2, new Object[]{"ssm"});
		
		/*
		 * 练习：删除课程名称是ssm的课程信息
		 */
		String sql3 = "delete from course where cname = ?";
		db.execute(sql3, new Object[]{"java"});
	}
}
