package com.design.express;

import java.util.HashSet;
import java.util.Set;

//终结符表达式类
class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) set.add(data[i]);
    }

    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}