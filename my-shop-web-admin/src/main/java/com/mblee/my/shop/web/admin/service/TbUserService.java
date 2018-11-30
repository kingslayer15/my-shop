package com.mblee.my.shop.web.admin.service;

import com.mblee.my.shop.commons.dto.BaseResult;
import com.mblee.my.shop.domain.TbUser;
import org.springframework.stereotype.Service;


import java.util.List;


public interface TbUserService {
    public List<TbUser> selectAll();

    public BaseResult save(TbUser tbUser);

    public void deleteById(Long id);

    public TbUser getById(Long id);

    public void update(TbUser tbUser);

    public TbUser selectByUsername(String username);

    public TbUser login(String email, String password);
}
