package com.chl.test;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 10:12
 **/
public class JavaProgrammer implements Programmer {
    private final String name;

    public JavaProgrammer(String name) {
        this.name = name;
    }

    @Override
    public void coding(BaseComputer computer) {
        System.out.println("Java程序员" + this.name + "在用" + computer.getBrand() + "敲代码,电脑尺寸为：" + computer.getSize());
    }
}
