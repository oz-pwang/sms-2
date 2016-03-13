package org.wang.sms.command;

import org.wang.sms.model.Examination;

import java.text.SimpleDateFormat;

/**
 * Created by Yang Wang on 16/3/9.
 */
public class TeacherExaminationCommand {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  private Integer id;
  private String name;
  private String createDate;
  private String examinationStatus;
  private String achievementStatus;

  public TeacherExaminationCommand() {
  }

  public TeacherExaminationCommand(Examination e) {
    this.setId(e.getId());
    this.setName(e.getName());
    this.setExaminationStatus(e.getExaminationStatus());
    this.setAchievementStatus(e.getAchievementStatus());
    if (e.getCreateDate() != null){
      this.setCreateDate(sdf.format(e.getCreateDate()));
    }
  }

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

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }
}
