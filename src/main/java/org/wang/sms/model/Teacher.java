package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@Entity
public class Teacher extends User implements Serializable{

  private static final String ROLE = "TEACHER";

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @JoinColumn
  @ManyToOne(cascade = { CascadeType.ALL })
//  当前教师教学的班级
  private Clazz clazz;

  @JoinColumn
  @OneToMany
//  教师创建的考试（多个）
  private Set<Examination> examinationSet = new LinkedHashSet<Examination>();

  @JoinColumn(name = "subjectId")
  @ManyToOne(cascade = { CascadeType.ALL })
//  教学科目
  private Subject subject;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<Examination> getExaminationSet() {
    return examinationSet;
  }

  public void setExaminationSet(Set<Examination> examinationSet) {
    this.examinationSet = examinationSet;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Clazz getClazz() {
    return clazz;
  }

  public void setClazz(Clazz clazz) {
    this.clazz = clazz;
  }
}
