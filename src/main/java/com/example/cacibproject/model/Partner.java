package com.example.cacibproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Partner {
    public Long getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescription() {
        return description;
    }

    public String getProcessedFlowType() {
        return processedFlowType;
    }

    public String getApplication() {
        return application;
    }

    public String getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setProcessedFlowType(String processedFlowType) {
        this.processedFlowType = processedFlowType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String type;
    private String direction;
    private String application;
    private String processedFlowType;
    private String description;


}