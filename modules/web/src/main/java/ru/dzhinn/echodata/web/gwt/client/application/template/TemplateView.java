package ru.dzhinn.echodata.web.gwt.client.application.template;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.web.gwt.client.resources.DataGridResources;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactInfo;

import javax.inject.Inject;
import java.util.List;


public class TemplateView extends ViewWithUiHandlers<TemplateUiHandlers> implements TemplatePresenter.MyView {
    interface Binder extends UiBinder<Widget, TemplateView> {
    }


    @UiField(provided = true)
    DataGrid<ContactInfo> dataGrid;
    @UiField(provided = true)
    SimplePager pager;

    private ListDataProvider<ContactInfo> dataProvider = new ListDataProvider<ContactInfo>();

    @Inject
    TemplateView(Binder uiBinder, DataGridResources dataGridResources) {

        initTable(dataGridResources);

        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initTable(DataGridResources dataGridResources) {

        dataGrid = new DataGrid<ContactInfo>(10, dataGridResources);
        dataGrid.setWidth("100%");

        pager = new SimplePager();
        pager.setDisplay(dataGrid);

        initTableColumns();

        List<ContactInfo> contacts = dataProvider.getList();
        for (ContactInfo contactInfo : ContactInfo.getContacts()) {
            contacts.add(contactInfo);
        }
        dataProvider.addDataDisplay(dataGrid);

    }

    private void initTableColumns() {
        Column<ContactInfo, String> firstNameColumn =
                new Column<ContactInfo, String>(new EditTextCell()) {
                    @Override
                    public String getValue(ContactInfo object) {
                        return object.getFullName();
                    }
                };
        dataGrid.addColumn(firstNameColumn, "Column 1");

        Column<ContactInfo, String> addressColumn =
                new Column<ContactInfo, String>(new EditTextCell()) {
                    @Override
                    public String getValue(ContactInfo object) {
                        return object.getAddress();
                    }
                };
        dataGrid.addColumn(addressColumn, "Column 2");
    }
}
