package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;
import ru.dzhinn.echodata.gwt.client.application.ui.ContactCell;
import ru.dzhinn.echodata.gwt.client.resources.AppResources;
import ru.dzhinn.echodata.gwt.client.resources.celllist.CellListResources;
import ru.dzhinn.echodata.gwt.client.resources.celltree.CellTreeResources;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class NavigationView extends ViewWithUiHandlers<NavigationUiHandlers> implements NavigationPresenter.MyView {
    interface Binder extends UiBinder<Widget, NavigationView> {
    }

    @UiField(provided = true)
    AppResources appResources;
    @UiField
    ScrollPanel patientListPanel;
    @UiField
    ScrollPanel templateListPanel;

//    final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();

    ProvidesKey<PatientModel> keyProvider = new ProvidesKey<PatientModel>() {
        @Override
        public Object getKey(PatientModel item) {
            return item.getId();
        }
    };
    final SingleSelectionModel<PatientModel> patientSelectionModel = new SingleSelectionModel<PatientModel>(keyProvider);

    CellList<PatientModel> cellList;
    CellTreeResources cellTreeResources;
//    @Inject
    CellListResources cellListResources;

    TemplateTreeViewModel model;

    @Inject
    NavigationView(Binder uiBinder, AppResources appResources, CellTreeResources cellTreeResources, CellListResources cellListResources) {
        this.appResources = appResources;
        this.cellTreeResources = cellTreeResources;
        this.cellListResources = cellListResources;

        initWidget(uiBinder.createAndBindUi(this));

        ImageResource maleSilhouette = appResources.maleSilhouette();
        ContactCell contactCell = new ContactCell(maleSilhouette);
        cellList = new CellList<PatientModel>(contactCell, cellListResources);
        cellList.setSelectionModel(patientSelectionModel);
        patientSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                PatientModel model = patientSelectionModel.getSelectedObject();
                getUiHandlers().patientSelectionChange(model);
            }
        });

        patientListPanel.add(cellList);
    }

    @Override
    public void setPatientList(List<PatientModel> models) {
        cellList.setRowCount(models.size(), true);
        cellList.setRowData(0, models);
    }

    public void initTemplateCellTree(List<TemplateTreeModel> highLevelTemplateList){

        ProvidesKey<TemplateTreeModel> keyProvider = new ProvidesKey<TemplateTreeModel>() {
            @Override
            public Object getKey(TemplateTreeModel item) {
                return item.getId();
            }
        };

        SingleSelectionModel<TemplateTreeModel> templateSelectionModel = new SingleSelectionModel<>(keyProvider);
        templateSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                TemplateTreeModel model = templateSelectionModel.getSelectedObject();
                getUiHandlers().onTemplateSelectionChange(model);
            }
        });

        model = new TemplateTreeViewModel(highLevelTemplateList, templateSelectionModel);

        CellTree tree = new CellTree(model, null, cellTreeResources);

        tree.setAnimationEnabled(true);
        templateListPanel.add(tree);
    }
}
