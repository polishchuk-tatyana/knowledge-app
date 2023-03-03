package com.knowledge.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {

    @GetMapping
    public ModelAndView getAllKnowledgePackageSets()
    {
        return null;
    }

    @PostMapping
    public ModelAndView createKnowledgePackageSet()
    {
        return null;
    }

    @DeleteMapping
    public ModelAndView deleteKnowledgePackageSet()
    {
        return null;
    }

    @GetMapping("/set/{id}")
    public ModelAndView getAllKnowledgePackagesOfSet(
            @PathVariable("id") Long id)
    {
//        knowledgepackages.stream().filter(kpac -> kpack.getId() == id).findAny().orElse(null);
        return null;
    }

}
