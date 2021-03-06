package com.example.e_med_help.validators;

import com.example.e_med_help.dtos.NewUserDto;
import com.example.e_med_help.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewUserDtoValidator implements Validator{
    
  
    @Autowired
    UsersServiceInterface usi;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewUserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewUserDto user = (NewUserDto) target;

        String userName = user.getName();
        String userSurname = user.getSurname();
        String userUsername = user.getUsername();
        String userPassword1 = user.getPassword1();
        String userPassword2 = user.getPassword2();


        for (Character i : userName.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("name", "name.not.all.chars");
                break;
            }
        }

        if (userName.length()> 40 || userName.length() < 3) {
            errors.rejectValue("name", "name.not.valid.length");
        }


        for (Character i : userSurname.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("surname", "surname.not.all.chars");
                break;
            }
        }

        if (userSurname.length() > 40 || userSurname.length() < 3) {
            errors.rejectValue("surname", "surname.not.valid.length");
        }

        if (userUsername.length() > 40 || userUsername.length() < 3) {
            errors.rejectValue("username", "username.not.valid.length");
        }

        if (usi.getUserByUsername(userUsername) != null) {
            errors.rejectValue("username", "username.already.exists");
        }

        for (Character i : userUsername.toCharArray()) {
            if (!Character.isLetter(i) && !Character.isDigit(i)) {
                errors.rejectValue("username", "username.not.valid.chars");
                break;
            }
        }

        if (userPassword1.length() > 40 || userPassword1.length() < 5) {
            errors.rejectValue("password1", "pass.not.valid.length");
        }

        if (!userPassword1.equals(userPassword2)) {
            errors.rejectValue("password2", "pass.not.match");
        }
    }

}
