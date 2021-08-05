package com.design.command;

public class LightOnCommand implements Command {

	LightReceiver light;
	 //持有电灯接收者
	public LightOnCommand(LightReceiver light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
