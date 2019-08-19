package com.easymarket.utils;

import java.io.*;

public class FileUtil {

    public static String saveImg(byte[] fileBytes, String fileName) throws IOException {
        String targetPath = "G:\\codedir\\java\\smartweb-java\\upload\\";
        File targetFilePath = new File(targetPath);
        if(!targetFilePath.exists()){
            targetFilePath.mkdirs();
        }
        String filePath = targetPath + fileName;
        FileOutputStream out = new FileOutputStream(filePath);
        out.write(fileBytes);
        out.flush();
        out.close();
        return filePath;
    }
}
