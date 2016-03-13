package org.wang.sms.dao.impl;

import org.wang.sms.dao.AchievementDao;
import org.wang.sms.dao.BaseDao;
import org.wang.sms.model.Achievement;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class AchievementDaoImpl extends BaseDao implements AchievementDao{
  @Override
  public List<Achievement> getByExaminationId(Integer examinationId) {
    return getSession().createQuery("from Achievement as a where a.examination.id=?").setParameter(0,examinationId).list();
  }

  @Override
  public void add(Achievement achievement) {
    getSession().save(achievement);
  }
}
