package com.mblee.my.shop.web.admin.service.test;


import com.mblee.my.shop.domain.TbUser;
import com.mblee.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {


    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("one");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("1234".getBytes()));
        tbUser.setPhone("135343543");
        tbUser.setEmail("1234@qq.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete(){
        tbUserService.deleteById(38L);
    }

    @Test
    public void testGetById(){
        TbUser tbUser = tbUserService.getById(40L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testMD5(){
        DigestUtils.md5DigestAsHex("".getBytes());
    }

    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.getById(40L);
        tbUser.setPhone("867876");
        tbUser.setEmail("6786786@qq.com");
        tbUserService.update(tbUser);
    }
    
    @Test
    public void testLogin1(){
        TbUser tbUser = tbUserService.login("1234@qq.com","1234");
        System.out.println(tbUser.getUsername());
    }


/*    @Test
    public void testLogin(){
        TbUser tbUser = tbUserDao.getByEmail("asdasd@qq.com");
        System.out.println(tbUser.getUsername());
    }*/

}













