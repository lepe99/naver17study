package reboard.data;

import mybatis.db.ConnectionManager;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDao {
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    
    SqlSession session;
    String namespace = "reboard.data.BoardDao.";
    
    /**
     * SqlSession 객체를 가져오는 메소드
     * @return SqlSession 객체
     */
    private SqlSession getSession() {
        session = connectionManager.openSession();
        return session;
    }
    
    /**
     * 최대 글번호를 가져오는 메소드
     * @return 최대 글번호
     */
    public int getMaxNum() {
        session = getSession();
        int maxNum = session.selectOne(namespace + "getMaxNum");
        session.close();
        return maxNum;
    }
    
    /**
     * 전체 글의 개수를 가져오는 메소드
     * @return 전체 글의 개수
     */
    public int getTotalCount() {
        session = getSession();
        int totalCount = session.selectOne(namespace + "totalCount");
        session.close();
        return totalCount;
    }
    
    /**
     * 페이지 단위로 글 목록을 가져오는 메소드
     * @param start 시작 글번호
     * @param perPage 페이지 당 글의 개수
     * @return 글 목록
     */
    public List<BoardDto> selectPagingList(int start, int perPage) {
        session = getSession();
        Map<String, Integer> map = Map.of("start", start, "perPage", perPage);
        List<BoardDto> list = session.selectList(namespace + "selectPagingList", map);
        session.close();
        return list;
    }
    
    /**
     * restep을 1씩 증가시키는 메소드
     * @param regroup 그룹번호
     * @param restep 답글 순서
     */
    public void updateRestep(int regroup, int restep) {
        session = getSession();
        Map<String, Integer> map = Map.of("regroup", regroup, "restep", restep);
        session.update(namespace + "updateRestep", map);
        session.close();
    }
    
    /**
     * 글을 추가하는 메소드
     * @param dto 글 정보
     */
    public void insertBoard(BoardDto dto) {
        int num = dto.getNum();
        int regroup = dto.getRegroup();
        int restep = dto.getRestep();
        int relevel = dto.getRelevel();
        
        if (num == 0) { // 새로운 글
            regroup = getMaxNum() + 1;
            restep = 0;
            relevel = 0;
        } else { // 답글
            // 같은 그룹에서 restep보다 큰 데이터들의 restep을 1씩 증가시킴
            updateRestep(regroup, restep);
            // 전달받은 restep과 relevel을 1씩 증가시킴
            restep++;
            relevel++;
        }
        
        // 변경된 데이터들을 다시 dto에 저장
        dto.setRegroup(regroup);
        dto.setRestep(restep);
        dto.setRelevel(relevel);
        
        session = getSession();
        session.insert(namespace + "insertBoard", dto);
        session.close();
    }
    
    /**
     * 조회수 증가 메소드
     * @param num 글번호
     */
    public void updateReadCount(int num) {
        session = getSession();
        session.update(namespace + "updateReadCount", num);
        session.close();
    }
    
    /**
     * 글 정보 가져오는 메소드
     * @param num 글번호
     * @return 글 정보
     */
    public BoardDto getData(int num) {
        session = getSession();
        BoardDto dto = session.selectOne(namespace + "selectOneByNum", num);
        session.close();
        return dto;
    }
}
