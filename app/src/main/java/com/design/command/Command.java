package com.design.command;


public interface Command {
	//执行
	public void execute();
	//撤销
	public void undo();
}
