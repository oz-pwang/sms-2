package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.ClazzDao;
import org.wang.sms.model.Clazz;
import org.wang.sms.service.ClazzService;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class ClazzServiceImpl implements ClazzService{

  @Autowired
  private ClazzDao clazzDao;

  public void setClazzDao(ClazzDao clazzDao) {
    this.clazzDao = clazzDao;
  }

  @Override
  public List<Clazz> List() {
    return clazzDao.list();
  }

  @Override
  public Clazz find(Integer id) {
    return clazzDao.find(id);
  }

  @Override
  public List<Clazz> list() {
    return clazzDao.list();
  }
}
