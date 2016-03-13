package org.wang.sms.dao;

import org.wang.sms.model.Admin;
import org.wang.sms.model.Clazz;

import java.util.List;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface ClazzDao {
  List<Clazz> list();

  Clazz find(Integer id);
}
