package data.repository;

import data.domain.BoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCommentRepository {
    
    /**
     * 댓글 등록
     * @param boardComment - 댓글 정보
     */
    void insertBoardComment(BoardComment boardComment);
    
    /**
     * 글 번호에 해당하는 댓글 조회
     * @param num 글 번호
     * @return 댓글 목록
     */
    List<BoardComment> selectBoardCommentsByNum(int num);
    
    /**
     * 댓글 삭제
     * @param idx 댓글 번호
     */
    void deleteBoardComment(int idx);
    
    /**
     * 댓글 수정
     * @param boardComment 댓글 정보
     */
    void updateBoardComment(BoardComment boardComment);
    
    /**
     * 글 번호에 해당하는 댓글 수 조회
     */
    int selectBoardCommentCount(int num);
    

}
