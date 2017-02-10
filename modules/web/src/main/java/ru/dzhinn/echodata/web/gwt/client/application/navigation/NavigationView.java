package ru.dzhinn.echodata.web.gwt.client.application.navigation;

import com.google.gwt.cell.client.IconCellDecorator;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.web.gwt.client.place.ParameterTokens;
import ru.dzhinn.echodata.web.gwt.client.resources.AppResources;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactCell;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactInfo;

import javax.inject.Inject;
import java.util.Arrays;
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

    @Inject
    NavigationView(Binder uiBinder, AppResources appResources) {
        this.appResources = appResources;

        initWidget(uiBinder.createAndBindUi(this));

        ImageResource maleSilhouette = appResources.maleSilhouette();
        ContactCell contactCell = new ContactCell(maleSilhouette);
        CellList<ContactInfo> cellList = new CellList<ContactInfo>(contactCell);
        cellList.setRowCount(contacts.size(), true);
        cellList.setRowData(0, contacts);

        patientListPanel.add(cellList);

        setTemplateCellTree();
    }


    void setTemplateCellTree(){

        CellTree tree = new CellTree(new TreeViewModel() {

            @Override
            public <T> NodeInfo<?> getNodeInfo(T value) {
                ListDataProvider<String> dataProvider = new ListDataProvider<String>();
                for (int i = 0; i < 10; i++) {
                    dataProvider.getList().add(value + "." + String.valueOf(i));
                }
                return new DefaultNodeInfo<String>(dataProvider,
                        new IconCellDecorator(appResources.folderIcon(), new TextCell()), selectionModel, null);
            }

            @Override
            public boolean isLeaf(Object value) {
                return value.toString().length() > 10;
            }
        }, "Item 1");

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


    private static final List<ContactInfo> contacts = Arrays.asList(
            new ContactInfo("fio1", "adr1"),
            new ContactInfo("fio2", "adr2"),
            new ContactInfo("fio3", "adr3"),
            new ContactInfo("fio4", "adr4"),
            new ContactInfo("fio5", "adr5"),
            new ContactInfo("fio6", "adr6"),
            new ContactInfo("fio7", "adr7"),
            new ContactInfo("fio8", "adr8"),
            new ContactInfo("fio9", "adr9"),
            new ContactInfo("fio11", "adr11"),
            new ContactInfo("fio12", "adr12"),
            new ContactInfo("fio13", "adr13"),
            new ContactInfo("fio14", "adr14"),
            new ContactInfo("fio15", "adr15"),
            new ContactInfo("fio16", "adr16"),
            new ContactInfo("fio17", "adr17"),
            new ContactInfo("fio18", "adr18"),
            new ContactInfo("fio19", "adr19")
    );
}
