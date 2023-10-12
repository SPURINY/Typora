package com.logPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    HttpSession session=request.getSession();
    User user=(User)session.getAttribute("user");
    if(user==null){
        response.getWriter().write("还未登录");
        response.getWriter().write("<a href='login.html'>登录</a>");
    }else{
        String name=user.getUseranme();
        //String password=user.getPassword();
        response.getWriter().write("登陆成功，"+name+"欢迎使用本站");
        response.getWriter().write("<a href='LogOutServlet'>退出登录</a>");

        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(30*60);
        cookie.setPath("/sy04");
        response.addCookie(cookie);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
