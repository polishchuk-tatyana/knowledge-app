package com.knowledge.app.domain;

import java.util.Objects;

public class KnowledgePackageSet {

    private int id;
    private String title;

    public KnowledgePackageSet(int id, String title) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
    }

    public KnowledgePackageSet(){

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
}
