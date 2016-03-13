package org.wang.sms.command;

import org.wang.sms.model.Examination;

import java.text.SimpleDateFormat;

/**
 * Created by Yang Wang on 16/3/9.
 */
public class StudentExaminationCommand {
  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  private Integer id;

  private String name;

  private Integer overallResult;

  private String startDate;

  private String createDate;

  private String creator;



  public StudentExaminationCommand(Examination e) {
    this.setId(e.getId());
    this.setName(e.getName());
    this.setOverallResult(e.getOverallResult());
    if (e.getStartDate() != null) {
      this.setStartDate(sdf.format(e.getStartDate()));
    }
    if (e.getCreateDate() != null) {
      this.setCreateDate(sdf.format(e.getCreateDate()));
    }
    if(e.getCreator() != null ){
      this.setCreator(e.getCreator().getName());
    }
  }

  public StudentExaminationCommand() {
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

  public Integer getOverallResult() {
    return overallResult;
  }

  public void setOverallResult(Integer overallResult) {
    this.overallResult = overallResult;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }
}
