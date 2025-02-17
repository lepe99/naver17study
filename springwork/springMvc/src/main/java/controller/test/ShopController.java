package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {
    
//    @GetMapping({"/shop/addForm", "/shop/updateForm"})
//    public String form(Model model) {
//        model.addAttribute("message", "데이터 추가 또는 수정 폼 작성");
//        return "result1";
//    }
    
    // url 경로를 읽어오는 방법
    @GetMapping("/a/shop/{form}")
    public String shopForm(@PathVariable("form") String form, Model model) {
        // @PathVariable("form") String form: 경로에서 읽어온 값을 form에 저장
        // 괄호 속 form은 생략 가능 (단, 변수명과 경로명이 다를 경우에는 꼭 써야 함)
        String message;
        if (form.equals("addForm")) {
            message = "상품 추가 폼 작성";
            model.addAttribute("photo", "11.png");
        }
        else {
            message = "상품 수정 폼 작성";
            model.addAttribute("photo", "03.png");
        }

        model.addAttribute("message", message);
        return "result1";
    }
    
    @GetMapping("/b/{path1}/{path2}")
    public String hello2(@PathVariable String path1, @PathVariable String path2, Model model) {
        // 변수명과 경로명이 같을 경우 생략 가능
        String message = "", photo = "";
        if (path1.equals("shop")) {
            if (path2.equals("list")) {
                message = "전체 상품에 대한 목록 출력";
                photo = "07.png";
            } else {
                message = "장바구니 목록 출력";
                photo = "12.png";
            }
        } else {
            if (path2.equals("list")) {
                message = "게시판 목록 출력";
                photo = "04.png";
            }
        }
        model.addAttribute("message", message);
        model.addAttribute("photo", photo);
        
        return "result2";
    }
}
