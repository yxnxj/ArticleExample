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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        /**
         * getRequestURI 는
         * http://localhost:8081/usr/article/list/free 에서
         * /usr/article/list/free 부분만 가져온다.
         */
        String url = req.getRequestURI();

        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/member/login":
                        memberController.showLogin(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
