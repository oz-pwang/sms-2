package org.wang.sms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wang.sms.command.LoginFormCommand;
import org.wang.sms.model.Admin;
import org.wang.sms.model.Student;
import org.wang.sms.model.Teacher;
import org.wang.sms.service.AdminService;
import org.wang.sms.service.StudentService;
import org.wang.sms.service.TeacherService;
import org.wang.sms.until.Constants;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Yang Wang on 8/15/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller public class LoginAction {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Autowired
  StudentService studentService;

  /** TODO: DOCUMENT ME! */
  @Autowired
  TeacherService teacherService;

  @Autowired
  AdminService adminService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * login.
   *
   * @param   request    HttpServletRequest
   * @param   loginForm  LoginForm
   *
   * @return  String
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.POST
  )
  public String login(HttpServletRequest request, LoginFormCommand loginForm) {
    if ("STUDENT".equals(loginForm.getRole())) {
      Student student = studentService.find(loginForm.getUsername(), loginForm.getPassword());

      if (student != null) {
        request.getSession().setAttribute(Constants.USER_NAME_KEY, student.getName());
        request.getSession().setAttribute(Constants.USER_ID_KEY, student.getId());

        return "redirect:/student/info?id=" + student.getId();
      } else {
        return "redirect:/login?failed=true";
      }
    }

    if ("TEACHER".equals(loginForm.getRole())) {
      Teacher teacher = teacherService.find(loginForm.getUsername(), loginForm.getPassword());

      if (teacher != null) {
        request.getSession().setAttribute(Constants.USER_NAME_KEY, teacher.getName());
        request.getSession().setAttribute(Constants.USER_ID_KEY, teacher.getId());

        return "redirect:/teacher/info?id=" + teacher.getId();
      } else {
        return "redirect:/login?failed=true";
      }
    }

    if ("ADMIN".equals(loginForm.getRole())){
      Admin admin = adminService.find(loginForm.getUsername(),loginForm.getPassword());

        if (admin != null){
        return "redirect:/admin/menu?id="+admin.getId();
      }else {
        return "redirect:/login?failed=true";
      }
    }


    else {
      return "redirect:/login?failed=true";
    } // end if-else
  }   // end method login

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * login.
   *
   * @return  String
   */
  @RequestMapping(
    value  = "/login",
    method = RequestMethod.GET
  )
  public String toLoginView() {
    return "login";
  }

} // end class LoginAction
