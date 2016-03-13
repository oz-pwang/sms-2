package org.wang.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by Yang Wang on 16/3/13.
 */
@Entity
public class Address {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @Column
  private Integer ref_id;

  @Column
  private String ref_name;

  @JoinColumn
  @OneToOne
  private Student student;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRef_name() {
    return ref_name;
  }

  public void setRef_name(String ref_name) {
    this.ref_name = ref_name;
  }

  public Integer getRef_id() {
    return ref_id;
  }

  public void setRef_id(Integer ref_id) {
    this.ref_id = ref_id;
  }
}
