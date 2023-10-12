package com.cart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ListCakeServlet",urlPatterns = "/ListCakeServlet")
public class ListCakeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        Collection<Cake> cakes=CakeDB.getAll();
        out.write("本网站提供的蛋糕有<br>");
        for (Cake cake:cakes){
            String url="PurchaseServlet?id="+cake.getId();
            out.write(cake.getName()+"<a href='"+url+"'>点击购买</a><br>");
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
//import java.util.Collection;
//
//@WebServlet(name = "ListCakeServlet", value = "/list")
//public class ListCakeServlet extends HttpServlet {
//    private static final long serialVersionUID=1L;
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out=response.getWriter();
//        Collection<Cake>cakes=CakeDB.getAll();
//        out.println("可购买的蛋糕有："+"<br/>");
//        for(Cake cake:cakes){
//            String id=cake.getId();
//            String url="<a href='buy?id="+id+"'>点击购买</a><br/>";
//            out.println(cake.getName()+url);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//}
