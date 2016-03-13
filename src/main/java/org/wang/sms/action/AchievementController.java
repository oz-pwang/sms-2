package org.wang.sms.action;

import com.sun.tools.internal.ws.processor.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wang.sms.command.AchievementCommand;
import org.wang.sms.command.ClazzCommand;
import org.wang.sms.command.TeacherCommand;
import org.wang.sms.model.Achievement;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Examination;
import org.wang.sms.model.Student;
import org.wang.sms.model.Subject;
import org.wang.sms.model.Teacher;
import org.wang.sms.service.AchievementService;
import org.wang.sms.service.ClazzService;
import org.wang.sms.service.ExaminationService;
import org.wang.sms.service.StudentService;
import org.wang.sms.service.SubjectService;
import org.wang.sms.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Wang on 16/3/11.
 */
@Controller
@RequestMapping(value = "/achievement")
public class AchievementController {

  @Autowired
  TeacherService teacherService;

  @Autowired
  SubjectService subjectService;

  @Autowired
  ExaminationService examinationService;

  @Autowired
  ClazzService clazzService;

  @Autowired
  StudentService studentService;

  @Autowired
  AchievementService achievementService;

  @RequestMapping(
      value = "/add",
      method = RequestMethod.GET
  )
  public String add(HttpServletRequest request,HttpServletResponse response,Model model){
    Integer examinationId = Integer.valueOf(request.getParameter("eid"));
    Integer teacherId = Integer.valueOf(request.getParameter("tid"));

    AchievementCommand command = new AchievementCommand();
    Examination examination = examinationService.find(examinationId);
    Teacher teacher = teacherService.find(teacherId);
    Clazz clazz = teacher.getClazz();
    List<Student> studentList = studentService.findClazz(clazz.getId());

    Subject subject = teacher.getSubject();

    command.setStudentList(studentList);
    command.setSubject(subject);
    command.setExamination(examination);
    command.setTeacher(teacher);
    model.addAttribute("command",command);

    return "/achievement/add";
  }

  @RequestMapping(
      value = "/info",
      method = RequestMethod.GET
  )
  public String info(@RequestParam(value = "eid") Integer examinationId,@RequestParam(value = "tid") Integer teacherId,HttpServletRequest request,HttpServletResponse response,Model model){


    return "/achievement/add";
  }

  @RequestMapping(
      value = "/add",
      method = RequestMethod.POST
  )
  public String add(AchievementCommand command , Model model){
    Achievement achievement = new Achievement();

    achievement.setFraction(command.getFraction());
    achievement.setExamination(examinationService.find(command.getExaminationId()));
    achievement.setSubject(subjectService.find(command.getSubjectId()));
    achievement.setStudent(studentService.find(command.getStudentId()));


    achievementService.add(achievement);
      String url = "redirect:/achievement/info?eid="+command.getExaminationId()+"&tid="+command.getTeacherId();
    return url;
  }



}
