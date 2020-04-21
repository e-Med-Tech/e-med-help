package com.example.e_med_help.validators;


import com.example.e_med_help.dtos.LoginUserDto;
import com.example.e_med_help.models.User;
import com.example.e_med_help.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginUserValidator implements Validator{
    
    @Autowired
    UsersServiceInterface usi;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginUserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginUserDto user = (LoginUserDto) target;

        String userUsername = user.getLousername();
        String userPassword = user.getLopassword();

        User dbUser = usi.getUserByUsername(userUsername);
        if (dbUser == null) {
            errors.rejectValue("lousername", "lousername.not.exist");
        } else {
            if (!passwordEncoder.matches(userPassword, dbUser.getUPassword())) {
                errors.rejectValue("lopassword", "lopassword.not.correct");
            }
        }
    }
    
}
