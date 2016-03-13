package org.wang.sms.service;

import org.wang.sms.model.Subject;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface SubjectService {
  List<Subject> list();

  Subject find(Integer id);

  Subject find(String name);
}
