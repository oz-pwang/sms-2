package org.wang.sms.dao;

import org.wang.sms.model.Student;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface StudentDao {
  Student find(String username, String password);

  List<Student> findClazz(Integer id);

  Integer add(Student student);

  List<Student> list();

  Student find(Integer id);

  void update(Student student);

}
