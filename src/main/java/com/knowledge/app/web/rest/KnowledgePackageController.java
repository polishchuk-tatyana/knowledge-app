package com.knowledge.app.web.rest;

import com.knowledge.app.domain.KnowledgePackage;
import com.knowledge.app.domain.KnowledgePackageSet;
import com.knowledge.app.service.KnowledgePackageService;
import com.knowledge.app.service.KnowledgePackageSetService;
import com.knowledge.app.web.dto.FormDataKnowledgePackageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {

    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageSetService knowledgePackageSetService;

    public KnowledgePackageController(
            KnowledgePackageService knowledgePackageService,
            KnowledgePackageSetService knowledgePackageSetService) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageSetService = knowledgePackageSetService;
    }

    @GetMapping
    public String getAllKnowledgePackages(Model model) {
        List<KnowledgePackage> knowledgePackages = knowledgePackageService.findAll();
        model.addAttribute("knowledgePackages", knowledgePackages);
        return "knowledge-package/knowledge-packages";
    }

    @GetMapping("/showAddKnowledgePackageForm")
    public String showFormForAdd(Model model) {
        FormDataKnowledgePackageDTO formDataKnowledgePackageDTO = new FormDataKnowledgePackageDTO();
        List<KnowledgePackageSet> knowledgePackageSets = knowledgePackageSetService.findAll();
        model.addAttribute("formDataKnowledgePackageDTO", formDataKnowledgePackageDTO);
        model.addAttribute("knowledgePackageSets", knowledgePackageSets);
        return "knowledge-package/knowledge-package-form";
    }

    @PostMapping("/addKnowledgePackage")
    public String addKnowledgePackage(
            @ModelAttribute("formDataKnowledgePackageDTO") FormDataKnowledgePackageDTO formDataKnowledgePackageDTO) {
        knowledgePackageService.saveAndAttachToSet(formDataKnowledgePackageDTO);
        return "redirect:/kpacs";
    }

    @DeleteMapping("/{id}")
    public String deleteKnowledgePackage(@PathVariable("id") int knowledgePackageId) {
        knowledgePackageService.delete(knowledgePackageId);
        return "redirect:/kpacs";
    }
}