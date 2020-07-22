package com.whoami.dao;

import com.whoami.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
