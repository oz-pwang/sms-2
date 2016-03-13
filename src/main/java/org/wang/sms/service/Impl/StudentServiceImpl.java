package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.StudentDao;
import org.wang.sms.model.Student;
import org.wang.sms.service.StudentService;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  @Override
  public Student find(String username, String password) {
    return studentDao.find(username,password);
  }

  @Override
  public List<Student> findClazz(Integer id) {
    return studentDao.findClazz(id);
  }

  @Override
  public Integer add(Student student) {
    return studentDao.add(student);
  }

  @Override
  public List<Student> list() {
    return studentDao.list();
  }

  @Override
  public Student find(Integer id) {
    return studentDao.find(id);
  }

  @Override
  public void update(Student student) {
    studentDao.update(student);
  }

}
