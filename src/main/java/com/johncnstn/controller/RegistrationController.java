package com.johncnstn.controller;

import com.johncnstn.data.dto.UserDto;
import com.johncnstn.data.entity.User;
import com.johncnstn.data.service.UserService;
import com.johncnstn.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto accountDto,
             BindingResult result, Errors errors) {
        User registered = new User();
        ModelAndView modelAndView = new ModelAndView();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
            modelAndView.setView("login");
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        return modelAndView;
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
