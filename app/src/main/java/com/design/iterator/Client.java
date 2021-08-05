package com.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<College> collegeList = new ArrayList<College>();
		ComputerCollege computerCollege = new ComputerCollege();
		collegeList.add(computerCollege);
		OutPutImpl outPutImpl = new OutPutImpl(collegeList);
		outPutImpl.printCollege();
	}

}
