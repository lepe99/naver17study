package bitcamp.study;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@AllArgsConstructor // 생성자를 통한 DI / MyCar 객체를 주입받는 생성자를 자동으로 생성 (#2)
public class OneController {
    
//    @Autowired // 스프링 컨테이너에 등록된 객체 중에서 타입이 일치하는 객체를 주입 (DI) (#1)
    MyCar myCar;
    
    // AllArgsConstructor를 통해 만들어지는 생성자
//    public OneController(MyCar myCar) {
//        this.myCar = myCar; // @Component로 등록된 MyCar 객체를 주입받음 (#3)
//    }
    
    @GetMapping("/")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        // model에 데이터 저장 (서블릿에서 request에 저장하는 것과 같음)
        mv.addObject("today", new Date());
        mv.addObject("message", "안녕하세요");
        
        // forward 할 jsp 파일명 지정
        mv.setViewName("result1"); // /WEB-INF/views/result1.jsp, 설정해둔 viewResolver가 앞뒤 경로를 붙여줌
        return mv;
    }
    
    @GetMapping({"/board/list", "/board/list.do"}) // 여러 개의 URL을 매핑할 때 중괄호 사용
    public String list1(Model model) { // Model 객체를 파라미터로 받아서 데이터를 저장
        model.addAttribute("writer", "한가람");
        return "boardList"; // /WEB-INF/views/boardList.jsp 이동 (정적)
    }
    
    @GetMapping("/shop/list")
    public String list2(Model model) {
        model.addAttribute("name", "사과");
        model.addAttribute("price", 3000);
        return "shopList";
    }
    
    @GetMapping({"/bitcamp/study", "/bitcamp/study2"})
    public String list3(Model model) {
        model.addAttribute("myCar", myCar.getMyCarName());
        model.addAttribute("myCarColor", myCar.getMyCarColor());
        return "study";
    }
}
