package com.design.decorator;

public class CoffeeBar {

	public static void main(String[] args) {

		//1、创建单品美式咖啡
		Drink order = new LongBlack();
		System.out.println("美式咖啡：" + order.cost()+"元，desc:"+ order.getDes());

		// 2. 美式咖啡+牛奶
		order = new Milk(order);
		System.out.println("美式咖啡+牛奶：" + order.cost()+"元，desc:"+ order.getDes());

		// 3. 美式咖啡+牛奶+巧克力
		order = new Chocolate(order);
		System.out.println("美式咖啡+牛奶+巧克力：" + order.cost()+"元，desc:"+ order.getDes());
	}

}
