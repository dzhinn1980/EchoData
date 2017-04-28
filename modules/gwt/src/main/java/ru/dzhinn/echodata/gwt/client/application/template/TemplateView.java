package ru.dzhinn.echodata.gwt.client.application.template;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.gwt.client.resources.DataGridResources;
import ru.dzhinn.echodata.gwt.shared.dto.template.TemplateModel;

import javax.inject.Inject;
import java.util.List;


public class TemplateView extends ViewWithUiHandlers<TemplateUiHandlers> implements TemplatePresenter.MyView {
    interface Binder extends UiBinder<Widget, TemplateView> {
    }


    @UiField(provided = true)
    DataGrid<TemplateModel> dataGrid;
    @UiField(provided = true)
    SimplePager pager;

    private ListDataProvider<TemplateModel> dataProvider = new ListDataProvider<>();

    @Inject
    TemplateView(Binder uiBinder, DataGridResources dataGridResources) {

        initTable(dataGridResources);

        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initTable(DataGridResources dataGridResources) {

        dataGrid = new DataGrid<TemplateModel>(10, dataGridResources);
        dataGrid.setWidth("100%");

        pager = new SimplePager();
        pager.setDisplay(dataGrid);

        initTableColumns();

//        List<PatientModel> contacts = dataProvider.getList();
//        for (PatientModel patient : PatientModel.getContacts()) {
//            contacts.add(patient);
//        }
        dataProvider.addDataDisplay(dataGrid);

    }

    @Override
    public void setTemplateList(List<TemplateModel> models) {
        List<TemplateModel> templateList = dataProvider.getList();
        for (TemplateModel patient : models) {
            templateList.add(patient);
        }
    }

    private void initTableColumns() {
        Column<TemplateModel, String> firstNameColumn =
                new Column<TemplateModel, String>(new TextCell()) {
                    @Override
                    public String getValue(TemplateModel object) {
                        return object.getName();
                    }
                };
        dataGrid.addColumn(firstNameColumn, "Template Name");

//        Column<PatientModel, String> addressColumn =
//                new Column<PatientModel, String>(new EditTextCell()) {
//                    @Override
//                    public String getValue(PatientModel object) {
//                        return object.getDateOfBirth();
//                    }
//                };
//        dataGrid.addColumn(addressColumn, "Column 2");
    }
}
