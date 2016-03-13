package org.wang.sms.command;

import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.model.Subject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Wang on 16/3/6.
 */
public class ExaminationCommand {

  public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  private Integer id;
  private String name;
  private String creator;
  private String createDate;
  private String startDate;
  private List<Subject> subjectList;
  private List<Integer> subjectIdList = new ArrayList<Integer>();
  private List<Integer> clazzIdList;
  private List<Clazz> clazzList = new ArrayList<Clazz>();

  public ExaminationCommand() {
  }

  public ExaminationCommand(Examination examination) {
    this.setId(examination.getId());
    this.setName(examination.getName());
    if (examination.getCreator() !=null){
      this.setCreator(examination.getCreator().getName());
    }
    if (examination.getCreateDate() != null){
      this.setCreateDate(sdf.format(examination.getCreateDate()));
    }
  }

  public Examination toExamination() {
    Examination examination = new Examination();

    examination.setId(this.getId());
    examination.setName(this.getName());

    try {
      examination.setStartDate(sdf.parse(this.getStartDate()));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return examination;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
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

  public List<Clazz> getClazzList() {
    return clazzList;
  }

  public void setClazzList(List<Clazz> clazzList) {
    this.clazzList = clazzList;
  }

  public List<Integer> getSubjectIdList() {
    return subjectIdList;
  }

  public void setSubjectIdList(List<Integer> subjectIdList) {
    this.subjectIdList = subjectIdList;
  }

  public List<Integer> getClazzIdList() {
    return clazzIdList;
  }

  public void setClazzIdList(List<Integer> clazzIdList) {
    this.clazzIdList = clazzIdList;
  }

  public List<Subject> getSubjectList() {
    return subjectList;
  }

  public void setSubjectList(List<Subject> subjectList) {
    this.subjectList = subjectList;
  }
}
