package com.hellokoding.uploadingfiles;

import com.hellokoding.uploadingfiles.controller.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        new File(UploadController.uploadingdir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}