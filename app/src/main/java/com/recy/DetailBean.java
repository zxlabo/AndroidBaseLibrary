package com.recy;

/**
 * author : Naruto
 * date   : 2020/10/29
 * desc   :
 * version:
 */

public class DetailBean {
    private boolean isTitle;
    private String name;
    private String tag=null;
    private int position;

    public DetailBean(boolean isTitle, String name, String tag, int position) {
        this.isTitle = isTitle;
        this.name = name;
        this.tag = tag;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public DetailBean(boolean isTitle, String name, String tag) {
        this.isTitle = isTitle;
        this.name = name;
        this.tag = tag;
    }
}