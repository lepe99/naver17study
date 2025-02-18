package controller.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.FilenameChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UploadPracticeController {
    
    @GetMapping("/practice1")
    public String practice1() {
        return "uploadPractice/practice1";
    }
    
    @PostMapping("/practice1Process")
    @ResponseBody
    public Map<String, String> practice1Process(HttpServletRequest request, @RequestParam String title,
                                                @RequestParam("photo") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        
        // 업로드 위치
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        // 파일 이름
        String uploadFile = FilenameChange.addRandomToFilename(file.getOriginalFilename());
        // 업로드
        try {
            file.transferTo(new java.io.File(uploadPath + "/" + uploadFile));
        } catch (java.io.IOException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
        
        // 파일 이름, 제목을 map에 저장
        map.put("title", title);
        map.put("photo", uploadFile);
        
        return map;
    }
    
    
    @GetMapping("/practice2")
    public String practice2() {
        return "uploadPractice/practice2";
    }
    
    @PostMapping("/practice2Process")
    public String practice2Process(Model model, HttpServletRequest request, @RequestParam String title,
                                   @RequestParam("photo")List<MultipartFile> files) {
        // 업로드 위치
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        
        // 파일명 리스트
        List<String> uploadFiles = new ArrayList<>();
        
        // 파일 업로드
        for (MultipartFile file : files) {
            // 파일 이름
            String uploadFile = FilenameChange.addRandomToFilename(file.getOriginalFilename());
            // 업로드
            try {
                file.transferTo(new java.io.File(uploadPath + "/" + uploadFile));
            } catch (java.io.IOException | IllegalStateException e) {
                throw new RuntimeException(e);
            }
            
            // 파일명 리스트에 추가
            uploadFiles.add(uploadFile);
        }
        
        // 모델에 제목, 파일명 리스트 저장
        model.addAttribute("title", title);
        model.addAttribute("photos", uploadFiles);
        
        return "uploadPractice/practice2Result";
    }

}
