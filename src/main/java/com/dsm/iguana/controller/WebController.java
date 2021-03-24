package com.dsm.iguana.controller;

import com.dsm.iguana.model.IguanaForm;
import com.dsm.iguana.service.IguanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    private IguanaService iguanaService;

    @RequestMapping({"/", "/home"})
    public String index(Model model) {
        model.addAttribute("iguanaForm", new IguanaForm());
        model.addAttribute("iguanas", iguanaService.findAll());
        return "index";
    }

    @RequestMapping(value="/search")
    public String search(@ModelAttribute("iguanaForm") IguanaForm iguanaForm, BindingResult result, Model model) {
        model.addAttribute("iguanas", iguanaService.search(iguanaForm.getUserInput()));
        return "index";
    }
}
