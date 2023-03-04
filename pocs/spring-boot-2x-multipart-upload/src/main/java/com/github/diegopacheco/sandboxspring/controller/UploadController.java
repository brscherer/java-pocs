package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RestController
public class UploadController {

    @Value("${file.upload-dir}")
    private String fileDirectory;

    @PostMapping("/up")
    public ResponseEntity<Object> uploadFile(@RequestParam("File") MultipartFile file) throws IOException {
        File convertFile = new File(fileDirectory + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<Object>("The File Uploaded Successfully.", HttpStatus.OK);
    }

    @RequestMapping(path = "/up2", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> uploadFile2(@RequestPart("File") MultipartFile document) throws IOException {
        System.out.println(document);
        System.out.println("Filename: " + document.getOriginalFilename());
        System.out.println("Content: " + document.getContentType());
        System.out.println("Resource: " + document.getResource());
        System.out.println("size: " + document.getSize());

        FileOutputStream out = new FileOutputStream(new
                File(fileDirectory + "/upload_" + document.getOriginalFilename()));
        Path path = Path.of(fileDirectory + "/upload_" + document.getOriginalFilename());
        Files.copy(document.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

        return new ResponseEntity<Object>("Ok. Got it!", HttpStatus.OK);
    }

}
