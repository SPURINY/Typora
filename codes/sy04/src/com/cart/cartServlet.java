package com.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class cartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        List<Cake> cart=null;
        boolean pruFlag=true;
        HttpSession session=request.getSession(false);
        if (session==null){
            pruFlag=false;
        }else {
            cart =(List)session.getAttribute("cart");
            if (cart==null){
                pruFlag=false;
            }
        }
        if (!pruFlag){
            out.write("对不起！您还没有购买任何产品");
        }
        else {
            out.write("您购买的蛋糕有：<br>");
            double price=0;
            for (Cake cake:cart){
                out.write(cake.getName()+"<br>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}


//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet(name = "cartServlet", value = "/cartServlet")
//public class cartServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out=response.getWriter();
//        List<Cake>cart=null;
//        boolean flag=true;
//        HttpSession session= request.getSession(false);
//        if(session==null){
//            flag=false;
//        }else{
//            cart=(List)session.getAttribute("cart");
//            if(cart==null){
//                flag=false;
//            }
//        }
//        if(!flag){
//            out.write("还未购买任何商品");
//        }else{
//            out.write("已购买的cake有："+"<br/>");
//            for(Cake cake:cart){
//                out.write(cake.getName()+"<br/>");
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//}
