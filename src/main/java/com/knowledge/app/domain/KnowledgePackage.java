package com.knowledge.app.domain;

import java.time.Instant;


public class KnowledgePackage {

    private int id;
    private String title;
    private String description;
    private Instant creatingDate;

    public KnowledgePackage(int id, String title, String description, Instant creatingDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creatingDate = creatingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Instant getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Instant creatingDate) {
        this.creatingDate = creatingDate;
    }
}