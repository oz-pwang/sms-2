package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@Entity
public class Examination implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @Column
  private String name;

  @Column
  private String examinationStatus;

  @Column
  private String achievementStatus;


  @Column
  private Date createDate;

  @Column
  private Date startDate;

  @Column
  private Integer OverallResult;

  @JoinColumn
  @ManyToMany(cascade = {CascadeType.ALL})
  private Set<Clazz> clazzSet;

  //  当前考试的创建者
  @JoinColumn(name = "teacherId")
  @ManyToOne(cascade = { CascadeType.ALL })
  private Teacher creator;

  @JoinColumn
  @OneToMany
  private Set<Student> studentSet = new LinkedHashSet<Student>();

  @ManyToMany
  @JoinTable(
      name="user_role",
      joinColumns=@JoinColumn(name="user_id"),
      inverseJoinColumns=@JoinColumn(name="role_id")
  )
//  每次考试有多个科目
  private Set <Subject> subjectSet = new LinkedHashSet<Subject>();

  @JoinColumn
  @OneToMany
//  当次考试的所有成绩
  private Set<Achievement> achievementSet = new LinkedHashSet<Achievement>();


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Integer getOverallResult() {
    return OverallResult;
  }

  public void setOverallResult(Integer overallResult) {
    OverallResult = overallResult;
  }

  public Teacher getCreator() {
    return creator;
  }

  public void setCreator(Teacher creator) {
    this.creator = creator;
  }

  public Set<Subject> getSubjectSet() {
    return subjectSet;
  }

  public void setSubjectSet(Set<Subject> subjectSet) {
    this.subjectSet = subjectSet;
  }

  public Set<Achievement> getAchievementSet() {
    return achievementSet;
  }

  public void setAchievementSet(Set<Achievement> achievementSet) {
    this.achievementSet = achievementSet;
  }


  public String getExaminationStatus() {
    return examinationStatus;
  }

  public void setExaminationStatus(String examinationStatus) {
    this.examinationStatus = examinationStatus;
  }

  public String getAchievementStatus() {
    return achievementStatus;
  }

  public void setAchievementStatus(String achievementStatus) {
    this.achievementStatus = achievementStatus;
  }

  public Set<Clazz> getClazzSet() {
    return clazzSet;
  }

  public void setClazzSet(Set<Clazz> clazzSet) {
    this.clazzSet = clazzSet;
  }

  public Set<Student> getStudentSet() {
    return studentSet;
  }

  public void setStudentSet(Set<Student> studentSet) {
    this.studentSet = studentSet;
  }
}
