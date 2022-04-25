package com.chl.test;

import java.util.*;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 11:40
 **/
public class Demo {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars"};
        List<String> list = new ArrayList<>(Arrays.asList(planets));
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        Set<String> set = new TreeSet<>(Arrays.asList(planets));
        set.add("Earth");
        System.out.println(set);
        Arrays.asList(planets).replaceAll(s -> new StringBuilder(s).reverse().toString());
        System.out.println(Arrays.toString(planets));
    }
}
