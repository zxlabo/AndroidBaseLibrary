package com.design.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {

    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    /**
     * 遍历学院
     */
    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("=== " + college.getName() + "=====");
            printDepartment(college.createIterator());
        }
    }


    /**
     * 遍历系
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }

}
