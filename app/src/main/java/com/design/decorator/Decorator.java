package com.design.decorator;

public class Decorator extends Drink {

	private Drink obj;
	
	public Decorator(Drink obj) {
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		// 计算价格：装饰者的价格+订单的价格
		return getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {
		//描述
		return des +getPrice() + "元，" + obj.getDes();
	}

}
