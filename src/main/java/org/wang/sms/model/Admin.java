package org.wang.sms.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yang Wang on 16/3/3.
 */
@Entity
public class Admin implements Serializable{

  private static final String ROLE = "ADMIN";

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @Column(length = 12 , nullable = false)
  private String name;

  @Column(length = 16 , nullable = false)
  private String passWord;

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
