package org.wang.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
  private Date createDate;

  @Column
  private Date startDate;

  @Column
  private Integer OverallResult;

  @JoinColumn
  @OneToOne
  private Clazz clazz;

  //  当前考试的创建者
  @JoinColumn
  @ManyToOne(cascade = { CascadeType.ALL })
  private Teacher creator;

  @JoinColumn
  @OneToMany
//  每次考试有多个科目
  private Set <Subject> subjectSet = new LinkedHashSet<Subject>();

  @JoinColumn
  @OneToMany
//  当次考试的所有成绩
  private Set<Achievement> achievementSet = new LinkedHashSet<Achievement>();

}
