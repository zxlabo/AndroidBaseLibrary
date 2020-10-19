package com.base;

import androidx.annotation.StringDef;


/**
 * author : Naruto
 * date   : 2020-09-16
 * desc   :
 * version:
 */
public class Person {
    public String name;
    public String personType;

    @StringDef({PersonType.STUDENT, PersonType.TEACHER})
    public @interface PersonType {
        public final static String STUDENT = "student";
        public final static String TEACHER = "teacher";
    }

    public Person(@PersonType String type, String name) {
        this.name = name;
        this.personType = type;
    }

}
