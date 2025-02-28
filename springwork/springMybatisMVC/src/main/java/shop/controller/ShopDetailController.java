package shop.controller;

import data.domain.Shop;
import data.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopDetailController {
    
    @Autowired
    ShopService shopService;
    
    @GetMapping("/shop/detail")
    public String shopDetail(Model model, @RequestParam int num) {
        Shop entity = shopService.getEntity(num);
        
        model.addAttribute("entity", entity);
        model.addAttribute("objectStorageUrl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-120");
        return "shop/detail";
    }
}
