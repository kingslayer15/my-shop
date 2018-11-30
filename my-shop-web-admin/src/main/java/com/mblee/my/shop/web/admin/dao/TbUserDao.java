package com.mblee.my.shop.web.admin.dao;

import com.mblee.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TbUserDao {

    public List<TbUser> selectAll();


    public void insert(TbUser tbUser);


    public void delete(long id);


    public TbUser getById(long id);


    public void update(TbUser tbUser);


    public TbUser selectByUsername(String username);


    public TbUser getByEmail(String email);
}

