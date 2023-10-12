package com.logPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet", value = "/loginServ")
public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.write(123);
        if("root".equals(name)&&"123".equals(password)){
            User user=new User();
            user.setPassword(password);
            user.setUseranme(name);
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("index");
        }else{
            writer.write("密码或用户名错误");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);//如果漏写：单独访问显示，但是表单提交后显示空白网页
    }
}
