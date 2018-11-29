package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Test;
public class DBUtilTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from course where cname = 'SSH'";
		DBUtil db = new DBUtil();
		/*
		 * 如果一个方法是静态方法，可以使用类名，方法调用
		 * 如果一个方法是普通方法，则需要使用构造方法创建对象调用
		 * 
		 * 数组：一旦创建了数组，大小长度不可变
		 * 集合框架：List,Set,Map
		 * Map的优势在于使用键值对，使用键值对的好处在于，键是唯一的，可以通过键直接获取值
		 * 
		 * 
		 * 如果在调用的方法体上抛异常throws **Exception
		 * 在调用方法的时候有两种方式：
		 * 1.try-catch包裹起来，异常处理
		 * 2.继续在调用本方法的方法上继续抛出异常
		 * 
		 * 
		 * java里通过包名来区分类名相同的情况，java.util
		 * 
		 * <>表示泛型，使用泛型的好处是：对键值做类型描述
		 * 
		 * Map<String,Object> getObject(String sql)
		 * 适用场景：
		 * 1.sql已经提前知道
		 * 2.参数较少，写到sql语句里
		 * 3.可以用来获取对象，获取对象的形式是键值对
		 * 4.尤其用于多表无法封装成一个对象的场景
		 * 5.适用于获取一条记录的情况
		 * */
		Map<String,Object> courseMap = db.getObject(sql);
		/*
		 * debug模式和run模式
		 * 开发的时候用debug，可以看到中间的过程，能够在自己关注的代码暂停，能够一行行执行代码
		 * 在自己关注的代码左侧双击，可以打断点
		 * 如果debug模式没有任何断点，和run模式一致
		 */
		System.out.println(courseMap);
		/*
		 * Map的遍历使用iterator
		 * Map的存储方式使用键值对，entry可以理解为键值对
		 */
		Iterator<Entry<String,Object>> it = courseMap.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Object> entry = (Entry<String,Object>) it.next();
			System.out.println(entry.getKey()+"@@@"+entry.getValue());
		}
		/*
		 * Object[]可以存放所有数据类型
		 * 
		 * 
		 * 在一个方法里变量不能定义两次
		 */
		String sql2 = "select * from course where cname = ?";
		Map<String,Object> courseMap2 = db.getObject(sql2,new Object[]{"SSH"});
		System.out.println(courseMap2);
		
		/*
		 * 练习1：test表，查询课程id是1的，并且由教师id是2的试卷
		 */
		String sql3 = "select * from test where courseId = ? and teacherId =?";
		Map<String,Object> courseMap3 = db.getObject(sql3,new Object[]{1,2});
		
		System.out.println("练习1的输出" + courseMap3);

		
		/*
		 * db.getObject(type, sql3, paramList)适用于表中字段较多
		 * 第一个参数表示要封装成的类的类型
		 * type需要是我们提供的po或vo，String这种不行
		 * 返回结果是封装好的po或vo，需要强制转换一下
		 * 
		 */
		Course c = (Course) db.getObject(Course.class,sql2,new Object[]{"SSH"});
		System.out.println("第三个方法的输出：" + c.getCname());
		
		/*
		 * 练习2：从Test表中查询出一条记录，封装成Test类对象，并输出所有字段
		 */
		
		Test t = (Test) db.getObject(Test.class, sql3, new Object[]{1,2});
		System.out.println("练习2的输出：" + t.toString());
		
		 /*
		 * 写PO的时候，一定要有无参构造方法
		 * 1.没有定义构造方法，则系统提供
		 * 2.定义了有参构造方法，一定要加一个无参构造方法
		 */
	}

}
