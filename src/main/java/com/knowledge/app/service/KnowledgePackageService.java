package com.knowledge.app.service;

import com.knowledge.app.domain.KnowledgePackage;
import com.knowledge.app.repository.KPacSetAttachmentRepository;
import com.knowledge.app.repository.KnowledgePackageRepository;
import com.knowledge.app.web.dto.CustomMapper;
import com.knowledge.app.web.dto.FormDataKnowledgePackageDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class KnowledgePackageService {

    private final KnowledgePackageRepository knowledgePackageRepository;
    private final KPacSetAttachmentRepository kPacSetAttachmentRepository;
    private CustomMapper mapper;

    public KnowledgePackageService(
            KnowledgePackageRepository knowledgePackageRepository,
            KPacSetAttachmentRepository kPacSetAttachmentRepository,
            CustomMapper mapper) {
        this.knowledgePackageRepository = knowledgePackageRepository;
        this.kPacSetAttachmentRepository = kPacSetAttachmentRepository;
        this.mapper = mapper;
    }

    public List<KnowledgePackage> findAll() {
        return knowledgePackageRepository.findAll();
    }

    public void save(FormDataKnowledgePackageDTO formDataKnowledgePackageDTO) {
        KnowledgePackage knowledgePackage = mapper.toKnowledgePackage(formDataKnowledgePackageDTO);
        knowledgePackageRepository.save(knowledgePackage);
    }

    public void saveAndAttachToSet(FormDataKnowledgePackageDTO formDataKnowledgePackageDTO) {
        save(formDataKnowledgePackageDTO);
        kPacSetAttachmentRepository.attach(
                knowledgePackageRepository.getLastKnowledgePackageId(),
                formDataKnowledgePackageDTO.getKnowledgePackageSetId()
        );
    }

    public void delete(int knowledgePackageId) {
        kPacSetAttachmentRepository.deleteKnowledgePackage(knowledgePackageId);
        knowledgePackageRepository.delete(knowledgePackageId);
    }

    public List<KnowledgePackage> findAllByKnowledgePackageSetId(int id) {
        return knowledgePackageRepository.findAllByKnowledgePackageSetId(id);
    }
}