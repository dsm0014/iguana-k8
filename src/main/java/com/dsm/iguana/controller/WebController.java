package com.dsm.iguana.controller;

import com.dsm.iguana.service.IguanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    private IguanaService iguanaService;

    @RequestMapping({"/", "index"})
    public String index(Model model) {
        model.addAttribute("iguanas", iguanaService.findAll());
        return "index";
    }
}
