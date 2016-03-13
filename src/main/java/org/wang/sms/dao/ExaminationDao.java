package org.wang.sms.dao;

import org.wang.sms.model.Examination;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface ExaminationDao {

  void add(Examination examination);

  List<Examination> list();

  Examination find(Integer id);

  List<Examination> findByClazzId(Integer clazzId);
}
