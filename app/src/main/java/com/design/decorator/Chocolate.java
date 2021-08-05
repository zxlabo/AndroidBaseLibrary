package com.design.decorator;

//�����Decorator�� ������ǵ�ζƷ
public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
		setDes("巧克力 ");
		setPrice(3.0f); // ��ζƷ �ļ۸�
	}

}
