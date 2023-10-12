package com.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet",urlPatterns = "/PurchaseServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        if (id==null){
            String url="ListCakeServlet";
            response.sendRedirect(url);
            return;
        }
        Cake cake=CakeDB.getCake(id);
        HttpSession session=request.getSession();
        List<Cake> cart=(List)session.getAttribute("cart");
        if (cart==null){
            cart=new ArrayList<Cake>();
            session.setAttribute("cart",cart);
        }
        cart.add(cake);
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/Servlet");
        response.addCookie(cookie);
        String url="CartServlet";
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}


//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "BuyServlet", value = "/buy")
//public class BuyServlet extends HttpServlet {
//    private static final long serialVersionUID=1L;
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String id=request.getParameter("id");//根据id获取蛋糕
//    if(id==null){
//        String url="list";
//        response.sendRedirect(url);
//        return;
//    }
//    Cake cake=CakeDB.getCake("id");
//    //获取购物车
//    HttpSession session=request.getSession();
//    List<Cake>cart=(List)session.getAttribute("cart");//购物车
//    if(cart==null){
//        cart=new ArrayList<Cake>();
//        session.setAttribute("cart",cart);
//    }
//        //将蛋糕加入购物车
//        cart.add(cake);
//        Cookie cookie=new Cookie("JSESSIONID", session.getId());
//        cookie.setMaxAge(60*30);
//        //cookie.setPath("/Servlet");
//        String url="cartServlet";
//        response.sendRedirect(url);
//    }
//
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//}
