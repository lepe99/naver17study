package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HelloController {
    
//    @GetMapping("/") // 방법1
//    public ModelAndView hello1() {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", "하이");
//        mv.setViewName("hello");
//        return mv;
//    }
    
    @GetMapping("/") // 방법2
    public String hello2(Model model) {
        model.addAttribute("message", "헬로");
        model.addAttribute("today", new Date());
        return "hello";
    }
}
