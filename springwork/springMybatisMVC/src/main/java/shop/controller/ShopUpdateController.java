package shop.controller;

import data.domain.Shop;
import data.service.NcpObjectStorageService;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopUpdateController {
    
    @Autowired
    ShopService shopService;
    
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/shop/updateForm")
    public String updateForm(Model model, @RequestParam int num) {
        Shop entity = shopService.getEntity(num);
        model.addAttribute("entity", entity);
        return "shop/updateForm";
    }
    
    @PostMapping("/shop/update")
    public String update(HttpServletRequest request, @ModelAttribute Shop shop,
                         @RequestParam("images")List<MultipartFile> files, @RequestParam String oldImages) {
        // 업로드할 경로
//        String uploadPath = request.getServletContext().getRealPath("/save");
        // 파일명 리스트
        List<String> fileNames = new ArrayList<>();
        
        // 파일 업로드
        for (MultipartFile file : files) {
            if (file.isEmpty()) break;
            
            // 파일명
//            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//            String fileName = java.util.UUID.randomUUID() + ext;
            
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
        if (fileNames.isEmpty()) {
            shop.setImage(oldImages);
        } else {
            shop.setImage(String.join(",", fileNames));
            
            // 기존 이미지 파일 삭제
            String[] oldImageArray = oldImages.split(",");
            for (String oldImage : oldImageArray) {
//                File file = new File(uploadPath + "/" + oldImage);
//                if (file.exists()) file.delete();
                storageService.deleteFile(bucketName, "shop", oldImage);
            }
        }
        
        // updateShop 메서드 호출
        shopService.updateShop(shop);
        
        return "redirect:./detail?num=" + shop.getNum();
    }
}
