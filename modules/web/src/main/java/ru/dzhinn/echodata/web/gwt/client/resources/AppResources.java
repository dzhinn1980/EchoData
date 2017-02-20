package ru.dzhinn.echodata.web.gwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;

/**
 * Created by A.Dzhioev on 07.02.2017.
 */
public interface AppResources extends ClientBundle{

    static final AppResources INSTANCE = GWT.create(AppResources.class);



    @Source(value = "male-silhouette.jpg")
    ImageResource maleSilhouette();

    @Source(value = "folder-icon.png")
    ImageResource folderIcon();

    @Source(value = "search-icon.png")
    ImageResource searchIcon();

    @Source(value = "FreeVector-ECG-Line.jpg")
    ImageResource backgroundImage();

//    @Source(value = "logo_background.png")
//    ImageResource logoBackground();

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Vertical, flipRtl = true)
    @Source("logo_background.png")
    ImageResource logoBackground();

//    @ClientBundle.Source("app.css")
    @Source(value = "app.css")
    public Style css();

    public interface Style extends CssResource {
        String borderTop();
        String borderBottom();
        String borderLeft();
        String borderRight();
    }

}
