package com.knowledge.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {

    @GetMapping
    public ModelAndView getAllKnowledgePackages(
            Model model,
            @RequestParam(name = "name", required = false, defaultValue = "tttttt") String name
//            @WebFilter() Pageable pageable
    ) {
        model.addAttribute("m", name);
        return null;
//                new ModelAndView("knowledge-packages", model);
    }

    @PostMapping
    public ModelAndView createKnowledgePackage() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        return null;
    }
}