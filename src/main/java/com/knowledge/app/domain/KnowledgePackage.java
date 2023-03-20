package com.knowledge.app.domain;

import java.time.LocalDate;
import java.util.Objects;

public class KnowledgePackage {

    private int id;
    private String title;
    private String description;
    private LocalDate creatingDate;

    public KnowledgePackage(int id, String title, String description, LocalDate creatingDate) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.creatingDate = Objects.requireNonNull(creatingDate);
    }

    public KnowledgePackage(String title, String description, LocalDate creatingDate) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.creatingDate = Objects.requireNonNull(creatingDate);
    }

    public KnowledgePackage(){

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

    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(LocalDate creatingDate) {
        this.creatingDate = creatingDate;
    }

}