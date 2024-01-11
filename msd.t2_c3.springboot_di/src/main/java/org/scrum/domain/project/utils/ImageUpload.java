package org.scrum.domain.project.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUpload {
    private final String UPLOAD_FOLDER = "C:\\Users\\aandr\\OneDrive\\Desktop\\New folder";

    public void uploadImage(MultipartFile imageProduct) {
        try {
            Files.copy(imageProduct.getInputStream(),
                    Paths.get(UPLOAD_FOLDER + File.separator, imageProduct.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkExisted(MultipartFile imageProduct) {
        boolean isExisted = false;
        try {
            File file = new File(UPLOAD_FOLDER + "\\" + imageProduct.getOriginalFilename());
            isExisted = file.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExisted;
    }
}
