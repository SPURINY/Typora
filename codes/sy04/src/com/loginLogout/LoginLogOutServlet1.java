package com.loginLogout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//login
@WebServlet(name = "LoginLogOutServlet1", value = "/login1")
public class LoginLogOutServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String psw=request.getParameter("psw");
        if("123".equals(psw)){
            HttpSession session=request.getSession();
            session.setAttribute("user",name);
            response.sendRedirect("inOutIndex.jsp");
        }else{
            response.sendRedirect("inOutIndex.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
