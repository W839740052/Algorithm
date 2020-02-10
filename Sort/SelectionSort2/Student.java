package com.wyh.selectionSort2;
import java.util.*;
public class Student implements Comparable<Student> {//这里要注意
	private String name;
	private int score;
	
	public Student(String name,int score) {
		this.name=name;
		this.score=score;
	}
	//定义Student的compareTo函数
	//如果分数相等，则按照名字的字母排序
	//如果分数不等，则分数高的靠前
	@Override
	public int compareTo(Student other) {
		
		
		if(this.score <other.score)
			return -1;
		else if(this.score>other.score)
			return 1;
		else//this.score==other.score
			return this.name.compareTo(other.name);
	}
	
	//定义Student的实例打印输出方式
	@Override
	public String toString() {
		return "Student"+this.name+" "+Integer.toString(this.score);
	}
	
}
