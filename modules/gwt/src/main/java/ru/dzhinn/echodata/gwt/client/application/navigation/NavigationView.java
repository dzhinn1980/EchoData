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

    List<TemplateTreeModel> highLevelTemplateList = new ArrayList<>();

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

        setTemplateCellTree();
    }

    @Override
    public void setPatientList(List<PatientModel> models) {
        cellList.setRowCount(models.size(), true);
        cellList.setRowData(0, models);
    }

    @Override
    public void setHighLevelTemplateList(List<TemplateTreeModel> models) {
        highLevelTemplateList = models;
    }

    void setTemplateCellTree(){

        TemplateTreeViewModel model = new TemplateTreeViewModel(highLevelTemplateList);

        CellTree tree = new CellTree( model, null, cellTreeResources);

//        tree.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

//        model.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//            @Override
//            public void onSelectionChange(SelectionChangeEvent event) {
//                String selected = model.selectionModel.getSelectedObject();
//                if (selected != null) {
//                        getUiHandlers().onTemplateSelectionChange(selected);
//                }
//
//            }
//        });

        tree.setAnimationEnabled(true);
        templateListPanel.add(tree);
    }

    private List<TemplateTreeModel> getTemplateList(){
        List<TemplateTreeModel> result = new ArrayList<>();

        TemplateTreeModel head = new TemplateTreeModel("Head");

        head.setChild(new ArrayList<TemplateTreeModel>());

        for (int i = 0; i < 7; i++){
            head.getChild().add(new TemplateTreeModel("First Level Element №" + (i + 1)));
        }
        return result;
    }
}
