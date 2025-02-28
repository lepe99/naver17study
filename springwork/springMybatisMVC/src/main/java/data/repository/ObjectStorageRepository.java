package data.repository;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageRepository {
    String uploadFile(String bucketName, String directoryPath, MultipartFile file);
    void deleteFile(String bucketName,String directoryPath,String fileName);
}
