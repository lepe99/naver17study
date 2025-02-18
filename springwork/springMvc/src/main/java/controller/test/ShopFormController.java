package controller.test;

import data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ShopFormController {
    
    // redirect
    @GetMapping("/form1")
    public String form1() {
        return "shop/form1";
    }
    
    @GetMapping("/form2")
    public String form2() {
        return "shop/form2";
    }
    
    @GetMapping("/form3")
    public String form3() {
        return "shop/form3";
    }
    
    // forward
    @GetMapping("/process1")
    public String process1(Model model,
//                           @RequestParam("myId") String myId, @RequestParam("myPw") String myPw) {
//                           @RequestParam String myId, @RequestParam String myPw) { // 변수명과 파라미터명이 같을 경우 생략 가능
                           String myId, String myPw, // 변수명과 파라미터명이 같을 경우 @RequestParam 생략 가능 (권장 x)
                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
                            // 특정값이 넘어올 때도 있고 안넘어올 때도 있을 경우 defaultValue 속성 사용 (안 쓰면 null 가능성)
        
        String result = "";
        if (myPw.equals("12345")) result = myId + "님 환영합니다.";
        else result = "비밀번호가 일치하지 않습니다.";
        
        model.addAttribute("result", result);
        return "shop/list1";
    }
    
    @PostMapping("/process2")
//    public String process2(@ModelAttribute ShopDto dto) { // 객체명 shopDto 로 저장
    public String process2(@ModelAttribute("dto") ShopDto dto) { // 객체명 dto 로 저장
        // @ModelAttribute: 폼에서 넘어온 데이터를 dto 객체에 저장, model.addAttribute()를 사용하지 않아도 됨
        return "shop/list2";
    }
    
    @PostMapping("/process3")
    public String process3(Model model, @RequestParam Map<String, String> map) { // Map으로 받아오기
        model.addAttribute("name", map.get("name"));
        model.addAttribute("age", map.get("age"));
        model.addAttribute("addr", map.get("addr"));
        model.addAttribute("gender", map.get("gender"));
        
        return "shop/list3";
    }
}
