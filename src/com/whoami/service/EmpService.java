package com.whoami.service;

import com.whoami.entity.Emp;
import com.whoami.entity.Page;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmpByPage(Page page);
    public int deleteEmp(int id);
    public int addEmp(Emp emp);
    public Emp selectEmpById(int id);
    public int modifyEmp(Emp emp);
}
