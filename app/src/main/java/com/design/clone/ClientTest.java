package com.design.clone;


public class ClientTest {

	public static void main(String[] args) {
		Person person = new Person();
		person.name = "小明";
		Person person1=person;
		System.out.println(person1.toString());
		person.name="hahha";
		System.out.println(person1.toString());
		System.out.println(person.hashCode());
		System.out.println(person1.hashCode());


	}

}
