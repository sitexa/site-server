package com.sitexa;

import java.util.Scanner;

/**
 * 价值一个亿的AI程序
 */
public class AiMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(sc.next()
                    .replace("吗", "")
                    .replace("?", "!")
                    .replace("？","")
            );
        }
    }
}
