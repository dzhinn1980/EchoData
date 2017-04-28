package ru.dzhinn.echodata.gwt.shared.dto.template;

import java.io.Serializable;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class TemplateModel implements Serializable {

    private Long id;
    private String name;

    TemplateModel() {
    }

    public TemplateModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
