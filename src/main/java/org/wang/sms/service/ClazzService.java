package org.wang.sms.service;

import org.wang.sms.model.Clazz;
import org.wang.sms.model.Student;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface ClazzService {
  List<Clazz> List();

  Clazz find(Integer id);

  List<Clazz> list();
}
