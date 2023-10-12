package com.loginLogout;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Afilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;//强转
        HttpSession session = request.getSession();
        String user=(String) session.getAttribute("user");
        System.out.println("Afilter被调用");
        if(user==null){//没登陆
            //不放行
            response.sendRedirect(request.getContextPath()+"/inOutIndex.jsp");//没登陆不能乱看会员优质内容，给赶回首页了

        }else{//已登录
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
