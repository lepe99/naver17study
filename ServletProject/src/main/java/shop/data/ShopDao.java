package shop.data;

import mybatis.db.ConnectionManager;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShopDao {
    // ConnectionManager 객체를 생성
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    
    // SqlSession 객체를 생성
    SqlSession session;
    // namespace: SQL 맵퍼 파일의 네임스페이스
    String namespace = "shop.data.ShopDao.";
    
    /**
     * openSession 메서드를 호출하여 SqlSession 객체를 생성하여 반환
     * @return SqlSession 객체
     */
    private SqlSession getSession() {
        session = connectionManager.openSession();
        return session;
    }
    
    /**
     * shop의 전체 갯수를 반환
     * @return shop의 전체 갯수
     */
    public int getTotalCount() {
        session = this.getSession();
        // namespace는 생략 가능하나
        // 다른곳에 같은 이름의 쿼리가 있을 수 있으므로 namespace를 사용하는 것이 좋다.
        int tc = session.selectOne(namespace + "totalCount");
        session.close();
        return tc;
    }
    
    /**
     * shop의 전체 목록을 반환
     * @return shop의 전체 목록
     */
    public List<ShopDto> getAllDatas() {
        session = this.getSession();
        List<ShopDto> list = session.selectList(namespace + "selectAllList");
        session.close();
        return list;
    }
    
    /**
     * insertShop 쿼리 실행
     * @param dto ShopDto 객체
     */
    public void insertShop(ShopDto dto) {
        session = this.getSession();
        session.insert(namespace + "insertShop", dto);
        session.close();
    }
    
    /**
     * num에 해당하는 shop의 정보를 반환
     * @param num shop의 번호
     * @return num에 해당하는 shopDto 객체
     */
    public ShopDto getShop(int num) {
        session = this.getSession();
        ShopDto dto = session.selectOne(namespace + "selectOneByNum", num);
        session.close();
        return dto;
    }
    
    /**
     * updateShop 쿼리 실행
     * @param dto ShopDto 객체
     */
    public void updateShop(ShopDto dto) {
        session = this.getSession();
        session.update(namespace + "updateShop", dto);
        session.close();
    }
    
    /**
     * deleteShop 쿼리 실행
     * @param num shop의 번호
     */
    public void deleteShop(int num) {
        session = this.getSession();
        session.delete(namespace + "deleteShop", num);
        session.close();
    }
}
