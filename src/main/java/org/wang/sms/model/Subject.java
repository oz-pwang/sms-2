package org.wang.sms.model;

import java.io.Serializable;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 * Created by Yang Wang on 16/2/15.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  03/08/2016 15:05
 */
@Entity public class Subject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8052572990935222224L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn @OneToMany
// 每个科目含有多个成绩
  private Set<Achievement>                                    achievementSet = new LinkedHashSet<Achievement>();

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Integer id;

  @Column private String name;

  @JoinColumn
  @ManyToMany
  private Set<Examination> examinationSet = new HashSet<Examination>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for achievement set.
   *
   * @return  Set
   */
  public Set<Achievement> getAchievementSet() {
    return achievementSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Integer
   */
  public Integer getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for achievement set.
   *
   * @param  achievementSet  Set
   */
  public void setAchievementSet(Set<Achievement> achievementSet) {
    this.achievementSet = achievementSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Integer
   */
  public void setId(Integer id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  public Set<Examination> getExaminationSet() {
    return examinationSet;
  }

  public void setExaminationSet(Set<Examination> examinationSet) {
    this.examinationSet = examinationSet;
  }
} // end class Subject
