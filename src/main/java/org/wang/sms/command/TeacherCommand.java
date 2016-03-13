package org.wang.sms.command;

import org.springframework.util.StringUtils;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yang Wang on 16/3/6.
 */
public class TeacherCommand extends BaseCommand{

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  private Integer clazzId;

  private Integer subjectId;

  private String clazzName;

  private String subjectName;

  public Integer getClazzId() {
    return clazzId;
  }

  public void setClazzId(Integer clazzId) {
    this.clazzId = clazzId;
  }

  public Integer getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Integer subjectId) {
    this.subjectId = subjectId;
  }

  public String getClazzName() {
    return clazzName;
  }

  public void setClazzName(String clazzName) {
    this.clazzName = clazzName;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public Teacher toTeacher() {
    Teacher teacher = new Teacher();

    teacher.setId(this.getId());
    teacher.setName(this.getName());
    teacher.setIDCardNumber(this.getIDCardNumber());
    teacher.setPassWord(this.getPassWord());
    teacher.setAge(this.getAge());
    teacher.setPhoneNumber(this.getPhoneNumber());
    teacher.setGender(this.getGender());
    teacher.setBirthDateString(this.getBirthDateString());
    if (StringUtils.hasText(this.getBirthDateString())) {
      Date date = null;
      try {
        date = sdf.parse(this.getBirthDateString());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      teacher.setBirthDate(date);
    }

    if (this.getSubjectId() != null) {
      Subject subject = new Subject();

      subject.setId(this.getSubjectId());
      teacher.setSubject(subject);
    }

    if (this.getClazzId() != null) {
      Clazz clazz = new Clazz();
      clazz.setId(this.getClazzId());
      teacher.setClazz(clazz);
    }
    return teacher;
  }

  public TeacherCommand() {
  }

  public TeacherCommand(Teacher teacher) {
    this.setId(teacher.getId());
    this.setName(teacher.getName());
    this.setAge(teacher.getAge());
    this.setGender(teacher.getGender());
    this.setIDCardNumber(teacher.getIDCardNumber());
    this.setPhoneNumber(teacher.getPhoneNumber());

    if (teacher.getBirthDate() != null){
      this.setBirthDateString(sdf.format(teacher.getBirthDate()));
    }

    if(teacher.getClazz() != null){
      this.setClazzId(teacher.getClazz().getId());
      this.setClazzName(teacher.getClazz().getName());
    }

    if(teacher.getSubject() != null){
      this.setSubjectName(teacher.getSubject().getName());
      this.setSubjectId(teacher.getSubject().getId());
    }
  }


  public Teacher toTeacher(Teacher t) {

    t.setId(this.getId());
    t.setName(this.getName());
    t.setIDCardNumber(this.getIDCardNumber());
    t.setAge(this.getAge());
    t.setPhoneNumber(this.getPhoneNumber());
    t.setGender(this.getGender());
    t.setBirthDateString(this.getBirthDateString());
    if (StringUtils.hasText(this.getBirthDateString())) {
      Date date = null;
      try {
        date = sdf.parse(this.getBirthDateString());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      t.setBirthDate(date);
    }

    if (this.getSubjectId() != null) {
      Subject subject = new Subject();

      subject.setId(this.getSubjectId());
      t.setSubject(subject);
    }

    if (this.getClazzId() != null) {
      Clazz clazz = new Clazz();
      clazz.setId(this.getClazzId());
      t.setClazz(clazz);
    }
    return t;
  }
}
