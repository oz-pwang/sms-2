package org.wang.sms.dao.impl;

import org.wang.sms.dao.BaseDao;
import org.wang.sms.dao.ClazzDao;
import org.wang.sms.model.Clazz;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class ClazzDaoImpl extends BaseDao implements ClazzDao{
  @Override
  public List<Clazz> list() {
    return getSession().createQuery("from Clazz").list();
  }

  @Override
  public Clazz find(Integer id) {
    return (Clazz) getSession().get(Clazz.class,id);
  }
}
