package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.sms.command.ExaminationCommand;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.model.Student;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;
import org.wang.sms.service.ClazzService;
import org.wang.sms.service.ExaminationService;
import org.wang.sms.service.SubjectService;
import org.wang.sms.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/25.
 */
@RequestMapping(value = "/examination")
@Controller
public class ExaminationController {

  @Autowired
  private SubjectService subjectService;

  @Autowired
  private TeacherService teacherService;

  @Autowired
  private ExaminationService examinationService;

  @Autowired
  private ClazzService clazzService;



  @RequestMapping(
      value = "/add",
      method = RequestMethod.GET
  )
  public String add(Integer id,Model model) {
    ExaminationCommand command = new ExaminationCommand();

    command.setSubjectList(subjectService.list());
    command.setClazzList(clazzService.List());

    model.addAttribute("id",id);
    model.addAttribute("command",command);
    return "/examination/add";
  }


  @RequestMapping(
      value = "/add",
      method = RequestMethod.POST
  )
  public String add(HttpServletRequest request, HttpServletResponse response,Integer id, Model model,ExaminationCommand command) {

    Teacher teacher = teacherService.find(id);
    Examination examination = command.toExamination();
    List<Integer> subjectIdList = command.getSubjectIdList();
    List<Integer> clazzIdList = command.getClazzIdList();
    Set<Student> studentSet = new LinkedHashSet<Student>();

    Set<Subject> subjectSet = new HashSet<Subject>();
    Set<Clazz> clazzSet = new HashSet<Clazz>();
    for (Integer clazzId : clazzIdList){
      Clazz clazz = clazzService.find(clazzId);
      studentSet.addAll(clazz.getStudentSet());
      clazzSet.add(clazz);
    }

    for (Integer subjectId : subjectIdList){
      Subject subject = subjectService.find(subjectId);
      subjectSet.add(subject);
    }
    examination.setCreateDate(new Date());
    examination.setSubjectSet(subjectSet);
    examination.setClazzSet(clazzSet);
    examination.setCreator(teacher);
    examination.setExaminationStatus("no");
    examination.setAchievementStatus("no");
    examination.setStudentSet(studentSet);

    examinationService.add(examination);

    List<Examination> examinationList = examinationService.list();
    List<ExaminationCommand> commandList = new ArrayList<ExaminationCommand>();
    for (Examination e : examinationList){
      commandList.add(new ExaminationCommand(e));
    }

    model.addAttribute("examinationList",commandList);
    return "redirect:/teacher/examinationList?id="+teacher.getId();
  }

  @RequestMapping(
      value = "/list",
      method = RequestMethod.GET
  )
  public String query(Model model) {

    List<Examination> examinationList = examinationService.list();
    List<ExaminationCommand> commandList = new ArrayList<ExaminationCommand>();
    for (Examination examination : examinationList){
      commandList.add(new ExaminationCommand(examination));
    }

    model.addAttribute("examinationList",commandList);
    return "examination/list";
  }


}
