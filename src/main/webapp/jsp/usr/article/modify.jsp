<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.article.article.dto.ArticleDto" %>
<%
ArticleDto article = (ArticleDto)request.getAttribute("article");
%>
<h1>게시물 수정</h1>


<script>
    function ArticleForm__checkIsEmpty(form){
        form.title.value = form.title.value.trim();
        if(form.title.value.length == 0){
            alert("제목을 입력해주세요");
            form.title.focus();
            return;
        }

        form.body.value = form.body.value.trim();
        if(form.body.value.length == 0){
            alert("내용을 입력해주세요");
            form.body.focus();
            return;
        }

        form.submit();
    }
</script>
<form method="POST" onsubmit="ArticleForm__checkIsEmpty(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" value="<%=article.getTitle()%>" />
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="300" value="<%=article.getBody()%>" />
        </div>
    </div>

    <div>
        <span>수정</span>
        <div>
            <input type="submit" value="수정" />
        </div>
    </div>
</form>