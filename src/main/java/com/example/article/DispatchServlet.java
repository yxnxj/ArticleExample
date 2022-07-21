package com.example.article;

import com.example.article.article.ArticleController;
import com.example.article.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        /**
         * getRequestURI 는
         * http://localhost:8081/usr/article/list/free 에서
         * /usr/article/list/free 부분만 가져온다.
         */
        String url = req.getRequestURI();

        switch(url){
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;
            case "/usr/member/login":
                memberController.showLogin(rq);
                break;

        }
    }
}
