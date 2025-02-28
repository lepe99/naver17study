package data.repository;

import data.domain.BoardFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileRepository {
    
    /**
     * 파일 등록
     * @param boardFile 게시글 파일
     */
    void insertBoardFile(BoardFile boardFile);
    
    /**
     * 파일 조회 (게시글 인덱스)
     * @param idx 게시글 번호
     * @return 게시글 파일 목록
     */
    List<BoardFile> selectBoardFilesByIdx(int idx);
    
    /**
     * 파일 삭제
     * @param num 파일 번호
     */
    void deleteBoardFile(int num);
    
    /**
     * 파일 삭제 (파일 이름)
     * @param fileName 파일 이름
     */
    void deleteBoardFileByFileName(String fileName);
    
    /**
     * 파일 삭제 (게시글 인덱스)
     * @param idx 게시글 번호
     */
    void deleteBoardFilesByIdx(int idx);
}
