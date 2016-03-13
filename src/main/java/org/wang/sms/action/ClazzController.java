package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.sms.command.ClazzCommand;
import org.wang.sms.dao.AdminDao;
import org.wang.sms.dao.ClazzDao;
import org.wang.sms.model.Admin;
import org.wang.sms.model.Clazz;
import org.wang.sms.model.Student;
import org.wang.sms.service.ClazzService;
import org.wang.sms.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Wang on 16/3/6.
 */
@Controller
@RequestMapping(value = "/clazz")
public class ClazzController {

  @Autowired
  private ClazzService clazzService;
  @Autowired
  private StudentService studentService;

  @RequestMapping(
      value = "/info",
      method = RequestMethod.GET
  )
  public String info(HttpServletRequest request,HttpServletResponse response,Integer id,Model model){

    Clazz clazz = clazzService.find(id);
    List<Student> studentList = studentService.findClazz(id);
    model.addAttribute("clazz",new ClazzCommand(clazz));
    model.addAttribute("studentList",studentList);

    return "/clazz/info";
  }

  @RequestMapping(
      value = "/list",
      method = RequestMethod.GET
  )
  public String list(HttpServletRequest request,HttpServletResponse response,Integer id,Model model){


    List<Clazz> clazzList  = clazzService.list();
    List<ClazzCommand> clazzCommandList = new ArrayList<ClazzCommand>();

    for(Clazz clazz : clazzList){
      clazzCommandList.add(new ClazzCommand(clazz));
    }

    model.addAttribute("clazzList",clazzCommandList);

    return "/clazz/list";
  }

}
