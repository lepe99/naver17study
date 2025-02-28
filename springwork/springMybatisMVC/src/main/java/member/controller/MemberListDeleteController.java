package member.controller;

import data.domain.Member;
import data.service.MemberService;
import data.service.NcpObjectStorageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberListDeleteController {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    @GetMapping("/memberList")
    public String memberList() {
        return "member/memberList";
    }
    
    @PostMapping("/getAllMembers")
    @ResponseBody
    public List<Map<String, Object>> getAllMembers(Model model) {
        List<Member> members = memberService.getAllMembers();
        List<Map<String, Object>> list = new ArrayList<>();
        
        Map<String, Object> urlMap = new HashMap<>();
        // image optimizer url
        urlMap.put("frontUrl", "https://ymf0kmgk8726.edge.naverncp.com/hNwdEsMHVP");
        urlMap.put("backUrl", "?type=f&w=30&h=30&faceopt=true&ttype=jpg");
        list.add(urlMap);
        for (Member m : members) {
            Map<String, Object> map = new HashMap<>();
            map.put("num", m.getNum());
            map.put("name", m.getName());
            map.put("passwd", m.getPasswd());
            map.put("id", m.getId());
            map.put("hp", m.getHp());
            map.put("address", m.getAddress());
            map.put("image", m.getImage());
            map.put("regDate", m.getRegDate());
            list.add(map);
        }
        
        return list;
    }
    
    @PostMapping("/deleteMember")
    @ResponseBody
    public Map<String, String> deleteMember(HttpServletRequest request, @RequestParam int num) {
        
        // 이미지 지우기
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        Member member = memberService.getMemberByNum(num);
        String image = member.getImage();
        if (image != null) {
//            File file = new File(uploadPath + "/" + image);
//            if (file.exists()) file.delete();
            
            // 네이버 스토리지에 저장된 사진 삭제
            storageService.deleteFile(bucketName, "member", image);
        }
        
        memberService.deleteMember(num);
        
        return Map.of("result", "success");
    }
    
    @PostMapping("/deleteMembers")
    @ResponseBody
    public Map<String, String> deleteMembers(HttpServletRequest request, @RequestParam List<Integer> nums) {
        // 이미지 지우기
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        for (int num : nums) {
            Member member = memberService.getMemberByNum(num);
            String image = member.getImage();
            if (image != null) {
//                File file = new File(uploadPath + "/" + image);
//                if (file.exists()) file.delete();
                
                // 네이버 스토리지에 저장된 사진 삭제
                storageService.deleteFile(bucketName, "member", image);
            }
        }
        
        memberService.deleteMembers(nums);
        
        return Map.of("result", "success");
    }
    
    @PostMapping("/memberPageDelete")
    @ResponseBody
    public void memberPageDelete(@RequestParam int num, HttpSession session) {
        memberService.deleteMember(num);
        
        // 네이버 스토리지에 저장된 사진 삭제
        String image = memberService.getMemberByNum(num).getImage();
        if (image != null) {
            storageService.deleteFile(bucketName, "member", image);
        }
        
        // 세션 제거
        session.removeAttribute("loginId");
        session.removeAttribute("loginImage");
        session.removeAttribute("loginOk");
        
    }
}
