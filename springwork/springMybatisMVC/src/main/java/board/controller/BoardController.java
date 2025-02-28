package board.controller;

import data.domain.Board;
import data.domain.BoardComment;
import data.domain.BoardFile;
import data.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    final BoardService boardService;
    final BoardFileService boardFileService;
    final MemberService memberService;
    final BoardCommentService boardCommentService;
    
    // NCP Object Storage 서비스
    final NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/writeForm")
    // idx, regroup, restep, relevel 파라미터는 답글을 작성할 때 사용, 기본값은 0
    public String writeForm(@RequestParam(defaultValue = "0") int idx, @RequestParam(defaultValue = "0") int regroup,
                            @RequestParam(defaultValue = "0") int restep, @RequestParam(defaultValue = "0") int relevel,
                            @RequestParam(defaultValue = "1") int pageNum, Model model) {
        model.addAttribute("idx", idx);
        model.addAttribute("regroup", regroup);
        model.addAttribute("restep", restep);
        model.addAttribute("relevel", relevel);
        model.addAttribute("pageNum", pageNum);
        return "board/writeForm";
    }
    
    @GetMapping("/detail")
    public String detail(@RequestParam int idx, @RequestParam(defaultValue = "1") int pageNum, Model model) {
        // 조회수 증가
        boardService.updateReadCount(idx);
        // idx에 해당하는 게시글 정보 가져오기
        Board board = boardService.selectBoardByIdx(idx);
        
        // idx에 해당하는 파일 정보 가져오기
        List<String> fileList = new ArrayList<>();
        List<BoardFile> boardFiles = boardFileService.selectBoardFilesByIdx(idx);
        
        for (BoardFile boardFile : boardFiles) {
            fileList.add(boardFile.getFileName());
        }
        
        board.setImages(fileList);
        
        // 멤버 테이블에서 사진 얻기
        String profileImage = memberService.getMemberById(board.getId()).getImage();
        
        // 댓글 목록 가져오기
        List<BoardComment> commentList = boardCommentService.selectBoardCommentsByNum(idx);
        
        // 댓글 개수 가져오기
        int commentCount = commentList.size();
        board.setCommentCount(commentCount);
        
        // model에 담아서 전달
        model.addAttribute("board", board);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("profileImage", profileImage);
        model.addAttribute("commentList", commentList);
        model.addAttribute("objectStorageUrl", "https://kr.object.ncloudstorage.com/" + bucketName);
        model.addAttribute("frontUrl", "https://ymf0kmgk8726.edge.naverncp.com/hNwdEsMHVP");
        model.addAttribute("backUrl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
        
        
        return "board/boardDetail";
    }
    
    @PostMapping("/insert")
    public String insert(@ModelAttribute Board board, @RequestParam int pageNum,
                         @RequestParam("upload") List<MultipartFile> files, HttpSession session) {
        // 세션에서 id 획득
        String id = (String) session.getAttribute("loginId");
        
        // 작성자 획득
        String writer = memberService.getMemberById(id).getName();
        
        // db insert (idx 미리 얻어오기 위해)
        board.setId(id);
        board.setWriter(writer);
        boardService.insertBoard(board);
        
        // insert 후 idx 획득
        int idx = board.getIdx();
        
        // 파일 업로드
        for (MultipartFile file : files) {
            if (file.isEmpty()) break;
            String fileName = storageService.uploadFile(bucketName, "board", file);
            
            // db (boardFile) insert
            BoardFile boardFile = new BoardFile();
            boardFile.setIdx(idx);
            boardFile.setFileName(fileName);
            boardFileService.insertBoardFile(boardFile);
        }
        
        
        return "redirect:./list?pageNum=" + pageNum;
    }
    
    @GetMapping("/updateForm")
    public String updateForm(@RequestParam int idx, @RequestParam int pageNum, Model model) {
        // idx에 해당하는 게시글 정보 가져오기
        Board board = boardService.selectBoardByIdx(idx);
        
        // idx에 해당하는 파일 정보 가져오기
        List<BoardFile> boardFiles = boardFileService.selectBoardFilesByIdx(idx);
        
        // 파일 이름 리스트
        List<String> fileList = new ArrayList<>();
        for (BoardFile boardFile : boardFiles) {
            fileList.add(boardFile.getFileName());
        }
        
        // model에 담아서 전달
        model.addAttribute("board", board);
        model.addAttribute("fileList", fileList);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("objectStorageUrl", "https://kr.object.ncloudstorage.com/" + bucketName);
        
        return "board/updateForm";
    }
    
    
    @PostMapping("/update")
    @ResponseBody
    public String update(@ModelAttribute Board board,
                         @RequestParam(value = "deleteImages", required = false) List<String> deleteImages,
                         @RequestParam("upload") List<MultipartFile> uploadImages) {
        
        // 이미지 삭제
        if (deleteImages != null && !deleteImages.isEmpty()) {
            for (String image : deleteImages) {
                if (image == null) break;
                boardFileService.deleteBoardFileByFileName(image);
                storageService.deleteFile(bucketName, "board", image);
            }
        }
        
        // 이미지 추가
        for (MultipartFile image : uploadImages) {
            if (image.isEmpty()) break;
            String fileName = storageService.uploadFile(bucketName, "board", image);
            BoardFile boardFile = new BoardFile();
            boardFile.setIdx(board.getIdx());
            boardFile.setFileName(fileName);
            boardFileService.insertBoardFile(boardFile);
        }
        
        // db update
        boardService.updateBoard(board);
        return "success";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int idx, @RequestParam int pageNum) {
        // 파일 삭제
        List<BoardFile> boardFiles = boardFileService.selectBoardFilesByIdx(idx);
        for (BoardFile boardFile : boardFiles) {
            storageService.deleteFile(bucketName, "board", boardFile.getFileName());
        }
        
        // db delete
        boardService.deleteBoard(idx);
        boardFileService.deleteBoardFilesByIdx(idx);
        
        return "redirect:./list?pageNum=" + pageNum;
    }
}
