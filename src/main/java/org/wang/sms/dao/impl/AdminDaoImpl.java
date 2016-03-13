package org.wang.sms.dao.impl;

import org.wang.sms.dao.AdminDao;
import org.wang.sms.dao.BaseDao;
import org.wang.sms.model.Admin;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class AdminDaoImpl extends BaseDao implements AdminDao{

  @Override
  public Admin find(String username, String password) {
    return (Admin) getSession().createQuery("from Admin where name = ? and password = ?").setParameter(0, username).setParameter(1, password).setMaxResults(1).uniqueResult();
  }

  @Override
  public Admin find(Integer id) {
    return (Admin) getSession().get(Admin.class,id);
  }
}
