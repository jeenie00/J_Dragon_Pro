package com.p1k.p1kGram.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청 파라미터 등을 통해 어떤 JSP로 이동할지 결정
        String pageName = request.getParameter("page");

        if ("loginForm".equals(pageName)) {
            // 첫 번째 JSP로 포워딩
            request.getRequestDispatcher("/WEB-INF/views/auth/loginForm.jsp").forward(request, response);
        } else if ("joinForm".equals(pageName)) {
            // 두 번째 JSP로 포워딩
            request.getRequestDispatcher("/WEB-INF/views/auth/joinForm.jsp").forward(request, response);
        } else if ("upload".equals(pageName)) {
        	request.getRequestDispatcher("/WEB-INF/views/image/upload.jsp").forward(request, response);
        } else {
            // 기본 페이지로 이동하거나 예외 처리
            response.sendRedirect("defaultPage.jsp");
        }
    }
}
