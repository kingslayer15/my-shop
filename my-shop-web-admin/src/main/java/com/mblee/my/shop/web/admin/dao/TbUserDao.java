package com.mblee.my.shop.web.admin.dao;

import com.mblee.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TbUserDao {

     List<TbUser> selectAll();


     void insert(TbUser tbUser);


     void delete(Long id);


     TbUser getById(Long id);


     void update(TbUser tbUser);


     TbUser selectByUsername(String username);


    TbUser getByEmail(String email);

    List<TbUser> search(TbUser tbUser);
}

