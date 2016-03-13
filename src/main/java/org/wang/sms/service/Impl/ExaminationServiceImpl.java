package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.ClazzDao;
import org.wang.sms.dao.ExaminationDao;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.service.ExaminationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class ExaminationServiceImpl implements ExaminationService{

  @Autowired
  private ExaminationDao examinationDao;
  @Autowired
  private ClazzDao clazzDao;

  public void setExaminationDao(ExaminationDao examinationDao) {
    this.examinationDao = examinationDao;
  }

  @Override
  public void add(Examination examination) {
    examinationDao.add(examination);
  }

  @Override
  public List<Examination> list() {
    return examinationDao.list();
  }

  @Override
  public List<Examination> getClazzExamination(Integer clazzId) {
    return examinationDao.findByClazzId(clazzId);
  }

  @Override
  public Examination find(Integer id) {
    return examinationDao.find(id);
  }
}
