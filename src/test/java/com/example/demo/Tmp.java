package com.example.demo;

import java.io.*;

/**
 * Created by ouyan on 7/7/2018.
 */
public class Tmp {

    public static void main (String [] args) {
        String str;
        try {
            FileInputStream fis = new FileInputStream("C:\\temp\\trash2\\workspace1\\src\\main\\resources\\application.properties");
            BufferedReader rb = new BufferedReader(new InputStreamReader(fis));
            while((str=rb.readLine()) != null) {
                System.out.println(str);
            }

        } catch (IOException e) {

        }
        System.out.print("hello");
    }

}
