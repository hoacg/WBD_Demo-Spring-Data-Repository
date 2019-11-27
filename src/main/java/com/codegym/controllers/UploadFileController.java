package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

@Controller
public class UploadFileController {

    @GetMapping("/upload-file")
    public String getUploadForm() {
        return "upload-file";
    }

    @PostMapping("/upload-file")
    public String uploadFile(@RequestParam("imageFile") MultipartFile file) throws IOException {
        long time = System.currentTimeMillis();
        String fileName = time + "-" + file.getOriginalFilename();
        String filePath = "/Users/hoa/customer-management/uploads/" + fileName;
        file.transferTo(new File(filePath));
        return "index";
    }
}
