package com.offcn.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    private QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
    //增删改方法
    public int update(String sql,Object...pramas){
        int row = 0;
        try {
            row = runner.update(sql,pramas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    //查询单条记录
    public T queryOne(String sql, Class clazz, Object...pramas){
        try {
            return  runner.query(sql,new BeanHandler<T>(clazz),pramas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    //查询多条记录
    public List<T> queryMany(String sql, Class clazz, Object...pramas){
        try {
            return  runner.query(sql,new BeanListHandler<T>(clazz),pramas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    //查询单行单列
    public Object queryScalar(String sql,Object...pramas){
        try {
            return runner.query(sql,new ScalarHandler<>(),pramas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
