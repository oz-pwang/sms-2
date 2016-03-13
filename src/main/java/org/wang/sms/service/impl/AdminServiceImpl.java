package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.AdminDao;
import org.wang.sms.dao.SubjectDao;
import org.wang.sms.model.Admin;
import org.wang.sms.service.AdminService;
import org.wang.sms.service.SubjectService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class AdminServiceImpl implements AdminService{

  @Autowired
  private AdminDao adminDao;


  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  @Override
  public Admin find(String username, String password) {
    return adminDao.find(username,password);
  }
}
