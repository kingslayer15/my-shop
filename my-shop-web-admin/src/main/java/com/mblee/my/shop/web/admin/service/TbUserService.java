package com.mblee.my.shop.web.admin.service;

import com.mblee.my.shop.commons.persistence.BaseService;
import com.mblee.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
