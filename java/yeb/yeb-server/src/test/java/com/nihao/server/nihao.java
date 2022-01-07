package com.nihao.server;

import java.util.TimeZone;

public class nihao {

    public static void main(String[] args) {

        //获得当前的默认时区
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
    }

}
