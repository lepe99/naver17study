package shop.controller;

import data.domain.Shop;
import data.service.NcpObjectStorageService;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ShopAddController {
    
    @Autowired
    ShopService shopService;
    
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/shop/addForm")
    public String addForm() {
        return "shop/addForm";
    }
    
    @PostMapping("/shop/insert")
    public String insert(HttpServletRequest request, @ModelAttribute Shop shop,
                         @RequestParam("images") List<MultipartFile> files) {
        // 업로드할 경로
//        String uploadPath = request.getServletContext().getRealPath("/save");
        
        // 파일명 리스트
        List<String> fileNames = new ArrayList<>();
        
        for (MultipartFile file : files) {
            // 파일명 (랜덤값.ext)
//            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//            String fileName = UUID.randomUUID() + ext;
            
            // 네이버 스토리지에 사진 저장 / 사진 업로드 후 파일명 반환
            String fileName = storageService.uploadFile(bucketName, "shop", file);
            
            // 파일명 리스트에 추가
            fileNames.add(fileName);
            
            // 파일 업로드
//            try {
//                file.transferTo(new File(uploadPath + "/" + fileName));
//            } catch (IOException | IllegalStateException e) {
//                throw new RuntimeException(e);
//            }
        }
        
        // 파일명을 Shop 객체에 저장
        shop.setImage(String.join(",", fileNames)); // 파일명을 ,로 구분하여 저장
        
        // insertShop 메서드 호출
        shopService.insertShop(shop);
        
        return "redirect:./list"; // redirect: URL로 이동
    }
}
