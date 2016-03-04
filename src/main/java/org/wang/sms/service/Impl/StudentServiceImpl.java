package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.StudentDao;
import org.wang.sms.service.StudentService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
}
