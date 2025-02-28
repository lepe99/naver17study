package data.service;

import data.domain.Board;
import data.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    
    @Autowired
    BoardRepository boardRepository;
    
    public int getTotalCount() {
        return boardRepository.getTotalCount();
    }
    
    public int getMaxIdx() {
        return boardRepository.getMaxIdx();
    }
    
    public void updateRestep(int regroup, int restep) {
        boardRepository.updateRestep(regroup, restep);
    }
    
    public void insertBoard(Board board) {
        int idx = board.getIdx();
        int regroup = board.getRegroup();
        int restep = board.getRestep();
        int relevel = board.getRelevel();
        
        // 새 글인 경우
        if (idx == 0) {
            regroup = getMaxIdx() + 1;
            restep = 0;
            relevel = 0;
        } else {
            // 답글인 경우
            // 같은 그룹의 단계 번호 재조정
            updateRestep(regroup, restep);
            restep++;
            relevel++;
        }
        
        board.setRegroup(regroup);
        board.setRestep(restep);
        board.setRelevel(relevel);
        
        boardRepository.insertBoard(board);
    }
    
    public List<Board> selectPaginatedBoards(int start, int pageSize) {
        return boardRepository.selectPaginatedBoards(start, pageSize);
    }
    
    public void updateReadCount(int idx) {
        boardRepository.updateReadCount(idx);
    }
    
    public Board selectBoardByIdx(int idx) {
        return boardRepository.selectBoardByIdx(idx);
    }
    
    public List<Board> selectBoardsById(String id) {
        return boardRepository.selectBoardsById(id);
    }
    
    public void updateBoard(Board board) {
        boardRepository.updateBoard(board);
    }
    
    public void deleteBoard(int idx) {
        boardRepository.deleteBoard(idx);
    }
}
