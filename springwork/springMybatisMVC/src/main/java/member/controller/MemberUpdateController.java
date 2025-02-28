package member.controller;

import data.domain.Member;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberUpdateController {
    
    @Autowired
    MemberService memberService;
    
    @PostMapping("/member/updateMember")
    public String updateMember(@ModelAttribute Member member) {
        // 비밀번호 공란이면 기존 비밀번호로
        if (member.getPasswd().isEmpty()) {
            member.setPasswd(memberService.getMemberByNum(member.getNum()).getPasswd());
        }
        
        memberService.updateMember(member);
        
        return "success";
    }
}
