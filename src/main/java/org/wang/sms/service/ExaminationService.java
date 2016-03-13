package org.wang.sms.service;

import org.wang.sms.model.Examination;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface ExaminationService {

  void add(Examination examination);

  List<Examination> list();

  List<Examination> getClazzExamination(Integer clazzId);

  Examination find(Integer id);
}
