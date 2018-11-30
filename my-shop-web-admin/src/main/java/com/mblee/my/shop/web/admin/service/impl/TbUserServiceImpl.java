package com.mblee.my.shop.web.admin.service.impl;

import com.mblee.my.shop.commons.dto.BaseResult;
import com.mblee.my.shop.domain.TbUser;
import com.mblee.my.shop.web.admin.dao.TbUserDao;
import com.mblee.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;




    @Override
    public List<TbUser> selectAll() {

        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save (TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);

        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null){
                //密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }
            baseResult.setMessage("保存成功");
        }
        return baseResult;
    }

    @Override
    public void deleteById(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id){
        TbUser tbUser = tbUserDao.getById(id);

        return tbUser;
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public TbUser selectByUsername(String username){
        TbUser tbUser = tbUserDao.selectByUsername(username);
        return tbUser;
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);

        if (tbUser != null){

            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 用户信息有效性验证
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();

        //非空验证
        if (StringUtils.isBlank(tbUser.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空,请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPassword())){
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPhone())){
            baseResult = BaseResult.fail("手机不能为空,请重新输入");
        }

        return baseResult;

    }
}
