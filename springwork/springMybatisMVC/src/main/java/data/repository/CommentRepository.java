package data.repository;

import data.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentRepository {
    
    /** 댓글 등록
     * @param comment 댓글 정보
     */
    void insertComment(Comment comment);
    
    /** 댓글 삭제
     * @param idx 댓글 번호
     */
    void deleteComment(int idx);
    
    /** 댓글 불러오기
     * @param num 글 번호
     * @return 댓글 정보
     */
    List<Comment> getComment(int num);
    
    /** 댓글 좋아요
     * @param map 댓글 번호와 좋아요 수
     */
    void updateLike(Map<String, Integer> map);
}
