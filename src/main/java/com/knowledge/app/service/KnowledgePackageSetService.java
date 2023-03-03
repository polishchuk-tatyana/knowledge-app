package com.knowledge.app.service;

import com.knowledge.app.domain.KnowledgePackageSet;
import com.knowledge.app.repository.KnowledgePackageSetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KnowledgePackageSetService {

    @Autowired
    private KnowledgePackageSetRepository knowledgePackageSetRepository;

    public List<KnowledgePackageSet> findAll(){
        return knowledgePackageSetRepository.findAll();
    }
}
