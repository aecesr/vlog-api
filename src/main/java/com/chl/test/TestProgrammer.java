package com.chl.test;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 10:22
 **/
public class TestProgrammer {
    public static void main(String[] args) {
        BaseComputer completer = new MacBook("MacBook Pro", 13);
        Programmer programmer = new JavaProgrammer("小王");
        programmer.coding(completer);
    }
}
