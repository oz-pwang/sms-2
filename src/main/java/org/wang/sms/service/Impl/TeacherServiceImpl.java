package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.TeacherDao;
import org.wang.sms.model.Teacher;
import org.wang.sms.service.TeacherService;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class TeacherServiceImpl implements TeacherService{

  @Autowired
  private TeacherDao teacherDao;


  public void setTeacherDao(TeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }

  @Override
  public Teacher find(String username, String password) {
    return teacherDao.find(username,password);
  }

  @Override
  public Integer add(Teacher teacher) {
    return teacherDao.add(teacher);
  }

  @Override
  public List<Teacher> list() {
    return teacherDao.list();
  }

  @Override
  public Teacher find(Integer id) {
    return teacherDao.find(id);
  }

  @Override
  public void update(Teacher teacher) {
    teacherDao.update(teacher);
  }
}
