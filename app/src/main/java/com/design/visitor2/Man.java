package com.design.visitor2;

public class Man extends Person {

	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}

}
