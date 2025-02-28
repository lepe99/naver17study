package data.service;

import data.domain.Comment;
import data.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    
    public void insertComment(Comment comment) {
        commentRepository.insertComment(comment);
    }
    
    public void deleteComment(int idx) {
        commentRepository.deleteComment(idx);
    }
    
    public List<Comment> getComment(int num) {
        return commentRepository.getComment(num);
    }
    
    public void updateLike(int idx, int likes) {
        Map<String, Integer> map = Map.of("idx", idx, "likes", likes);
        commentRepository.updateLike(map);
    }
}
