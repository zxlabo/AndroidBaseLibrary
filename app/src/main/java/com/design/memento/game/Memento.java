package com.design.memento.game;

public class Memento {

	//攻击力
	private int vit;
	//防御力
	private int def;

	public Memento(int vit, int def) {
		this.vit = vit;
		this.def = def;
	}

	public int getVit() {
		return vit;
	}
	public int getDef() {
		return def;
	}

}
