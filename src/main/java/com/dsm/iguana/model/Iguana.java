package com.dsm.iguana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Iguana {


    @Id
    private String id;
    private String name;
    private String binomialName;
    private String wikiLink;

    private String[] alternateNames;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBinomialName() {
        return binomialName;
    }

    public void setBinomialName(String binomialName) {
        this.binomialName = binomialName;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String[] getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(String[] alternateNames) {
        this.alternateNames = alternateNames;
    }
}
