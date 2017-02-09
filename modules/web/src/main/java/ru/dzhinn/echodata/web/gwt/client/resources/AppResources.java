package ru.dzhinn.echodata.web.gwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by A.Dzhioev on 07.02.2017.
 */
public interface AppResources extends ClientBundle{

    static final AppResources INSTANCE = GWT.create(AppResources.class);

//    @ClientBundle.Source("my.css")
//    public CssResource css();

    @Source(value = "male-silhouette.jpg")
    ImageResource maleSilhouette();

    @Source(value = "folder-icon.png")
    ImageResource folderIcon();

    @Source(value = "search-icon.png")
    ImageResource searchIcon();
}
