package com.whoami.service.Impl;

import com.whoami.dao.EmpManagerDao;
import com.whoami.dao.Impl.EmpManagerDaoImpl;
import com.whoami.entity.EmpManager;
import com.whoami.service.EmpManagerService;
import com.whoami.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager =null;
        try {
            DbUtils.begin();
            EmpManager temp = empManagerDao.select(username);
            if(temp!=null){
                if(temp.getPassword().equals(password)){
                    empManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }
}
