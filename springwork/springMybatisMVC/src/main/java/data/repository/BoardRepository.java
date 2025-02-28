package data.repository;

import data.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    
    /**
     * 전체 게시글 수 조회
     * @return 전체 게시글 수
     */
    int getTotalCount();
    
    /**
     * 최대 게시글 번호 조회
     * @return 최대 게시글 번호
     */
    int getMaxIdx();
    
    /**
     * 답글 순서 재조정
     * @param regroup 재조정할 그룹 번호
     * @param restep 재조정할 단계 번호
     */
    void updateRestep(int regroup, int restep);
    
    /**
     * 게시글 등록
     * @param board 게시글
     */
    void insertBoard(Board board);
    
    /**
     * 페이지 번호에 해당하는 게시글 목록 조회
     * @param start 게시글 시작 번호
     * @param pageSize 페이지 당 게시글 수
     * @return 게시글 목록
     */
    List<Board> selectPaginatedBoards(int start, int pageSize);
    
    /**
     * 조회수 증가
     * @param idx 게시글 번호
     */
    void updateReadCount(int idx);
    
    /**
     * 게시글 조회 (인덱스)
     * @param idx 게시글 번호
     * @return 게시글
     */
    Board selectBoardByIdx(int idx);
    
    /**
     * 게시글 조회 (아이디)
     * @param id 아이디
     * @return 게시글 목록
     */
    List<Board> selectBoardsById(String id);
    
    /**
     * 게시글 수정
     * @param board 게시글
     */
    void updateBoard(Board board);
    
    /**
     * 게시글 삭제
     * @param idx 게시글 번호
     */
    void deleteBoard(int idx);
    
}
