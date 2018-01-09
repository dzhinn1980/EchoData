package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.gwt.client.application.ui.ContactCell;
import ru.dzhinn.echodata.gwt.client.resources.AppResources;
import ru.dzhinn.echodata.gwt.client.resources.celllist.CellListResources;
import ru.dzhinn.echodata.gwt.client.resources.celltree.CellTreeResources;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;

import javax.inject.Inject;
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

    final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();

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

    void setTemplateCellTree(){

        CellTree tree = new CellTree(new TreeViewModel() {

            @Override
            public <T> NodeInfo<?> getNodeInfo(T value) {
                ListDataProvider<String> dataProvider = new ListDataProvider<String>();
                for (int i = 0; i < 10; i++) {
                    dataProvider.getList().add(value + "." + String.valueOf(i));
                }
                return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
            }

            @Override
            public boolean isLeaf(Object value) {
                return value.toString().length() > 16;
            }
        }, "Структура 1", cellTreeResources);

//        tree.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                String selected = selectionModel.getSelectedObject();
                if (selected != null) {
                        getUiHandlers().onTemplateSelectionChange(selected);
                }

            }
        });

        tree.setAnimationEnabled(true);
        templateListPanel.add(tree);
    }
}
