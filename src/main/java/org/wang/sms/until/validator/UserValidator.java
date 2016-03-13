package org.wang.sms.until.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.wang.sms.command.BaseCommand;

import java.text.SimpleDateFormat;

/**
 * Created by Yang Wang on 16/2/17.
 */
public class UserValidator implements Validator {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public boolean supports(Class clazz) {
    return BaseCommand.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    BaseCommand user = (BaseCommand) target;

    if (!StringUtils.hasText(user.getName())) {
      errors.rejectValue("name", null, "Username is empty.");
    } else if (user.getName().length() < 5) {
      errors.rejectValue("name", null, "Username must be greater than 5 characters.");
    } else if (user.getName().length() > 30) {
      errors.rejectValue("name", null, "Username cannot be less than 30 characters.");
    }

    if (!StringUtils.hasText(user.getPhoneNumber())) {
      errors.rejectValue("phoneNumber", null, "PhoneNumber is empty.");
    } else if (user.getPhoneNumber().length() > 11) {
      errors.rejectValue("phoneNumber", null, "phoneNumber cannot be less than 11 characters.");
    }

    if (user.getAge() == null) {
      errors.rejectValue("age", null, "Age is empty.");
    }

    if (!StringUtils.hasText(user.getIDCardNumber())) {
      errors.rejectValue("IDCardNumber", null, "IDCardNumber is empty.");
    } else if (user.getIDCardNumber().length() != 18) {
      errors.rejectValue("IDCardNumber", null, "IDCardNumber cannot be less than 18 characters.");
    }

    if (StringUtils.hasText(user.getBirthDateString())) {
      try {
        sdf.parse(user.getBirthDateString());
      } catch (Exception e) {
        e.printStackTrace();
        errors.rejectValue("birthDateString", null, "Invalid date format.");
      }
    }
  }
}
