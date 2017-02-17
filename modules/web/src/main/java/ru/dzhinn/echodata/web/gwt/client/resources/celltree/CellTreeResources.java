package ru.dzhinn.echodata.web.gwt.client.resources.celltree;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;

/**
 * Created by A.Dzhioev on 14.02.2017.
 */
public interface CellTreeResources extends CellTree.Resources {
    static final CellTreeResources INSTANCE = GWT.create(CellTreeResources.class);

    @Source("left.png")
    ImageResource cellTreeClosedItem();

    @Source("down.png")
    ImageResource cellTreeOpenItem();

//    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal, flipRtl = true)
//    @Source("down.png")
//    ImageResource cellTreeSelectedBackground();

    @Source(value = {"CellTreeResources.css"})
    CellTree.Style cellTreeStyle();


}
