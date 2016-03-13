package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wang.sms.dao.AdminDao;
import org.wang.sms.model.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yang Wang on 16/3/6.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  @Autowired
  private AdminDao adminDao;

  @RequestMapping(value = "/menu")
  public String menu(HttpServletRequest request,HttpServletResponse response,Integer id,Model model){

    Admin admin = adminDao.find(id);
    model.addAttribute("user",admin);

    return "/admin/menu";
  }

}
