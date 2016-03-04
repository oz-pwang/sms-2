package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.ExaminationDao;
import org.wang.sms.service.ExaminationService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class ExaminationServiceImpl implements ExaminationService{

  @Autowired
  private ExaminationDao examinationDao;

  public void setExaminationDao(ExaminationDao examinationDao) {
    this.examinationDao = examinationDao;
  }
}
