package org.wang.sms.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yang Wang on 16/2/15.
 */
@MappedSuperclass
public abstract class User implements Serializable{

  @Column(length = 12 , nullable = false)
  protected String name;

  @Column(length = 16 , nullable = false)
  protected String passWord;

  @Column
  protected Integer age;

  @Column
  protected String gender = "male";

  @Column(length = 11)
  protected String phoneNumber;

  @Column
  protected Date birthDate;

  @Transient
  protected String birthDateString;

  @Column(length = 18)
  protected String IDCardNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getBirthDateString() {
    return birthDateString;
  }

  public void setBirthDateString(String birthDateString) {
    this.birthDateString = birthDateString;
  }

  public String getIDCardNumber() {
    return IDCardNumber;
  }

  public void setIDCardNumber(String IDCardNumber) {
    this.IDCardNumber = IDCardNumber;
  }
}
