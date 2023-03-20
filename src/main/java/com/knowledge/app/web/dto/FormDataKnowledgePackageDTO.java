package com.knowledge.app.web.dto;

public class FormDataKnowledgePackageDTO {
    private String title;
    private String description;
    private int knowledgePackageSetId;

    public FormDataKnowledgePackageDTO() {
    }

    public FormDataKnowledgePackageDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKnowledgePackageSetId() {
        return knowledgePackageSetId;
    }

    public void setKnowledgePackageSetId(int knowledgePackageSetId) {
        this.knowledgePackageSetId = knowledgePackageSetId;
    }
}