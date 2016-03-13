package org.wang.sms.dao;

import org.wang.sms.model.Teacher;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface TeacherDao {
  Teacher find(String username, String password);

  Integer add(Teacher teacher);

  List<Teacher> list();

  Teacher find(Integer id);

  void update(Teacher teacher);
}
