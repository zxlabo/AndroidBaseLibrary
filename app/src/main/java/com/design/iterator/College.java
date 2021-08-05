package com.design.iterator;

import java.util.Iterator;

public interface College {
	
	public String getName();
	//添加聚合对象
	public void addDepartment(String name, String desc);
	//创建迭代器对象
	public Iterator  createIterator();
}
