package ru.dzhinn.echodata.web.gwt.client.widget.navigation;

import com.google.gwt.cell.client.IconCellDecorator;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.web.gwt.client.place.ParameterTokens;
import ru.dzhinn.echodata.web.gwt.client.resources.AppResources;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactCell;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactInfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Dzhioev on 06.02.2017.
 */
public class EchoDataNavigation extends Composite {
    interface Binder extends UiBinder<StackLayoutPanel, EchoDataNavigation> { }
    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    ScrollPanel patientListPanel;
    @UiField
    ScrollPanel templateListPanel;
//    @UiField
//    Button searchPatientButton;



    @UiField(provided = true)
    AppResources appResources;

    PlaceManager placeManager;

    final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();

    @Inject
    public EchoDataNavigation(AppResources appResources, PlaceManager placeManager) {
        this.appResources = appResources;
        this.placeManager = placeManager;

        initWidget(binder.createAndBindUi(this));

        List<ContactInfo> contacts = ContactInfo.getContacts();
        ImageResource maleSilhouette = appResources.maleSilhouette();
        ContactCell contactCell = new ContactCell(maleSilhouette);
        CellList<ContactInfo> cellList = new CellList<ContactInfo>(contactCell);
        cellList.setRowCount(contacts.size(), true);
        cellList.setRowData(0, contacts);

        patientListPanel.add(cellList);

//        Image image = appResources.searchIcon();
//        searchPatientButton.getElement().appendChild(appResources.searchIcon().geE);

//        setTemplateTree();
//        setTemplateCellTree();
    }

//    void setTemplateCellTree(){
//
//
//        CellTree tree = new CellTree(new TreeViewModel() {
//
//            @Override
//            public <T> NodeInfo<?> getNodeInfo(T value) {
//                ListDataProvider<String> dataProvider = new ListDataProvider<String>();
//                for (int i = 0; i < 10; i++) {
//                    dataProvider.getList().add(value + "." + String.valueOf(i));
//                }
//                return new DefaultNodeInfo<String>(dataProvider,
//                        new IconCellDecorator(appResources.folderIcon(), new TextCell()), selectionModel, null);
//            }
//
//            @Override
//            public boolean isLeaf(Object value) {
//                return value.toString().length() > 10;
//            }
//        }, "Item 1");
//
////        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
////        tree.sele
//
//        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//            @Override
//            public void onSelectionChange(SelectionChangeEvent event) {
//                String selected = selectionModel.getSelectedObject();
//                if (selected != null) {
//                    PlaceRequest placeRequest = new PlaceRequest.Builder()
//                            .nameToken(NameTokens.TEMPLATE_LIST)
//                            .with(ParameterTokens.TEMPLATE_CATEGORY_ID, selected)
//                            .build();
//
//                    placeManager.revealPlace(placeRequest);
//                }
//
//            }
//        });
//
//        tree.setAnimationEnabled(true);
//        templateListPanel.add(tree);
//    }

    void setTemplateTree(){
        Tree tree = new Tree();
        TreeItem root = new TreeItem(
                imageItemHTML(appResources.folderIcon(), "foo@example.com"));
        tree.addItem(root);

        addImageItem(root, "Inbox", appResources.folderIcon());
        addImageItem(root, "Drafts", appResources.folderIcon());
        addImageItem(root, "Templates", appResources.folderIcon());
        addImageItem(root, "Sent", appResources.folderIcon());
        addImageItem(root, "Trash", appResources.folderIcon());



        root.setState(true);
        templateListPanel.add(tree);
    }

    private TreeItem addImageItem(TreeItem root, String title,
                                  ImageResource imageProto) {
        TreeItem item = new TreeItem(imageItemHTML(imageProto, title));
        root.addItem(item);
        return item;
    }

    private SafeHtml imageItemHTML(ImageResource imageProto, String title) {
        Image image = AbstractImagePrototype.create(imageProto).createImage();

        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        builder.append(AbstractImagePrototype.create(imageProto).getSafeHtml());
        builder.appendHtmlConstant(" ");
        builder.appendEscaped(title);
        return builder.toSafeHtml();
    }



}

