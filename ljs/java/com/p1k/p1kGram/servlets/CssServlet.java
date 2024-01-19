package com.p1k.p1kGram.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cssServlet")
public class CssServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // CSS 파일 읽어오기
        InputStream cssStream = getServletContext().getResourceAsStream("/css/style.css");
        BufferedReader cssReader = new BufferedReader(new InputStreamReader(cssStream));
        StringBuilder cssContent = new StringBuilder();
        String cssLine;
        while ((cssLine = cssReader.readLine()) != null) {
            cssContent.append(cssLine);
        }

        // JSP로 CSS 내용 전달
        request.setAttribute("cssContent", cssContent.toString());

        // JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/auth/loginForm.jsp").forward(request, response);
    }
}
