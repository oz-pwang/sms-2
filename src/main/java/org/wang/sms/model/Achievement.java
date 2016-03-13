package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Yang Wang on 16/2/16.
 */
@Entity
public class Achievement implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;


  @Column
//  分数
  private Integer fraction;

  @JoinColumn(name = "studentId")
  @ManyToOne(cascade = {CascadeType.ALL})
//  这是哪个学生的成绩
  private Student student;

  @JoinColumn(name = "examinationId")
  @ManyToOne(cascade = {CascadeType.ALL})
  //  此次成绩对应的考试
  private Examination examination;

  @JoinColumn(name = "subjectId")
  @ManyToOne(cascade = {CascadeType.ALL})
  //  此次成绩对应的科目
  private Subject subject;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Examination getExamination() {
    return examination;
  }

  public void setExamination(Examination examination) {
    this.examination = examination;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Integer getFraction() {
    return fraction;
  }

  public void setFraction(Integer fraction) {
    this.fraction = fraction;
  }
}
