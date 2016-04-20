package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@Entity
public class Clazz implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @Column
  private String name;


  @JoinColumn
  @OneToMany
//  当前班级拥有的所有学生
  private Set<Student> studentSet;

  @JoinColumn(name = "teacherId")
  @OneToOne(cascade = {CascadeType.ALL})
//  班主任
  private Teacher headTeacher;

  @JoinColumn
  @OneToMany
  private Set<Examination> examinationSet = new HashSet<Examination>();

  @JoinColumn
  @OneToMany
//  所有的任课 老师（ 多个科目   不同的老师）
  private Set<Teacher> teacherSet = new HashSet<Teacher>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<Student> getStudentSet() {
    return studentSet;
  }

  public void setStudentSet(Set<Student> studentSet) {
    this.studentSet = studentSet;
  }

  public Teacher getHeadTeacher() {
    return headTeacher;
  }

  public void setHeadTeacher(Teacher headTeacher) {
    this.headTeacher = headTeacher;
  }

  public Set<Teacher> getTeacherSet() {
    return teacherSet;
  }

  public void setTeacherSet(Set<Teacher> teacherSet) {
    this.teacherSet = teacherSet;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Examination> getExaminationSet() {
    return examinationSet;
  }

  public void setExaminationSet(Set<Examination> examinationSet) {
    this.examinationSet = examinationSet;
  }
}
