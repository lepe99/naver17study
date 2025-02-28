package member.controller;


import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    
    @Autowired
    MemberService memberService;
    
    @PostMapping("/member/login")
    public Map<String, String> login(HttpSession session, @RequestParam String id, @RequestParam String passwd) {
        boolean isLogin = memberService.loginCheck(id, passwd);
        System.out.println(isLogin);
        if (isLogin) {
            session.setMaxInactiveInterval(60 * 60 * 4); // 세션 4시간 유지
            session.setAttribute("loginOk", "Success");
            session.setAttribute("loginId", id);
            
            // 프사 얻기 (id로)
            String image = memberService.getMemberById(id).getImage();
            session.setAttribute("loginImage", image);
        }
        
        Map<String, String> map = Map.of("result", isLogin ? "success" : "fail");
        
        return map;
    }
    
    @PostMapping("member/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
