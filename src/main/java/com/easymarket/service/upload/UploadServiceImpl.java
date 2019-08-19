package com.easymarket.service.upload;

import com.easymarket.conf.MyException;
import com.easymarket.conf.ResultEnum;
import com.easymarket.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String saveImg(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String serverPath = null;
        int a = 10/0;
        try {
            serverPath = FileUtil.saveImg(file.getBytes(), fileName);
        } catch (IOException e) {
            log.error("", e);
            throw new MyException(ResultEnum.UPLOAD_FILE_EMPTY);
        }
        return serverPath;
    }
}
