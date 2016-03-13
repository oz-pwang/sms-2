package org.wang.sms.command;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yang Wang on 16/2/18.
 */
public class BaseCommand {

  protected static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  protected Integer id;

  protected Integer age;

  protected String name;

  protected String gender = "male";

  protected String phoneNumber;

  protected Date birthDate;

  protected String birthDateString;

  protected String IDCardNumber;

  protected String passWord;

  protected String passWordValidator;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getPassWordValidator() {
    return passWordValidator;
  }

  public void setPassWordValidator(String passWordValidator) {
    this.passWordValidator = passWordValidator;
  }

}
