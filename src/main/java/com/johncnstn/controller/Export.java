package com.johncnstn.controller;

import com.johncnstn.data.service.UserService;
import com.johncnstn.view.CsvView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class Export {

    @Autowired
    private CsvView csvView;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("users", userService.findAll());
        return "";
    }

    @RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
    public String downloadCSV(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        model.put("users", userService.findAll());
        csvView.buildCsvDocument(model, request, response);
        return "";
    }
}
