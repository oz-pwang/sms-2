package org.wang.sms.dao.impl;

import org.wang.sms.dao.BaseDao;
import org.wang.sms.dao.SubjectDao;
import org.wang.sms.model.Subject;

import java.util.List;

/**
 * Created by Yang Wang on 16/2/19.
 */
public class SubjectDaoImpl extends BaseDao implements SubjectDao {

  @Override
  public List<Subject> list() {
    return getSession().createQuery("from Subject").list();
  }

  @Override
  public Subject find(Integer id) {
    return (Subject) getSession().get(Subject.class,id);
  }

  @Override
  public Subject find(String name) {
    return (Subject) getSession().createQuery("from Subject where name = ?").setParameter(0,name).setMaxResults(1).uniqueResult();
  }
}
