package com.example.ava.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ava.Model.File;
import com.example.ava.Repository.FileRepository;

@Service

public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public void saveFile(MultipartFile file) {
        try {
            File fileEntity = new File();
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setData(file.getBytes());
            fileRepository.save(fileEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFileById(String id) {
        File fileEntity = fileRepository.findById(id).orElse(null);
        if (fileEntity != null) {
            fileRepository.delete(fileEntity);
            return true;
        }
        return false;
    }

    public File getFileById(String id) {
        return fileRepository.findById(id).orElse(null);
    }
}