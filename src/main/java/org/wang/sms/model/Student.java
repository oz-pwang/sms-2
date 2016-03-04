package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@Entity
public class Student extends User implements Serializable {

  private static final String ROLE = "STUDENT";

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @JoinColumn
  @ManyToOne(cascade = {CascadeType.ALL})
//当前学生的所在的班级
  private Clazz clazz;

  @JoinColumn
  @ManyToMany
// 当前学生参加过的所有的考试
  private Set<Examination> allExams = new LinkedHashSet<Examination>();

  @JoinColumn
  @OneToMany
// 当前学生的所有成绩
  private Set<Achievement> allScores = new LinkedHashSet<Achievement>();


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Clazz getClazz() {
    return clazz;
  }

  public void setClazz(Clazz clazz) {
    this.clazz = clazz;
  }

  public Set<Examination> getAllExams() {
    return allExams;
  }

  public void setAllExams(Set<Examination> allExams) {
    this.allExams = allExams;
  }

  public Set<Achievement> getAllScores() {
    return allScores;
  }

  public void setAllScores(Set<Achievement> allScores) {
    this.allScores = allScores;
  }

}
