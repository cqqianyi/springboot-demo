package com.hellokoding.uploadingfiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author qianyi
 */
@Controller
public class UploadController {
    public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";

    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String uploading(Model model) {
        File file = new File(uploadingdir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    /**
     * 多文件上传
     * @param uploadingFiles
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingdir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "redirect:/";
    }
}
