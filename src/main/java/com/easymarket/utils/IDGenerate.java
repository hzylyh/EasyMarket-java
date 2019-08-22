package com.easymarket.utils;

import java.util.UUID;

public class IDGenerate {
    public static String getID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
