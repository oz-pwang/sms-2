package org.wang.sms.service;

import org.wang.sms.model.Achievement;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface AchievementService {
  List<Achievement> getByExaminationId(Integer examinationId);

  void add(Achievement achievement);
}
