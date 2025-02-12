package shop.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;

@WebServlet("/shop/update")
public class UpdateProcessServlet extends HttpServlet {
    ShopDao dao = new ShopDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopDto dto = new ShopDto();
        
        int num = Integer.parseInt(request.getParameter("num"));
        dto.setNum(num);
        dto.setPrdtName(request.getParameter("prdtName"));
        dto.setPrdtColor(request.getParameter("prdtColor"));
        dto.setPrdtImage(request.getParameter("prdtImage"));
        dto.setPrdtDateIn(request.getParameter("prdtDateIn"));
        dto.setPrdtCnt(Integer.parseInt(request.getParameter("prdtCnt")));
        dto.setPrdtPrice(Integer.parseInt(request.getParameter("prdtPrice")));
        
        dao.updateShop(dto);
        
        // 수정 후 상세페이지 이동 - detail 서블릿 호출
        response.sendRedirect("./detail?num=" + num);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}