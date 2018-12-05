package com.mblee.my.shop.web.ui.api;

import com.mblee.my.shop.commons.utils.HttpClientUtils;
import com.mblee.my.shop.commons.utils.MapperUtils;
import com.mblee.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 * <p>Title: UsersApi</p>
 * <p>Description: </p>
 *
 * @author M.B. Lee
 * @version 1.0.0
 * @date 12/3 12:39
 */
public class UsersApi {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}
