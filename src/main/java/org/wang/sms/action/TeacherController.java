package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.sms.command.ExaminationCommand;
import org.wang.sms.command.TeacherCommand;
import org.wang.sms.command.TeacherExaminationCommand;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.model.Student;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;
import org.wang.sms.service.ClazzService;
import org.wang.sms.service.ExaminationService;
import org.wang.sms.service.SubjectService;
import org.wang.sms.service.TeacherService;
import org.wang.sms.until.validator.UserValidator;

import javax.persistence.SecondaryTable;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@RequestMapping(value = "/teacher")
@Controller
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  @Autowired
  SubjectService subjectService;

  @Autowired
  ExaminationService examinationService;

  @Autowired
  ClazzService clazzService;


  private UserValidator validator = new UserValidator();


  @RequestMapping(
      value = "/info",
      method = RequestMethod.GET
  )
  public String toStudentInfoView(HttpServletRequest request, Integer id, Model model) {
    Teacher teacher = teacherService.find(id);
    model.addAttribute("user", new TeacherCommand(teacher));

    return "teacher/info";
  }

  @RequestMapping(
      value = "/edit",
      method = RequestMethod.GET
  )
  public String editStudent(Integer id, Model model) {
    Teacher teacher = teacherService.find(id);
    List<Subject> subjectList = subjectService.list();
    List<Clazz> clazzList = clazzService.List();
    model.addAttribute("subjectList", subjectList);
    model.addAttribute("clazzList", clazzList);
    model.addAttribute("command", new TeacherCommand(teacher));

    return "teacher/edit";
  }

  @RequestMapping(
      value = "/examinationList",
      method = RequestMethod.GET
  )
  public String examinationList(Integer id, Model model) {
    List<Examination> examinationList = examinationService.list();
    TeacherCommand teacherCommand = new TeacherCommand(teacherService.find(id));
    List<TeacherExaminationCommand> commandList = new ArrayList<TeacherExaminationCommand>();
    for (Examination examination : examinationList) {
      commandList.add(new TeacherExaminationCommand(examination));
    }

    model.addAttribute("user",teacherCommand);
    model.addAttribute("commandList", commandList);
    return "teacher/examinationList";
  }

  @RequestMapping(
      value = "/queryAchievement",
      method = RequestMethod.GET
  )
  public String queryAchievement(Integer id, Model model) {
    Examination examination = examinationService.find(id);
//    Integer clazzId = examination.getClazz().getId();
//    Clazz clazz = clazzService.find(clazzId);
//    Set<Student> studentSet = clazz.getStudentSet();
//    Set<Subject> subjectSet = examination.getSubjectSet();
//
//    for (Subject subject : subjectSet){
//      subjectService.find(examination.getId(),clazzId)
//    }

    return "teacher/achievementList";
  }

  @RequestMapping(
      value = "/edit",
      method = RequestMethod.POST
  )
  public String editStudent(@ModelAttribute("command") TeacherCommand command, BindingResult result, Model model) throws Exception {

    validator.validate(command, result);
    if (!result.hasErrors()) {
      Teacher t = teacherService.find(command.getId());

      Teacher teacher = command.toTeacher(t);

      Clazz clazz = clazzService.find(command.getClazzId());
      Subject subject = subjectService.find(command.getSubjectId());
      teacher.setClazz(clazz);
      teacher.setSubject(subject);

      teacherService.update(teacher);

      return "redirect:/teacher/info?id=" + teacher.getId();
    } else {
      return "teacher/edit";
    }

  }


//  @RequestMapping(
//      value = "/createExamination",
//      method = RequestMethod.GET
//  )
//  public String createExamination(Model model,Integer id) {
//    List<Subject> subjectList = subjectService.list();
//    AddOrEditTeacherCommand command = new AddOrEditTeacherCommand();
//    command.setSubjectList(subjectList);
//    command.setId(id);
//    model.addAttribute("command",command);
//
//    return "examination/add";
//  }


  @RequestMapping(
      value = "/add",
      method = RequestMethod.GET
  )
  public String addTeacher(Model model) {
    List<Subject> subjectList = subjectService.list();
    List<Clazz> clazzList = clazzService.List();
    model.addAttribute("subjectList", subjectList);
    model.addAttribute("clazzList", clazzList);
    model.addAttribute("command", new TeacherCommand());

    return "teacher/add";
  }


  @RequestMapping(
      value = "/list",
      method = RequestMethod.GET
  )
  public String list(Model model) {

    List<Teacher> teacherList = teacherService.list();
    List<TeacherCommand> teacherCommandList = new ArrayList<TeacherCommand>();

    for (Teacher teacher : teacherList) {
      teacherCommandList.add(new TeacherCommand(teacher));
    }

    model.addAttribute("users", teacherCommandList);

    return "teacher/list";
  }


  @RequestMapping(
      value = "/add",
      method = RequestMethod.POST
  )
  public String addTeacher(@ModelAttribute("command") TeacherCommand command, BindingResult result, Model model) throws Exception {
    validator.validate(command, result);

    if (!result.hasErrors()) {
      Teacher teacher = command.toTeacher();
      Integer id = teacherService.add(teacher);
      return "redirect:/teacher/list?id=" + id;
    } else {

      return "redirect:teacher/add";
    }


  }


}
