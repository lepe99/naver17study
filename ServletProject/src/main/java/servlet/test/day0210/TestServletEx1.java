package servlet.test.day0210;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/bit/hello.do")
public class TestServletEx1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //request 에 각종 데이터 저장하기
        request.setAttribute("today", new Date());
        request.setAttribute("myName", "이영자");
        request.setAttribute("myAge", 32);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        request.setAttribute("today2", sdf.format(new Date()));
        
        //jsp 파일로 포워드
        //포워드:request 가 그대로 전달, url주소 안 바뀜
        RequestDispatcher rd = request.getRequestDispatcher("../jstlTest/result1.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}