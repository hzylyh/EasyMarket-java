package com.easymarket.utils;

import java.io.*;

public class FileUtil {

    public static void saveImg(byte[] fileBytes, String fileName) throws IOException {
        String targetPath = "G:\\codedir\\java\\smartweb-java\\upload\\";
        File targetFilePath = new File(targetPath);
        if(!targetFilePath.exists()){
            targetFilePath.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetPath + fileName);
        out.write(fileBytes);
        out.flush();
        out.close();
    }
}
