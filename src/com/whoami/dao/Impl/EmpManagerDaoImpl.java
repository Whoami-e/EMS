package com.whoami.dao.Impl;

import com.whoami.dao.EmpManagerDao;
import com.whoami.entity.EmpManager;
import com.whoami.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner runner = new QueryRunner();
    @Override
    public EmpManager select(String username) {
        try {
            EmpManager empManager = runner.query(DbUtils.getConnection(),"select * from empmanager where username =? ;",new BeanHandler<EmpManager>(EmpManager.class),username);
            return empManager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
