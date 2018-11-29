package com.hp.onlinexam.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestArraytoString {
	public static void main(String [] args){
//		String [] strArray = new String[]{"计科1501班","计科1503班","4","6"};
//		String arrayTest = ToolUtil.arraytoString(strArray);
//		System.out.println(arrayTest);
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Collections.shuffle(list);
		for(int i = 0;i < list.size();i ++){
			System.out.println(list.get(i));
		}
	}
	
}
