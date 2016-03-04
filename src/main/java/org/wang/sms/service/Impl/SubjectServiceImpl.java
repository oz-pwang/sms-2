package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.SubjectDao;
import org.wang.sms.service.SubjectService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class SubjectServiceImpl implements SubjectService{

  @Autowired
  private SubjectDao subjectDao;

  public void setSubjectDao(SubjectDao subjectDao) {
    this.subjectDao = subjectDao;
  }
}
