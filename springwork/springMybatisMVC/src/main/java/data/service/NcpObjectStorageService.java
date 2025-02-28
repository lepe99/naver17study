package data.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import data.domain.NaverConfig;
import data.repository.ObjectStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


// https://guide.ncloud-docs.com/docs/storage-storage-8-1
@Service
public class NcpObjectStorageService implements ObjectStorageRepository {
    AmazonS3 s3;
    
    public NcpObjectStorageService(NaverConfig naverConfig) {
        System.out.println("NcpObjectStorageService 생성");
        
        s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        naverConfig.getEndPoint(), naverConfig.getRegionName()))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        naverConfig.getAccessKey(), naverConfig.getSecretKey())))
                .build();
    }
    
    @Override
    public String uploadFile(String bucketName, String directoryPath, MultipartFile file) {
        System.out.println("uploadFile = " + file.getOriginalFilename());
        
        if (file.isEmpty()) return null;
        
        try (InputStream fileIn = file.getInputStream()) { // InputStream : 파일을 byte 단위로 읽어오는 클래스
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm_");
            String originalFilename = file.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = sdf.format(new Date()) + UUID.randomUUID().toString().substring(0, 10)
                    + "." + ext;
            
            ObjectMetadata objectMetadata = new ObjectMetadata(); // 파일의 메타데이터를 저장하는 클래스
            objectMetadata.setContentType(file.getContentType());
            
            // PutObjectRequest : 파일을 업로드하는 요청 객체
            /*
             * bucketName : 버킷 이름
             * directoryPath : 파일이 저장될 디렉토리 경로
             * fileIn : 업로드할 파일의 InputStream
             * objectMetadata : 업로드할 파일의 메타데이터
             * withCannedAcl : 업로드할 파일의 접근 권한 설정
             * CannedAccessControlList.PublicRead : 업로드한 파일을 모든 사용자가 읽을 수 있도록 설정
             */
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName,
                    directoryPath + "/" + filename, fileIn, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            
            s3.putObject(objectRequest); // 파일 업로드
            
            //return s3.getUrl(bucketName, directoryPath + filename).toString(); // 파일 URL 반환
            return filename;
            
        } catch (Exception e) {
            throw new RuntimeException("파일 업로드 오류", e);
        }
        
    }
    
    @Override
    public void deleteFile(String bucketName, String directoryPath, String fileName) {
        String path = directoryPath + "/" + fileName;
        //해당 버킷에 파일이 존재할 경우 삭제
        if (s3.doesObjectExist(bucketName, path)) {
            s3.deleteObject(bucketName, path);
            System.out.println(path + ": 삭제완료");
        }
    }
}
