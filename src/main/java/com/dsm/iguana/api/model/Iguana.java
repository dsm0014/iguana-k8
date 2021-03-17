package com.dsm.iguana.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Iguana {


    @Id
    private String Id;
    private String name;
    private String species;

    private String[] alternateNames;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(String[] alternateNames) {
        this.alternateNames = alternateNames;
    }
}
