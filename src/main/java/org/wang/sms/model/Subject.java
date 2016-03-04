package org.wang.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@Entity
public class Subject implements Serializable {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @Column
  private String name;

  @JoinColumn
  @OneToMany
//  每个科目含有多个成绩
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

  public Set<Achievement> getAchievementSet() {
    return achievementSet;
  }

  public void setAchievementSet(Set<Achievement> achievementSet) {
    this.achievementSet = achievementSet;
  }
}
