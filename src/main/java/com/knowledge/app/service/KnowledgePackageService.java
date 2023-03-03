package com.knowledge.app.service;

import com.knowledge.app.domain.KnowledgePackage;
import com.knowledge.app.repository.KnowledgePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KnowledgePackageService {

    @Autowired
    private KnowledgePackageRepository knowledgePackageRepository;

    public List<KnowledgePackage> findAll(){
        return knowledgePackageRepository.findAll();
    }

}
