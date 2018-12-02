package com.mblee.my.shop.web.admin.service;

import com.mblee.my.shop.commons.dto.BaseResult;
import com.mblee.my.shop.domain.TbUser;
import org.springframework.stereotype.Service;


import java.util.List;


public interface TbUserService {
    List<TbUser> selectAll();

    BaseResult save(TbUser tbUser);

    void deleteById(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    TbUser selectByUsername(String username);

    TbUser login(String email, String password);

    List<TbUser> search(TbUser tbUser);
}
