package com.design.bridge;

/**
* 客户端调用者
 */
public class Client {

	public static void main(String[] args) {
		//创建折叠的小米手机
		Phone phone1 = new FoldedPhone(new XiaoMi());
		phone1.open();
		phone1.call();
		phone1.close();
	}

}
