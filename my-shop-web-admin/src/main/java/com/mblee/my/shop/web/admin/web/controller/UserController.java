package com.mblee.my.shop.web.admin.web.controller;


import com.mblee.my.shop.commons.dto.BaseResult;
import com.mblee.my.shop.domain.TbUser;
import com.mblee.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping(value = "user")
@Controller
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转到用户列表
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /**
     * 跳转到用户表单页
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model){
        TbUser tbUser = new TbUser();
        model.addAttribute("tbUser",tbUser);
        return "user_form";
    }

    /**
     * 保存用户信息
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);

        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //"失败"
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    @ModelAttribute
    public TbUser getTbUser(Long id){
        System.out.println(id);

        TbUser tbUser = null;

        System.out.println("getTbUser");

        if (id != null){
            System.out.println(id + "2");
            tbUser = tbUserService.getById(id);
            System.out.println(id + "3");
        }

        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 搜索
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model){
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }
}
