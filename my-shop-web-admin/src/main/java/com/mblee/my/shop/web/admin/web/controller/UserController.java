package com.mblee.my.shop.web.admin.web.controller;


import com.mblee.my.shop.commons.dto.BaseResult;
import com.mblee.my.shop.domain.TbUser;
import com.mblee.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String form(){
        return "user_form";
    }

    /**
     * 保存表单提交的用户
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);

        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/list";
        }
        //"失败"
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }

    }
}
