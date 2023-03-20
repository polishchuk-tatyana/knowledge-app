package com.knowledge.app.web.rest;

import com.knowledge.app.domain.KnowledgePackage;
import com.knowledge.app.domain.KnowledgePackageSet;
import com.knowledge.app.service.KnowledgePackageService;
import com.knowledge.app.service.KnowledgePackageSetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {

    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageService knowledgePackageService;

    public KnowledgePackageSetController(
            KnowledgePackageSetService knowledgePackageSetService,
            KnowledgePackageService knowledgePackageService) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageService = knowledgePackageService;
    }

    @GetMapping
    public String getAllKnowledgePackageSets(Model model) {
        List<KnowledgePackageSet> knowledgePackageSets = knowledgePackageSetService.findAll();
        model.addAttribute("knowledgePackageSets", knowledgePackageSets);
        return "knowledge-package-set/knowledge-package-sets";
    }

    @GetMapping("/showAddKnowledgePackageSetForm")
    public String showFormForAdd(Model model) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        model.addAttribute("knowledgePackageSet", knowledgePackageSet);
        return "knowledge-package-set/knowledge-package-set-form";
    }

    @PostMapping("/addKnowledgePackageSet")
    public String addKnowledgePackageSet(
            @ModelAttribute("knowledgePackageSet") KnowledgePackageSet knowledgePackageSet) {
        knowledgePackageSetService.save(knowledgePackageSet);
        return "redirect:/sets";
    }

    @DeleteMapping("/{id}")
    public String deleteKnowledgePackageSet(@PathVariable("id") int knowledgePackageSetId) {
        knowledgePackageSetService.delete(knowledgePackageSetId);
        return "redirect:/sets";
    }

    @GetMapping("/set/{id}")
    public String getAllKnowledgePackagesOfSet(@PathVariable("id") int id, Model model) {
        List<KnowledgePackage> knowledgePackagesOfSet = knowledgePackageService.findAllByKnowledgePackageSetId(id);
//        knowledgePackagesOfSet.stream().filter(kpac -> kpack.getId() == id).findAny().orElse(null);
        model.addAttribute("knowledgePackagesOfSet", knowledgePackagesOfSet);
        return "knowledge-package-set/knowledge-packages-of-set";
    }
}