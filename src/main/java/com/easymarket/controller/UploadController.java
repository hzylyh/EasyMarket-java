package com.easymarket.controller;


import com.easymarket.entity.Response;
import com.easymarket.utils.FileUtil;
import com.easymarket.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
@RequestMapping(value = "/v1/upload")
public class UploadController {

    @PostMapping(value = "/img")
    public Response imgUpload(@RequestParam("file")MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileUtil.saveImg(file.getBytes(), fileName);
        } catch (IOException e) {
            log.error("", e);
        }
        return ResponseUtil.success();
    }

}
