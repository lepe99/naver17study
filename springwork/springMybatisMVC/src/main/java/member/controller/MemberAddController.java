package member.controller;

import data.domain.Member;
import data.service.MemberService;
import data.service.NcpObjectStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member") // /member로 시작하는 모든 요청에 대해 처리
public class MemberAddController {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/form")
    public String form() {
        return "member/memberForm";
    }
    
    // 아이디가 존재하면 fail, 존재하지 않으면 success 를 json 형태로 반환
    @PostMapping("/checkId")
    @ResponseBody
    public Map<String, String> checkId(@RequestParam String id) {
        return Map.of("result", memberService.checkId(id) ? "fail" : "success");
    }
    
    @PostMapping("/insert")
    public String insertMember(HttpServletRequest request, @ModelAttribute Member member,
                               @RequestParam("upload") MultipartFile file) {
        
        // 파일 업로드
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        String fileName = file.getOriginalFilename();

        // 이미지가 기본 이미지인 경우 null로 설정 후 파일 업로드 X
        if (!fileName.isEmpty()) {
//            String ext = fileName.split("\\.")[1];
//            String uploadFile = UUID.randomUUID() + "." + ext;
//            try {
//                file.transferTo(new File(uploadPath + "/" + uploadFile));
//            } catch (IOException | IllegalStateException e) {
//                throw new RuntimeException(e);
//            }
            
            // 네이버 스토리지에 사진 저장 / 사진 업로드 후 파일명 반환
            String uploadFile = storageService.uploadFile(bucketName, "member", file);
            // 이미지 파일명을 member 객체에 저장
            member.setImage(uploadFile);
        }
        
        // 회원 정보 저장
        memberService.insertMember(member);
        return "redirect:../"; // 나중에 수정 일단 루트로
    }
}
