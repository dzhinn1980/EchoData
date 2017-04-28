package ru.dzhinn.echodata.gwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * Date: 11/28/13 9:20 PM
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
public interface DataGridResources extends DataGrid.Resources {
    static final DataGridResources INSTANCE = GWT.create(DataGridResources.class);

    @Source(value = {DataGrid.Style.DEFAULT_CSS, "DataGridStyle.css"})
    DataGrid.Style dataGridStyle();
}
