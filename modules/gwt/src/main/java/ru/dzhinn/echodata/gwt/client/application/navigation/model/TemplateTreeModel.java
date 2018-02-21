package ru.dzhinn.echodata.gwt.client.application.navigation.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Dzhioev on 11.01.2018.
 */
public class TemplateTreeModel implements Serializable {

    private int id;
    private String name;
    private boolean folder;
    private List<TemplateTreeModel> child;


    TemplateTreeModel() {}

    public TemplateTreeModel(int id, String name, boolean folder) {
        this.id = id;
        this.name = name;
        this.folder = folder;
    }

    public TemplateTreeModel(String name, List<TemplateTreeModel> child) {
        this.name = name;
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public List<TemplateTreeModel> getChild() {
        return child;
    }

    public void setChild(List<TemplateTreeModel> child) {
        this.child = child;
    }
}
