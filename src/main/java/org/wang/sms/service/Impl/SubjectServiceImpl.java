package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.SubjectDao;
import org.wang.sms.model.Subject;
import org.wang.sms.service.SubjectService;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class SubjectServiceImpl implements SubjectService{

  @Autowired
  private SubjectDao subjectDao;

  public void setSubjectDao(SubjectDao subjectDao) {
    this.subjectDao = subjectDao;
  }

  @Override
  public List<Subject> list() {
    return subjectDao.list();
  }

  @Override
  public Subject find(Integer id) {
    return subjectDao.find(id);
  }

  @Override
  public Subject find(String name) {
    return subjectDao.find(name);
  }
}
