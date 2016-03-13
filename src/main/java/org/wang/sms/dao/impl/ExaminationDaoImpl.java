package org.wang.sms.dao.impl;

import org.wang.sms.dao.BaseDao;
import org.wang.sms.dao.ClazzDao;
import org.wang.sms.dao.ExaminationDao;
import org.wang.sms.model.Examination;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class ExaminationDaoImpl extends BaseDao implements ExaminationDao{
  @Override
  public void add(Examination examination) {
    getSession().save(examination);
  }

  @Override
  public List<Examination> list() {
    return getSession().createQuery("from Examination").list();
  }

  @Override
  public Examination find(Integer id) {
    return (Examination) getSession().get(Examination.class,id);
  }

  @Override
  public List<Examination> findByClazzId(Integer clazzId) {
//    return getSession().createQuery("select distinct e from Clazz c left join c.examinationSet e where c.id = :clazzId").setParameter("clazzId", clazzId).list();
    return getSession().createQuery("select distinct e from Examination e left join e.clazzSet c where c.id = :clazzId").setParameter("clazzId", clazzId).list();
  }
}
