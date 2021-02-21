package com.kawa.youli.entity.common;

public enum Sex {
    MAN("男"),WOMAN("女"),UNKNOWN("不详");

    private String sex;
    Sex(String sex) {
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
