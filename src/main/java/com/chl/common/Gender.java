package com.chl.common;

/**
 * @description: 性别枚举
 * @author: mqxu
 **/
public enum Gender {
    /**
     * 枚举
     */
    secret(0, "保密"),
    male(1, "男"),
    female(2, "女");

    public final Integer type;
    public final String value;

    Gender(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
