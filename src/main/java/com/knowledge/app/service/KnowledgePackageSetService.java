package com.knowledge.app.service;

import com.knowledge.app.domain.KnowledgePackageSet;
import com.knowledge.app.repository.KPacSetAttachmentRepository;
import com.knowledge.app.repository.KnowledgePackageSetRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KnowledgePackageSetService {

    private final KnowledgePackageSetRepository knowledgePackageSetRepository;
    private final KPacSetAttachmentRepository kPacSetAttachmentRepository;

    public KnowledgePackageSetService(
            KnowledgePackageSetRepository knowledgePackageSetRepository,
            KPacSetAttachmentRepository kPacSetAttachmentRepository) {
        this.knowledgePackageSetRepository = knowledgePackageSetRepository;
        this.kPacSetAttachmentRepository = kPacSetAttachmentRepository;
    }

    public List<KnowledgePackageSet> findAll(){
        return knowledgePackageSetRepository.findAll();
    }

    public void save(KnowledgePackageSet knowledgePackageSet){
        knowledgePackageSetRepository.save(knowledgePackageSet);
    }

    public void delete(int knowledgePackageSetId){
        if(kPacSetAttachmentRepository.findAttachedKnowledgePackageSet(knowledgePackageSetId)){
            kPacSetAttachmentRepository.deleteKnowledgePackageSet(knowledgePackageSetId);
        }
        knowledgePackageSetRepository.delete(knowledgePackageSetId);
    }
}