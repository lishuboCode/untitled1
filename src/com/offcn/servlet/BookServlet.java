package com.offcn.servlet;

import com.alibaba.fastjson.JSON;
import com.offcn.bean.Book;
import com.offcn.service.BookService;
import com.offcn.utils.ResultVo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/book")
public class BookServlet extends BaseServlet {
    private BookService bs = new BookService();
    private ResultVo vo =null;
    //查询所有图书
    public void findAllBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Book> list = bs.findAllBook();
        //将查询结果封装到resultvo结果对象中
        vo = new ResultVo(200,"查询成功",list);
        //将vo结果转换成json
        String json = JSON.toJSONString(vo);
        //响应给前端
        resp.getWriter().print(json);
    }

    //添加图书
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取前端页面发送来数据
        Map<String, String[]> map = req.getParameterMap();
        Book book = new Book();
        //使用BeanUtils工具将map集合封装到book对象中
        BeanUtils.populate(book,map);
        //调用service层的添加方法
        int i = bs.addBook(book);
        //判断
        if(i>0){
            vo = new ResultVo(200,"图书添加成功",i);
        }else{
            vo = new ResultVo(500,"图书添加失败",i);
        }
        //vo->json
        String str = JSON.toJSONString(vo);
        resp.getWriter().print(str);
    }

    //根据编号查询
    public void findBookByBid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取图书编号
        String bid = req.getParameter("bid");
        //调用底层查询方法
        Book book = bs.findBookByBid(Integer.parseInt(bid));
        //将book保存到vo对象
        vo = new ResultVo(200,"查询成功",book);
        //转json
        String str = JSON.toJSONString(vo);
        resp.getWriter().print(str);
    }

    //修改图书信息
    public void updateBook(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取前端页面发送来数据
        Map<String, String[]> map = req.getParameterMap();
        Book book = new Book();
        //使用BeanUtils工具将map集合封装到book对象中
        BeanUtils.populate(book,map);
        //调用service层的添加方法
        int i = bs.updateBook(book);
        //判断
        if(i>0){
            vo = new ResultVo(200,"图书修改成功",i);
        }else{
            vo = new ResultVo(500,"图书修改失败",i);
        }
        //vo->json
        String str = JSON.toJSONString(vo);
        resp.getWriter().print(str);
    }
    //根据编号删除图书
    public void delBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bid = req.getParameter("bid");
        //调用service层的删除方法
        int i = bs.delBook(Integer.parseInt(bid));
        //判断
        if(i>0){
            vo = new ResultVo(200,"图书删除成功",i);
        }else{
            vo = new ResultVo(500,"图书删除失败",i);
        }
        //vo->json
        String str = JSON.toJSONString(vo);
        resp.getWriter().print(str);
    }
}
