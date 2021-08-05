package com.design.mediator.smarthouse;

//具体同事类：闹钟
public class Alarm extends Colleague {

	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
	}
	//闹钟响起
	public void SendAlarm(int stateChange) {
		System.out.println("闹钟响起");
		SendMessage(stateChange);
	}

	//同事之间进行交互
	@Override
	public void SendMessage(int stateChange) {
		this.GetMediator().GetMessage(stateChange, this.name);
	}

}
