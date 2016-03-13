package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.sms.command.ExaminationCommand;
import org.wang.sms.command.StudentCommand;
import org.wang.sms.command.StudentExaminationCommand;
import org.wang.sms.model.Achievement;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.model.Student;
import org.wang.sms.service.AchievementService;
import org.wang.sms.service.ClazzService;
import org.wang.sms.service.ExaminationService;
import org.wang.sms.service.StudentService;
import org.wang.sms.until.validator.UserValidator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yang Wang on 16/2/15.
 */
@RequestMapping(value = "/student")
@Controller
public class StudentController {
  @Autowired
  private StudentService studentService;

  @Autowired
  private ClazzService clazzService;

  @Autowired
  ExaminationService examinationService;

  @Autowired
  AchievementService achievementService;

  private UserValidator validator = new UserValidator();

  @RequestMapping(
      value = "/info",
      method = RequestMethod.GET
  )
  public String toStudentInfoView(Integer id, Model model) {
    Student student = studentService.find(id);
    model.addAttribute("user", new StudentCommand(student));

    return "student/info";
  }

  @RequestMapping(
      value = "/edit",
      method = RequestMethod.GET
  )
  public String editStudent(Integer id, Model model) {
    Student student = studentService.find(id);
    model.addAttribute("command", new StudentCommand(student));

    return "student/edit";
  }

  @RequestMapping(
      value = "/viewResults",
      method = RequestMethod.GET
  )
  public String viewResults(Integer id, Model model) {
    List<StudentExaminationCommand> commandList = new ArrayList<StudentExaminationCommand>();

    Student student = studentService.find(id);
    Integer clazzId = student.getClazz().getId();

    List<Examination> examinationList = examinationService.getClazzExamination(clazzId);
    for (Examination examination : examinationList){
      StudentExaminationCommand command = new StudentExaminationCommand(examination);
      commandList.add(command);
    }


    model.addAttribute("examinationList",commandList);

    return "student/viewResults";
  }

  @RequestMapping(
      value = "/edit",
      method = RequestMethod.POST
  )
  public String editStudent(
      @ModelAttribute("command") StudentCommand command, BindingResult result, Model model) throws Exception {
    validator.validate(command, result);
    if (!result.hasErrors()) {

      Student s = studentService.find(command.getId());

      Student student = command.toStudent(s);

      Clazz clazz = clazzService.find(command.getClazzId());
      student.setClazz(clazz);

      studentService.update(student);

      model.addAttribute("command", new StudentCommand(student));
      return "redirect:/student/info?id="+student.getId();
    }
    return "student/edit";
  }


  @RequestMapping(
      value = "/add",
      method = RequestMethod.GET
  )
  public String addStudent(Model model) {
    List<Clazz> clazzList = clazzService.List();

    model.addAttribute("command", new StudentCommand());
    model.addAttribute("clazzList",clazzList);
    return "student/add";
  }

  @RequestMapping(
      value = "/add",
      method = RequestMethod.POST
  )
  public String addStudent(@ModelAttribute("command") StudentCommand command, BindingResult result, Model model) throws Exception {

    validator.validate(command, result);

    if (!result.hasErrors()) {
      Student student = command.toStudent();
      Integer id = studentService.add(student);
      return "redirect:/student/list?id=" + command.getClazzId();
    } else {
      return "redirect:/student/add";
    }
  }

  @RequestMapping(
      value = "/list",
      method = RequestMethod.GET
  )
  public String list(Integer id,Model model) {

    if (id != null){
      List<Student> studentList = studentService.findClazz(id);

      List<StudentCommand> studentCommandList = new ArrayList<StudentCommand>();

      for (Student student : studentList){
        studentCommandList.add(new StudentCommand(student));
      }

      model.addAttribute("users",studentCommandList);

      return "student/list";
    }

    List<Student> studentList = studentService.list();
    List<StudentCommand> studentCommandList = new ArrayList<StudentCommand>();

    for (Student student : studentList){
      studentCommandList.add(new StudentCommand(student));
    }

    model.addAttribute("users",studentCommandList);

    return "student/list";
  }

}
