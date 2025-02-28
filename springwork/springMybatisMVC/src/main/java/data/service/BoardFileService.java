package data.service;

import data.domain.BoardFile;
import data.repository.BoardFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardFileService {
    
    @Autowired
    BoardFileRepository boardFileRepository;
    
    public void insertBoardFile(BoardFile boardFile) {
        boardFileRepository.insertBoardFile(boardFile);
    }
    
    public List<BoardFile> selectBoardFilesByIdx(int idx) {
        return boardFileRepository.selectBoardFilesByIdx(idx);
    }
    
    public void deleteBoardFile(int num) {
        boardFileRepository.deleteBoardFile(num);
    }
    
    public void deleteBoardFileByFileName(String fileName) {
        boardFileRepository.deleteBoardFileByFileName(fileName);
    }
    
    public void deleteBoardFilesByIdx(int idx) {
        boardFileRepository.deleteBoardFilesByIdx(idx);
    }
}
