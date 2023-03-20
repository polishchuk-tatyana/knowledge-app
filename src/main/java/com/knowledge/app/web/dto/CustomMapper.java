package com.knowledge.app.web.dto;

import com.knowledge.app.domain.KnowledgePackage;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class CustomMapper {
       public KnowledgePackage toKnowledgePackage(FormDataKnowledgePackageDTO formDataKnowledgePackageDTO){
        return new KnowledgePackage(
                formDataKnowledgePackageDTO.getTitle(),
                formDataKnowledgePackageDTO.getDescription(),
                LocalDate.now());
    }
}