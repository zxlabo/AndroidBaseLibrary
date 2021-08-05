package com.design.mediator.smarthouse;

//ͬ抽象同事类
public abstract class Colleague {
	private Mediator mediator;
	public String name;

	public Colleague(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
		//将同事类注册到中介者当中
		mediator.Register(name, this);
	}

	public Mediator GetMediator() {
		return this.mediator;
	}

	public abstract void SendMessage(int stateChange);
}
