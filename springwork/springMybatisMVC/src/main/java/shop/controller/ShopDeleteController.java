package shop.controller;

import data.service.NcpObjectStorageService;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class ShopDeleteController {
    
    @Autowired
    ShopService shopService;
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/shop/delete")
    public String delete(HttpServletRequest request, @RequestParam int num, @RequestParam String oldImages) {
        shopService.deleteShop(num);
        
        // 기존 이미지 삭제
//        String uploadPath = request.getServletContext().getRealPath("/save");
        String[] oldImageArray = oldImages.split(",");
        
        for (String oldImage : oldImageArray) {
//            File file = new File(uploadPath + "/" + oldImage);
//            if (file.exists()) {
//                file.delete();
//            }
            
            // 네이버 스토리지에서 사진 삭제
            storageService.deleteFile(bucketName, "shop", oldImage);
        }
        
        return "redirect:./list";
    }
}
