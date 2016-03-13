package org.wang.sms.command;

import org.springframework.util.StringUtils;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Student;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yang Wang on 16/3/6.
 */
public class StudentCommand extends BaseCommand{

  public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  private Integer clazzId;

  private String clazzName;

  public Integer getClazzId() {
    return clazzId;
  }

  public void setClazzId(Integer clazzId) {
    this.clazzId = clazzId;
  }


  public String getClazzName() {
    return clazzName;
  }

  public void setClazzName(String clazzName) {
    this.clazzName = clazzName;
  }

  public Student toStudent() {
    Student student = new Student();

    student.setId(this.getId());
    student.setName(this.getName());
    student.setIDCardNumber(this.getIDCardNumber());
    student.setPassWord(this.getPassWord());
    student.setAge(this.getAge());
    student.setPhoneNumber(this.getPhoneNumber());
    student.setGender(this.getGender());
    student.setBirthDateString(this.getBirthDateString());
    if (StringUtils.hasText(this.getBirthDateString())) {
      Date date = null;
      try {
        date = sdf.parse(this.getBirthDateString());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      student.setBirthDate(date);
    }

    if (this.getClazzId() != null) {
      Clazz clazz = new Clazz();
      clazz.setId(this.getClazzId());
      student.setClazz(clazz);
    }
    return student;
  }

  public StudentCommand() {
  }

  public StudentCommand(Student student) {
    this.setId(student.getId());
    this.setName(student.getName());
    this.setAge(student.getAge());
    this.setGender(student.getGender());
    this.setIDCardNumber(student.getIDCardNumber());
    this.setPhoneNumber(student.getPhoneNumber());

    if (student.getBirthDate() != null){
      this.setBirthDateString(sdf.format(student.getBirthDate()));
    }

    if(student.getClazz() != null){
      this.setClazzId(student.getClazz().getId());
      this.setClazzName(student.getClazz().getName());
    }

  }

  public Student toStudent(Student s) {
    s.setId(this.getId());
    s.setName(this.getName());
    s.setIDCardNumber(this.getIDCardNumber());
    s.setPassWord(this.getPassWord());
    s.setAge(this.getAge());
    s.setPhoneNumber(this.getPhoneNumber());
    s.setGender(this.getGender());
    s.setBirthDateString(this.getBirthDateString());
    if (StringUtils.hasText(this.getBirthDateString())) {
      Date date = null;
      try {
        date = sdf.parse(this.getBirthDateString());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      s.setBirthDate(date);
    }

    if (this.getClazzId() != null) {
      Clazz clazz = new Clazz();
      clazz.setId(this.getClazzId());
      s.setClazz(clazz);
    }
    return s;

  }
}
