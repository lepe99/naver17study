package data.repository;

import data.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 스프링이 관리하는 빈으로 등록 (mybatis Mapper)
public interface ShopRepository {
    
    /**
     * 상품 종류 수 조회
     * @return 상품 종류 수
     */
    int getTotalCount();
    
    /** 상품 등록
     * @param shop 상품 정보
     */
    void insertShop(Shop shop);
    
    /** 모든 상품 조회
     * @return 모든 상품 정보
     */
    List<Shop> getAllEntities();
    
    /** 상품 상세 조회
     * @param num 상품 번호
     * @return 상품 정보
     */
    Shop getEntity(int num);
    
    /**
     * 상품 정보 수정
     * @param shop 상품 정보
     */
    void updateShop(Shop shop);
    
    /**
     * 상품 삭제
     * @param num 상품 번호
     */
    void deleteShop(int num);
}
