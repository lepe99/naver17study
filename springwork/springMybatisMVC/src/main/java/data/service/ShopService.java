package data.service;

import data.domain.Shop;
import data.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링이 관리하는 빈으로 등록 (서비스)
public class ShopService {
    
    @Autowired
    ShopRepository shopRepository; // 스프링이 스프링 컨테이너에 있는 ShopRepository를 가져와 연결시켜줌
    
    public int getTotalCount() {
        return shopRepository.getTotalCount();
    }
    
    public void insertShop(Shop shop) {
        shopRepository.insertShop(shop);
    }
    
    public List<Shop> getAllEntities() {
        return shopRepository.getAllEntities();
    }
    
    public Shop getEntity(int num) {
        return shopRepository.getEntity(num);
    }
    
    public void updateShop(Shop shop) {
        shopRepository.updateShop(shop);
    }
    
    public void deleteShop(int num) {
        shopRepository.deleteShop(num);
    }
}
