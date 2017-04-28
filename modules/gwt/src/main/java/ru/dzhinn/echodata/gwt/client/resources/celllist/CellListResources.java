package ru.dzhinn.echodata.gwt.client.resources.celllist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellList;

/**
 * Created by A.Dzhioev on 09.03.2017.
 */
public interface CellListResources extends CellList.Resources {

    static final CellListResources INSTANCE = GWT.create(CellListResources.class);

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal, flipRtl = true)
    ImageResource cellListSelectedBackground();

    @Source("CellListResources.css")
    CellList.Style cellListStyle();
}
