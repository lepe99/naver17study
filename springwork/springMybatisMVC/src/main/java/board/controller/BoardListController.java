package board.controller;

import data.domain.Board;
import data.service.BoardCommentService;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor // 생성자를 통한 의존성 주입
public class BoardListController {
    final BoardService boardService;
    final BoardFileService boardFileService;
    final MemberService memberService;
    final BoardCommentService boardCommentService;
    
    @GetMapping("/board/list")
    public String boardList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
        // 페이징 처리
        int pageSize = 3; // 페이지 당 글의 개수
        int perBlock = 3; // 한 블록 당 출력 할 페이지 수
        int totalCount = boardService.getTotalCount(); // 전체 글의 개수
        
        int totalPage = (int) Math.ceil((double) totalCount / pageSize); // 전체 페이지 수 / 올림 처리
        int startNum = (pageNum - 1) * pageSize; // 각 페이지에서 가져올 글의 시작 번호
        int startPage = ((pageNum - 1) / perBlock) * perBlock + 1; // 시작 페이지
        int endPage = startPage + perBlock - 1; // 끝 페이지
        int no = totalCount - (pageNum - 1) * pageSize; // 각 페이지에서 출력할 시작 번호 (글 번호 역순)
        
        
        // 끝 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
        if (endPage > totalPage) endPage = totalPage;
        
        
        // limit에 맞는 값 넣어 list 가져오기
        List<Board> list = boardService.selectPaginatedBoards(startNum, pageSize);
        
        // 각 dto에 사진 갯수, 댓글 개수 저장
        for (Board board : list) {
            int imageCount = boardFileService.selectBoardFilesByIdx(board.getIdx()).size();
            int commentCount = boardCommentService.selectBoardCommentCount(board.getIdx());
            board.setImageCount(imageCount);
            board.setCommentCount(commentCount);
        }
        
        // 글이 1개만 있는 마지막 페이지에서 글을 삭제했을 때 이전 페이지로 이동
        if (list.isEmpty() && pageNum > 1) {
            return "redirect:./list?pageNum=" + (pageNum - 1);
        }
        
        
        // 페이징 처리에 필요한 값들을 model에 담아서 전달
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("boardList", list);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("no", no);

        return "board/boardList";
    }
}
