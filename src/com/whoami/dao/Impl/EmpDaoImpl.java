package com.whoami.dao.Impl;

import com.whoami.dao.EmpDao;
import com.whoami.entity.Emp;
import com.whoami.entity.Page;
import com.whoami.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner runner = new QueryRunner();
    @Override
    public List<Emp> selectAll(Page page) {
        try {
            List<Emp> emps = runner.query(DbUtils.getConnection(),"select * from emp limit ?,?",new BeanListHandler<Emp>(Emp.class),page.getStartRows(),page.getPageSize());
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            long count = runner.query(DbUtils.getConnection(),"select count(*) from emp;",new ScalarHandler<>());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result = runner.update(DbUtils.getConnection(),"delete from emp where id=?",id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(Emp emp) {
        try {
            int result = runner.update(DbUtils.getConnection(),"insert into emp(name,salary,age) values(?,?,?)",emp.getName(),emp.getSalary(),emp.getAge());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            Emp emp = runner.query(DbUtils.getConnection(),"select * from emp where id=?",new BeanHandler<Emp>(Emp.class),id);
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Emp emp) {
        try {
            int result = runner.update(DbUtils.getConnection(),"update emp set name=?,salary=?,age=? where id=?",emp.getName(),emp.getSalary(),emp.getAge(),emp.getId());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
