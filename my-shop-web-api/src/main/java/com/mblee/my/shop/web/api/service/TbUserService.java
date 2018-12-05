package com.mblee.my.shop.web.api.service;

import com.mblee.my.shop.domain.TbUser;

/**
 * 会员管理
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author M.B. Lee
 * @version 1.0.0
 * @date 12/3 12:29
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
