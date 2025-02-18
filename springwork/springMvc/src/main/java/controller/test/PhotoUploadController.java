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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PhotoUploadController {
    
    @GetMapping("/uploadForm")
    public String upload() {
        return "upload/uploadForm";
    }
    
    @PostMapping("/uploadProcess")
    public String uploadPhoto(Model model, HttpServletRequest request, @RequestParam String title,
                              @RequestParam("upload") MultipartFile file) {
        // HttpServletRequest request: 클라이언트의 요청을 받아오는 객체
        // @RequestParam String title: 파라미터로 전달된 값을 title에 저장
        // @RequestParam("upload")MultipartFile file: 파라미터로 전달된 파일을 file에 저장, 파라미터명 생략하지 말기
        // MultipartFile: 파일 업로드를 위한 객체
        
        // 업로드 할 위치 지정 (webapp/save)
        String uploadPath = request.getSession().getServletContext().getRealPath("/save"); // 업로드할 위치
        
        // 업로드할 파일명
        // 원래 피일명으로 저장하면 같은 이름의 파일 업로드시 덮어 써지는 문제 발생
//        String uploadFile = file.getOriginalFilename(); // 기존 파일명
        // 파일명에 현재시간을 추가하여 중복 방지
//        String uploadFile = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // 양식 : 파일명_업로드시간.확장자
        String fileName = file.getOriginalFilename().split("\\.")[0];
        String fileExt = file.getOriginalFilename().split("\\.")[1];
        String uploadFile = fileName + "_" + sdf.format(new Date()) + "." + fileExt;
        
        // 파일 업로드
        try {
            file.transferTo(new File(uploadPath + "/" + uploadFile));
        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
        
        model.addAttribute("title", title);
        model.addAttribute("photo", uploadFile);
        
        return "upload/uploadResult";
    }
    
    // 파일 여러개 업로드
    @GetMapping("/multiForm")
    public String multi() {
        return "upload/uploadFormMulti";
    }
    
    @PostMapping("/multiProcess")
    public String multiUpload(Model model, HttpServletRequest request, @RequestParam String title,
                                @RequestParam("upload") List<MultipartFile> files) {
        // 모델에 제목 저장
        model.addAttribute("title", title);
        
        // 업로드할 위치 지정
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        
        // 업로드된 파일명 저장할 리스트
        List<String> list = new ArrayList<>();
        
        // 여러 파일 업로드, 파일명 날짜 붙이기
        for (MultipartFile file : files) {
            // 파일명 변경
//            String uploadFile = FilenameChange.addDateToFilename(file.getOriginalFilename());
            String uploadFile = FilenameChange.addRandomToFilename(file.getOriginalFilename());
            // 파일 업로드
            try {
                file.transferTo(new File(uploadPath + "/" + uploadFile));
            } catch (IOException | IllegalStateException e) {
                throw new RuntimeException(e);
            }
            
            // 파일명 리스트에 추가
            list.add(uploadFile);
        }
        
        // 모델에 파일명 리스트 저장
        model.addAttribute("list", list);
        
        return "upload/uploadResultMulti";
    }
    
    
    // ajax 파일 업로드
    @GetMapping("/ajaxUpload")
    public String ajaxForm() {
        return "upload/ajaxPhotoUpload";
    }
    
    // 사진 업로드 후 json 형식으로 응답
    // ajax 함수 통해 호출
    @PostMapping("/ajaxProcess")
    @ResponseBody // json 형식으로 응답 위해
    public Map<String, String> photoUpload(HttpServletRequest request, @RequestParam("upload") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        
        // 업로드
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        String uploadFile = FilenameChange.addRandomToFilename(file.getOriginalFilename());
        try {
            file.transferTo(new File(uploadPath + "/" + uploadFile));
        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
        
        // 파일 업로드 성공시 파일명을 json 형식으로 응답
        map.put("photo", uploadFile);
        
        return map;
    }
    
    
    // ajax 파일 여러개 업로드
    @GetMapping("/ajaxMultiUpload")
    public String ajaxMultiForm() {
        return "upload/ajaxMultiPhotoUpload";
    }
    
    @PostMapping("/ajaxMultiProcess")
    @ResponseBody // json 형식으로 응답 위해
    public List<Map<String, String>> multiPhotoUpload(HttpServletRequest request,
                                                      @RequestParam("upload") List<MultipartFile> files) {
        List<Map<String, String>> list = new ArrayList<>();
        // 맵 안쓰고 List<String>로 해도 됨
        
        // 업로드
        for (MultipartFile f : files) {
            Map<String, String> map = new HashMap<>();
            String uploadPath = request.getSession().getServletContext().getRealPath("/save");
            String uploadFile = FilenameChange.addRandomToFilename(f.getOriginalFilename());
            try {
                f.transferTo(new File(uploadPath + "/" + uploadFile));
            } catch (IOException | IllegalStateException e) {
                throw new RuntimeException(e);
            }
            
            map.put("photo", uploadFile);
            list.add(map);
        }
        
        return list;
    }
}
