package org.wang.sms.dao;

import org.wang.sms.model.Admin;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface AdminDao {
  Admin find(String username, String password);

  Admin find(Integer id);
}
