package shop.controller;

import data.domain.Comment;
import data.service.CommentService;
import data.service.NcpObjectStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    NcpObjectStorageService storageService;
    
    // 버킷 이름
    private final String bucketName = "bitcamp-bucket-120";
    
    
    @PostMapping("/shop/addComment")
    public String addComment(HttpServletRequest request, @RequestParam int num, @RequestParam String message,
                           @RequestParam(value = "file", required = false) MultipartFile file) {
        
        String uploadFile = null;
        if (file != null) {
//            String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//            String ext = file.getOriginalFilename().split("\\.")[1];
//            uploadFile = UUID.randomUUID() + ext;
//
//            try {
//                file.transferTo(new File(uploadPath + "/" + uploadFile));
//            } catch (IOException | IllegalStateException e) {
//                throw new RuntimeException(e);
//            }
            
            // 네이버 스토리지에 사진 저장 / 사진 업로드 후 파일명 반환
            uploadFile = storageService.uploadFile(bucketName, "comment", file);
        }
        // dto 담기
        Comment comment = new Comment();
        comment.setNum(num);
        comment.setMessage(message);
        comment.setImage(uploadFile);
        
        // db insert
        commentService.insertComment(comment);
        
        return "success";
    }
    
    @PostMapping("/shop/commentList")
    public List<Comment> commentList(@RequestParam int num) {
        List<Comment> commentList = new ArrayList<>();
        commentList = commentService.getComment(num);
        return  commentList;
    }
    
    @PostMapping("/shop/deleteComment")
    public String deleteComment(HttpServletRequest request, @RequestParam int idx, @RequestParam String image) {
        commentService.deleteComment(idx);
        
        // 파일 삭제
        if (image != null) {
//            String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//            File file = new File(uploadPath + "/" + image);
//            if (file.exists()) file.delete();
            
            // 네이버 스토리지에 저장된 사진 삭제
            storageService.deleteFile(bucketName, "comment", image);
        }
        return "success";
    }
    
    @PostMapping("/shop/updateLike")
    public String updateLike(@RequestParam int idx, @RequestParam int likes) {
        commentService.updateLike(idx, likes);
        return "success";
    }
}
