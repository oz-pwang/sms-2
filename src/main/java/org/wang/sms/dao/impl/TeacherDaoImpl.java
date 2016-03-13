package org.wang.sms.dao.impl;

import org.wang.sms.dao.BaseDao;
import org.wang.sms.dao.SubjectDao;
import org.wang.sms.dao.TeacherDao;
import org.wang.sms.model.Teacher;

import java.util.List;

/**
 * Created by Yang Wang on 16/2/19.
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

  @Override
  public Teacher find(String username, String password) {
    return (Teacher) getSession().createQuery("from Teacher where name = ? and password = ?").setParameter(0, username).setParameter(1, password).setMaxResults(1).uniqueResult();
  }

  @Override
  public Integer add(Teacher teacher) {
    return (Integer) getSession().save(teacher);
  }

  @Override
  public List<Teacher> list() {
    return getSession().createQuery("from Teacher").list();
  }

  @Override
  public Teacher find(Integer id) {
    return (Teacher) getSession().get(Teacher.class,id);
  }

  @Override
  public void update(Teacher teacher) {
    getSession().saveOrUpdate(teacher);
  }
}
