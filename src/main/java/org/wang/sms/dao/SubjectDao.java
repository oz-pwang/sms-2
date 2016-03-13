package org.wang.sms.dao;

import org.wang.sms.model.Subject;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface SubjectDao {
  List<Subject> list();

  Subject find(Integer id);

  Subject find(String name);
}
