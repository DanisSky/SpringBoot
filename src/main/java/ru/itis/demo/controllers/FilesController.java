package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.demo.services.FileStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/files")
public class FilesController {

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/upload")
    public String getFilesUploadPage() {
        return "file_upload_page";
    }

    @PostMapping("/")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = fileStorageService.saveFile(file);
        return ResponseEntity.ok()
                .body(filePath);
    }

    @GetMapping("/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileName, response);
    }

    @GetMapping("/")
    public void getFileByUrl(@RequestParam(value = "url", required = true) String url ,HttpServletResponse response) {
        fileStorageService.writeFileToResponseByUrl(url, response);
    }
}
