package com.hook;

/**
 * author : Naruto
 * date   : 4/15/21
 * desc   :
 * version:
 */
class PersonA {
   public String name;

    public PersonA(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "name='" + name + '\'' +
                '}';
    }
}
