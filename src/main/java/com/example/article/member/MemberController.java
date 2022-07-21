package com.example.article.member;

import com.example.article.Rq;

public class MemberController {
    public void showLogin(Rq rq){
        rq.appendBody("로그인");
    }
}
