package com.chl.test;

import java.io.File;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 09:55
 **/
public class Test {
    public static void main(String[] args) {
        search("D:/test/");
    }

    public static void search(String path) {
        File dir = new File(path);
        File[] subFiles = dir.listFiles();
        if (null != subFiles) {
            for (File subFile : subFiles) {
                String fileName = subFile.getName();
                if (subFile.isFile()) {
                    if ((fileName.endsWith(".jpg") || fileName.endsWith(".png"))) {
                        System.out.println(subFile.getName());
                    }
                }
            }
        }
    }
}

