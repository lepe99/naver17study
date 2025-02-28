package board.controller;

import data.domain.BoardComment;
import data.service.BoardCommentService;
import data.service.MemberService;
import data.service.NcpObjectStorageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommentController {
    
    final BoardCommentService boardCommentService;
    final MemberService memberService;
    final NcpObjectStorageService storageService;
    
    private final String bucketName = "bitcamp-bucket-120";
    
    // 댓글 등록
    @PostMapping("/comment/insert")
    public String insertBoardComment(@ModelAttribute BoardComment boardComment, HttpSession session,
                                   @RequestParam("upload") MultipartFile file) {
        // 세션에서 회원 아이디 가져오기
        String id = session.getAttribute("loginId").toString();
        boardComment.setId(id);
        
        // 파일 업로드
        if (file != null && !file.isEmpty()) {
            String fileName = storageService.uploadFile(bucketName, "comment", file);
            boardComment.setImage(fileName);
        }
        
        // insert
        boardCommentService.insertBoardComment(boardComment);
        
        return "success";
    }
    
    // 댓글 조회는 BoardController에서 수행
    
    // 댓글 수정
    @PostMapping("/comment/update")
    public String updateBoardComment(@ModelAttribute BoardComment boardComment,
                                     @RequestParam("upload") MultipartFile file) {
        
        // 파일이 변경되었다면 기존 파일 클라우드에서 삭제 후 업로드
        if (file != null && !file.isEmpty()) {
            storageService.deleteFile(bucketName, "comment", boardComment.getImage());
            String fileName = storageService.uploadFile(bucketName, "comment", file);
            boardComment.setImage(fileName);
        }
        
        // update
        boardCommentService.updateBoardComment(boardComment);
        
        return "success";
    }
    
    // 댓글 삭제
    @PostMapping("/comment/delete")
    public String deleteBoardComment(@RequestParam int idx, @RequestParam String image) {
        // 파일 삭제
        storageService.deleteFile(bucketName, "comment", image);
        
        // delete
        boardCommentService.deleteBoardComment(idx);
        
        return "success";
    }
}
