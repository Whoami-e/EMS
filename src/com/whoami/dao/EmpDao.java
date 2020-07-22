package com.whoami.dao;

import com.whoami.entity.Emp;
import com.whoami.entity.Page;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll(Page page);
    public long selectCount();
    public int delete(int id);
    public int insert(Emp emp);
    public Emp select(int id);
    public int update(Emp emp);
}
