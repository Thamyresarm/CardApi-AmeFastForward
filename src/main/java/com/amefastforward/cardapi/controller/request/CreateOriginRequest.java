package com.amefastforward.cardapi.controller.request;

public class CreateOriginRequest {

    private String name;
    private String description;
    private String creator;

    @Override
    public String toString() {
        return "CreateOriginRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
