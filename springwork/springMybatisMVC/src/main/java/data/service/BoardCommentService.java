package data.service;

import data.domain.BoardComment;
import data.repository.BoardCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentService {
    
    @Autowired
    BoardCommentRepository boardCommentRepository;
    
    public void insertBoardComment(BoardComment boardComment) {
        boardCommentRepository.insertBoardComment(boardComment);
    }
    
    public List<BoardComment> selectBoardCommentsByNum(int num) {
        return boardCommentRepository.selectBoardCommentsByNum(num);
    }
    
    public void deleteBoardComment(int idx) {
        boardCommentRepository.deleteBoardComment(idx);
    }
    
    public void updateBoardComment(BoardComment boardComment) {
        boardCommentRepository.updateBoardComment(boardComment);
    }
    
    public int selectBoardCommentCount(int num) {
        return boardCommentRepository.selectBoardCommentCount(num);
    }
}
