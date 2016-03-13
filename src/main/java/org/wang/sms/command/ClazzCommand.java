package org.wang.sms.command;

import org.wang.sms.model.Clazz;

/**
 * Created by Yang Wang on 16/3/6.
 */
public class ClazzCommand {
  private Integer id;
  private String name;
  private String size;
  private String headTeacher;

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

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getHeadTeacher() {
    return headTeacher;
  }

  public void setHeadTeacher(String headTeacher) {
    this.headTeacher = headTeacher;
  }

  public ClazzCommand() {
  }

  public ClazzCommand(Clazz clazz) {
    this.setId(clazz.getId());
    this.setName(clazz.getName());
    this.setSize(String.valueOf(clazz.getStudentSet().size()));

    if(clazz.getHeadTeacher() != null){
      this.setHeadTeacher(clazz.getHeadTeacher().getName());
    }
  }
}
