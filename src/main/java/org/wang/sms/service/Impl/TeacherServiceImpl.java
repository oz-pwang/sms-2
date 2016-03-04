package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.TeacherDao;
import org.wang.sms.service.TeacherService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class TeacherServiceImpl implements TeacherService{

  @Autowired
  private TeacherDao teacherDao;


  public void setTeacherDao(TeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }
}
