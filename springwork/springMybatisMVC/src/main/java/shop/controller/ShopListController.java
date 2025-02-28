package shop.controller;

import data.domain.Shop;
import data.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ShopListController {
    
    @Autowired
    ShopService shopService; // 스프링이 스프링 컨테이너에 있는 ShopService를 가져와 연결시켜줌
    
    @GetMapping("/shop/list")
    public String shopList(Model model) {
        int totalCount = shopService.getTotalCount();
        // 모델에 저장
        model.addAttribute("totalCount", totalCount);
        
        // 전체 상품 목록
        List<Shop> entityList = shopService.getAllEntities();
        // 모델에 저장
        model.addAttribute("entityList", entityList);
        
        // 메인 사진 리스트
        List<String> mainImageList = new ArrayList<>();
        
        // 메인 사진 등록
        for (Shop entity : entityList) {
            String mainImage = entity.getImage().split(",")[0];
            mainImageList.add(mainImage);
        }
        // 모델에 저장
        model.addAttribute("mainImageList", mainImageList);
        model.addAttribute("frontUrl", "https://ymf0kmgk8726.edge.naverncp.com/hNwdEsMHVP");
        model.addAttribute("backUrl", "?type=f&w=150&h=170&faceopt=true&ttype=jpg");
        
        return "shop/shopList";
    }
}
