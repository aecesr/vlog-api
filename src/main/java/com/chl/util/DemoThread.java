package com.chl.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 12:12
 **/
public class DemoThread  implements Runnable{

    @Override
    public void run() {

        LocalDateTime target = LocalDateTime.of(2020, 12, 18, 12, 19, 10);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            if (now.isAfter(target)) {
                System.out.println("over");
                break;
            }else{
                try {
                    System.out.println(dtf.format(now));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new DemoThread()).start();
    }
}
