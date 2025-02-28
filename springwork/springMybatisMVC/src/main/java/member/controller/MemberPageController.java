package member.controller;

import data.domain.Board;
import data.domain.Member;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import data.service.NcpObjectStorageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MemberPageController {
    
    
    final MemberService memberService;
    final NcpObjectStorageService storageService;
    final BoardService boardService;
    final BoardFileService boardFileService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/member/memberPage")
    public String memberPage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");
        Member member = memberService.getMemberById(id);
        
        //  내가 쓴 게시글 정보 추가
        List<Board> myBoards = boardService.selectBoardsById(id);
        for (Board board : myBoards) {
            int count = boardFileService.selectBoardFilesByIdx(board.getIdx()).size();
            board.setImageCount(count);
        }
        
        // 모델에 저장
        model.addAttribute("myBoards", myBoards);
        model.addAttribute("member", member);
        // 모델에 objectStorage 주소 추가
        model.addAttribute("objectStorageUrl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-120");
        return "member/memberPage";
    }
    
    @PostMapping("/member/updateImage")
    @ResponseBody
    public String updateImage(HttpSession session, HttpServletRequest request,
                              @RequestParam("upload") MultipartFile file, @RequestParam int num) {
        // 기존 사진 삭제
//        String uploadPath = request.getServletContext().getRealPath("/save");
        // null safe
        String image = Optional.ofNullable(session.getAttribute("loginImage")).orElse("").toString();
//        File oldImage = new File(uploadPath + "/" + image);
//        if(oldImage.exists()) oldImage.delete();
        // 네이버 스토리지에서 사진 삭제
        storageService.deleteFile(bucketName, "member", image);
        
        
        // 바뀐 사진 업로드
//        String fileName = file.getOriginalFilename();
//        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//        fileName = UUID.randomUUID() + "." + ext;
//        try {
//            file.transferTo(new File(uploadPath + "/" + fileName));
//        } catch (IOException | IllegalStateException e) {
//            throw new RuntimeException(e);
//        }
        
        // 네이버 스토리지에 사진 저장
        String fileName = storageService.uploadFile(bucketName, "member", file);
        
        // 사진 변경
        memberService.updateImage(fileName, num);
        
        // 세션 이미지 변경
        session.setAttribute("loginImage", fileName);
        
        return "success";
    }
}
