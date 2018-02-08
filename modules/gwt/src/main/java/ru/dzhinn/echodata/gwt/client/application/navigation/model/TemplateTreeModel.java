package ru.dzhinn.echodata.gwt.client.application.navigation.model;

import java.util.List;

/**
 * Created by A.Dzhioev on 11.01.2018.
 */
public class TemplateTreeModel {

    private String name;
    private List<TemplateTreeModel> child;

    public TemplateTreeModel(String name) {
        this.name = name;
    }

    public TemplateTreeModel(String name, List<TemplateTreeModel> child) {
        this.name = name;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TemplateTreeModel> getChild() {
        return child;
    }

    public void setChild(List<TemplateTreeModel> child) {
        this.child = child;
    }
}
