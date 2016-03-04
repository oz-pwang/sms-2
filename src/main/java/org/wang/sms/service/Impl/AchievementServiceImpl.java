package org.wang.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wang.sms.dao.AchievementDao;
import org.wang.sms.service.AchievementService;

/**
 * Created by Yang Wang on 16/3/4.
 */
public class AchievementServiceImpl implements AchievementService {

  @Autowired
  private AchievementDao achievementDao;


  public void setAchievementDao(AchievementDao achievementDao) {
    this.achievementDao = achievementDao;
  }
}
