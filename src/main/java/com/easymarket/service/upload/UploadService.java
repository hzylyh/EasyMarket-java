package com.easymarket.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String saveImg(MultipartFile file);
}
