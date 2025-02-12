package reboard.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

@WebServlet("/board/writeForm")
public class BoardFormServlet extends HttpServlet {
    BoardDao dao = new BoardDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // num, regroup, restep, relevel을 읽는데 새 글일 경우 null, 답글일 경우 해당 값들을 읽어온다.
        BoardDto dto = new BoardDto();
        int num, regroup, restep, relevel;
        String subject = ""; // 답글일 경우 원글의 제목을 표사
        
        try {
            // 답글일 경우 num, regroup, restep, relevel을 읽어온다.
            num = Integer.parseInt(request.getParameter("num"));
            regroup = Integer.parseInt(request.getParameter("regroup"));
            restep = Integer.parseInt(request.getParameter("restep"));
            relevel = Integer.parseInt(request.getParameter("relevel"));
            // 원글의 제목 읽어오기
            subject = dao.getData(num).getSubject();
            
        } catch (NumberFormatException e) {
            // 새 글일 경우 num, regroup, restep, relevel을 0으로 초기화한다.
            num = regroup = restep = relevel = 0; // 한 줄에 써도 된다.
        }
        // request 객체에 저장
        request.setAttribute("num", num);
        request.setAttribute("regroup", regroup);
        request.setAttribute("restep", restep);
        request.setAttribute("relevel", relevel);
    
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("./writeForm.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}