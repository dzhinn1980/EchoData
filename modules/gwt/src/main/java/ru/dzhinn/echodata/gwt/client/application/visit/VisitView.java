package ru.dzhinn.echodata.gwt.client.application.visit;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.gwt.client.resources.DataGridResources;
import ru.dzhinn.echodata.gwt.shared.dto.visit.VisitModel;

import javax.inject.Inject;
import java.util.List;


public class VisitView extends ViewWithUiHandlers<VisitUiHandlers> implements VisitPresenter.MyView {
    interface Binder extends UiBinder<Widget, VisitView> {
    }


//    @UiField(provided = true)
//    DataGrid<VisitModel> dataGrid;
//    @UiField(provided = true)
//    SimplePager pager;
    @UiField
    Label headerLabel;

    private ListDataProvider<VisitModel> dataProvider = new ListDataProvider<>();

    @Inject
    VisitView(Binder uiBinder, DataGridResources dataGridResources) {

//        initTable(dataGridResources);

//        headerLabel.setText("");

        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setHeaderText(String text) {
        headerLabel.setText("VisitView: patient" + text);
    }

    //    private void initTable(DataGridResources dataGridResources) {
//
//        dataGrid = new DataGrid<VisitModel>(10, dataGridResources);
//        dataGrid.setWidth("500px");
//
//        pager = new SimplePager();
//        pager.setDisplay(dataGrid);
//
//        initTableColumns();
//
//        dataProvider.addDataDisplay(dataGrid);
//
//    }

    @Override
    public void setVisitList(List<VisitModel> models) {
        List<VisitModel> templateList = dataProvider.getList();
        for (VisitModel patient : models) {
            templateList.add(patient);
        }
    }

//    private void initTableColumns() {
//        Column<VisitModel, String> firstNameColumn =
//                new Column<VisitModel, String>(new TextCell()) {
//                    @Override
//                    public String getValue(VisitModel object) {
//                        return object.getVisitDate().toString();
//                    }
//                };
//        dataGrid.addColumn(firstNameColumn, "Template Name");
//
//    }
}
