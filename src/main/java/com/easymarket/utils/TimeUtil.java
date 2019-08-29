package com.easymarket.utils;

public class TimeUtil {
    public static Long getNow() {
        long timestamp = System.currentTimeMillis();
        return timestamp;
    }

    public static void main(String[] args) {
        System.out.println(getNow());
    }
}
