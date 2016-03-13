package org.wang.sms.command;

import org.wang.sms.model.Examination;
import org.wang.sms.model.Student;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Wang on 16/3/9.
 */
public class AchievementCommand {
  private Integer id;

//  分数
  private Integer fraction;

  private Integer subjectId;

  private Integer studentId;

  private Integer examinationId;
  private Integer teacherId;
  private String studentName;
  private Teacher teacher;

  private Subject subject = new Subject();

  private Examination examination = new Examination();

  private List<Student> studentList = new ArrayList<Student>();


  public Integer getFraction() {
    return fraction;
  }

  public void setFraction(Integer fraction) {
    this.fraction = fraction;
  }

  public Integer getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Integer subjectId) {
    this.subjectId = subjectId;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Integer getExaminationId() {
    return examinationId;
  }

  public void setExaminationId(Integer examinationId) {
    this.examinationId = examinationId;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Examination getExamination() {
    return examination;
  }

  public void setExamination(Examination examination) {
    this.examination = examination;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Integer getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Integer teacherId) {
    this.teacherId = teacherId;
  }
}
