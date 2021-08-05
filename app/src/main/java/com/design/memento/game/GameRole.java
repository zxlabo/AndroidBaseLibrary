package com.design.memento.game;

public class GameRole {

	private int vit;//角色的攻击力
	private int def;//角色的防御力

	//创建Memento ,即根据当前的状态得到Memento
	public Memento createMemento() {
		return new Memento(vit, def);
	}

	//从备忘录对象，恢复GameRole的状态
	public void recoverGameRoleFromMemento(Memento memento) {
		this.vit = memento.getVit();
		this.def = memento.getDef();
	}

	//显示当前游戏角色的状态
	public void display() {
		System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力: " + this.def);
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
