package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文乱码问题
        /*req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");*/
        //获取用户需要执行的方法名findAll/insert/update
        String method = req.getParameter("method");
        //分发（根据用户的需求，调用不同类中的不同方法）
        //获取操作哪个类，获取类字节码对象
        Class<? extends BaseServlet> clazz = this.getClass();
        try {
            //根据方法名，方法所需要的参数类型的字节码对象获取执行的方法对象
            Method mh = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            mh.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
