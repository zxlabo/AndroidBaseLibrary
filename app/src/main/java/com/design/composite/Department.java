package com.design.composite;

//学院：不需要实现add和remove方法
public class Department extends OrganizationComponent {


	public Department(String name, String des) {
		super(name, des);
	}

	@Override
	protected void print() {
		System.out.println(name);
	}

}
