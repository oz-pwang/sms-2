package org.wang.sms.service;

import org.wang.sms.model.Admin;

/**
 * Created by Yang Wang on 16/3/4.
 */
public interface AdminService {
  Admin find(String username, String password);
}
