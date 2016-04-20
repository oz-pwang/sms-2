package org.wang.sms.dao.impl;

import org.wang.sms.dao.BaseDao;
import org.wang.sms.dao.StudentDao;
import org.wang.sms.model.Student;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class StudentDaoImpl extends BaseDao implements StudentDao{
  @Override
  public Student find(String username, String password) {
    return (Student) getSession().createQuery("from Student where name = ? and password = ?").setParameter(0, username).setParameter(1, password).setMaxResults(1).uniqueResult();
  }

  @Override
  public List<Student> findClazz(Integer id) {
    return getSession().createQuery("from Student as s where s.clazz.id = ?").setParameter(0,id).list();
  }

  @Override
  public Integer add(Student student) {
    return (Integer) getSession().save(student);
  }

  @Override
  public List<Student> list() {
    return getSession().createQuery("from Student").list();
  }

  @Override
  public Student find(Integer id) {
    return (Student) getSession().get(Student.class,id);
  }

  @Override
  public void update(Student student) {
    getSession().saveOrUpdate(student);
  }

}
